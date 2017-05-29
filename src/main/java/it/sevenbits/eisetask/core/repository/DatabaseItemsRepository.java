package it.sevenbits.eisetask.core.repository;

import it.sevenbits.eisetask.core.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Database repository items.
 */
public class DatabaseItemsRepository implements ItemsRepository {
    private JdbcTemplate jdbcTemplate;
    private long id = 4;

    public DatabaseItemsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Item> getAllItems(final String table) {
        return  jdbcTemplate.query("SELECT id, name FROM " + table,
                new RowMapper<Item>() {
                    @Override
                    public Item mapRow(ResultSet resultSet, int i) throws SQLException {
                        long id = resultSet.getLong(1);
                        String name = resultSet.getString(2);
                        System.out.println("table = "+ table +";id = "+id+";name = "+name);
                        return new Item(id, name);
                    }
                });
    }

    @Override
    public List<Item> getSomeItems(final String table, final String condition) {
        return jdbcTemplate.query("SELECT id, name FROM " + table + " WHERE year=" + condition, new RowMapper<Item>() {
            @Override
            public Item mapRow(ResultSet resultSet, int i) throws SQLException {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                return new Item(id, name);
            }
        });
    }

    @Override
    public Item createItem(Item newItem) {
        long id = getNextId();
        String name = newItem.getName();
        int rows = jdbcTemplate.update("INSERT INTO groups (id, name, year) VALUES (?, ?, ?)", id, name, 2013);
        return new Item(id, name);
    }

    @Override
    public Item getItemById(long id) {
        return null;
    }

    @Override
    public Item updateItem(long id, Item newItem) {
        return null;
    }

    @Override
    public void deleteItem(long id) {

    }

    private long getNextId() {
        return this.id++;
    }
}
