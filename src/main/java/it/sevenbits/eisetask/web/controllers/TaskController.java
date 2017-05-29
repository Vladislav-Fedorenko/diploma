package it.sevenbits.eisetask.web.controllers;

import it.sevenbits.eisetask.core.model.Item;
import it.sevenbits.eisetask.core.repository.ItemsRepository;
import it.sevenbits.eisetask.web.model.Response;
import it.sevenbits.eisetask.web.model.ResponseGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Controller for a item.
 */
@Controller
@RequestMapping("/groups/{year}")
public class TaskController {
    private final ItemsRepository itemsRepository;

    @Autowired
    public TaskController(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Item> create(@PathVariable String year, @RequestBody Item newItem) {
        try {
            Item result = itemsRepository.createItem(newItem);
            URI location = UriComponentsBuilder.fromPath("/groups")
                    .path(String.valueOf(result.getId()))
                    .build().toUri();
            return ResponseEntity.created(location).body(result);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Response getSomeItems(String name, @PathVariable String year) {
        return new ResponseGroups(itemsRepository.getSomeItems("groups", year));
    }

    /*@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Item> get(@PathVariable long id) {

        Item result = itemsRepository.getItemById(id);
        try {
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }*/

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Item> update(@PathVariable long id, @RequestBody Item newItem) {
        try {
            Item result = itemsRepository.updateItem(id, newItem);
            URI location = UriComponentsBuilder.fromPath("/items/")
                    .path(String.valueOf(result.getId()))
                    .build().toUri();
            return ResponseEntity.created(location).body(result);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable long id) {
        try {
            itemsRepository.deleteItem(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
