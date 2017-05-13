package it.sevenbits.eisetask.web.model;

import it.sevenbits.eisetask.core.model.Item;

import java.util.List;

/**
 * response semesters
 */
public class ResponseSemesters extends Response{
    private List<Item> semesters;
    private boolean success = true;
    private Integer errors = null;

    public ResponseSemesters(List<Item> semesters) {
        this.semesters = semesters;
    }

    public List<Item> getSemesters() {
        return semesters;
    }

    public boolean isSuccess() {
        return success;
    }

    public Integer getErrors() {
        return errors;
    }
}
