package it.sevenbits.eisetask.web.controllers;

import it.sevenbits.eisetask.core.repository.ItemsRepository;
import it.sevenbits.eisetask.web.model.Response;
import it.sevenbits.eisetask.web.model.ResponseGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Controllers for some items
 */
@Controller
@RequestMapping("/{name}/{condition}")
public class SomeItemsControllers {
    private final ItemsRepository itemsRepository;
    @Autowired
    public SomeItemsControllers(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Response getSomeItems(@PathVariable String name, @PathVariable String condition) {
        return new ResponseGroups(itemsRepository.getSomeItems("groups", condition));
    }
}
