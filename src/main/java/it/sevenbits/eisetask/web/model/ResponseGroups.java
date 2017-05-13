package it.sevenbits.eisetask.web.model;

import it.sevenbits.eisetask.core.model.Item;

import java.util.List;

/**
 * response groups
 */
public class ResponseGroups extends Response {

    private List<Item> groups;
    private boolean success = true;
    private Integer errors = null;

    public ResponseGroups(List<Item> groups) {
        this.groups = groups;
    }

    public List<Item> getGroups() {
        return groups;
    }
    public boolean isSuccess() {
        return success;
    }

    public Integer getErrors() {
        return errors;
    }
}
