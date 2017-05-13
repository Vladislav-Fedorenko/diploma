package it.sevenbits.eisetask.web.model;

import it.sevenbits.eisetask.core.model.Item;

import java.util.List;

/**
 * response specializations
 */
public class ResponseSpecializations extends Response {
    private List<Item> specializations;
    private boolean success = true;
    private Integer errors = null;

    public ResponseSpecializations(List<Item> specializations) {
        this.specializations = specializations;
    }

    public List<Item> getSpecializations() {
        return specializations;
    }

    public boolean isSuccess() {
        return success;
    }

    public Integer getErrors() {
        return errors;
    }
}
