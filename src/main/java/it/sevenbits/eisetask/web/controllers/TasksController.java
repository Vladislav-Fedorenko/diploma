package it.sevenbits.eisetask.web.controllers;

import it.sevenbits.eisetask.core.model.Item;
import it.sevenbits.eisetask.core.repository.ItemsRepository;
import it.sevenbits.eisetask.web.model.Response;
import it.sevenbits.eisetask.web.model.ResponseGroups;
import it.sevenbits.eisetask.web.model.ResponseSemesters;
import it.sevenbits.eisetask.web.model.ResponseSpecializations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller for items
 */
@Controller
@RequestMapping("/{name}")
public class TasksController {
    private final ItemsRepository itemsRepository;
    private Map<String, Response> responses = new HashMap<String, Response>();
    @Autowired
    public TasksController(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Response getItems(@PathVariable String name) throws SQLException {
        responses.put("semesters", new ResponseSemesters(itemsRepository.getAllItems(name)));
        responses.put("specializations", new ResponseSpecializations(itemsRepository.getAllItems(name)));

        if(responses.containsKey(name)) {
            System.out.println(name);
            Response tmp = responses.get(name);
            System.out.println(tmp);
            System.out.println("-------------------------------------------");
            return tmp;
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Item> create(@RequestBody Item newItem) {
        Item createdItem = itemsRepository.createItem(newItem);
        URI location = UriComponentsBuilder.fromPath("/items/")
                .path(String.valueOf(createdItem.getId())).build().toUri();
        return ResponseEntity.created(location).body(createdItem);
    }

}
