package it.sevenbits.eisetask.core.repository;

import it.sevenbits.eisetask.core.model.Item;

import java.util.*;

/**
 * Repository items(tasks)
 */
/*
public class LocalItemsRepository implements ItemsRepository {

    private long currentId = 0;
    private Map<Long, Item> items = new HashMap<Long, Item>();

    public LocalItemsRepository(Map<Long, Item> items) {
        this.items = items;
    }

    public LocalItemsRepository() {
        addItem(new Item(items.size(), "call"));
        addItem(new Item(items.size(), "pay"));
        addItem(new Item(items.size(), "sleep"));
    }
    private void addItem(Item item) {
        items.put(currentId, item);
        currentId++;
    }
    @Override
    public List<Item> getAllItems() {
        return null;
        //return Collections.unmodifiableList((List<Item>)items);
    }

    @Override
    public Item createItem(Item newItem) {
        addItem(new Item(currentId, newItem.getName()));
        return items.get(currentId - 1);
    }

    @Override
    public Item getItemById(long id) {
        return items.get(id);
    }

    @Override
    public Item updateItem(long id, Item newItem) {
        items.put(id, new Item(id, newItem.getName()));
        return items.get(id);
    }

    @Override
    public void deleteItem(long id) {
        items.remove(id);
        //items.set((int) id, null);
    }
}
*/
