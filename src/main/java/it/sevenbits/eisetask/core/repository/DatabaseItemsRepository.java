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

    public DatabaseItemsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Item> getAllItems(String table) throws SQLException {
        return  jdbcTemplate.query("SELECT id, name FROM " + table,
                new RowMapper<Item>() {
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
        return null;
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
}
