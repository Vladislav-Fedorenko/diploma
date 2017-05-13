package it.sevenbits.eisetask.core.repository;

import it.sevenbits.eisetask.core.model.Item;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface for work with repository items
 */
public interface ItemsRepository {
    List<Item> getAllItems(String table) throws SQLException;

    Item createItem(Item newItem);

    Item getItemById(long id);

    Item updateItem(long id, Item newItem);

    void deleteItem(long id);
}
