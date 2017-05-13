package it.sevenbits.eisetask.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model a task.
 */
public class Item {
    private final long id;
    private final String name;


    @JsonCreator
    public Item(@JsonProperty("id") long id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
