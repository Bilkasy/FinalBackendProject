package com.example.FoodProject.modelInterfaces;

import com.example.FoodProject.model.MenuItem;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MenuItemControllerInterface {

    @RequestMapping("/menuitemss")
    public List<MenuItem> getAllItems();

    @RequestMapping("/menuitems/{menuItemName}")
    public MenuItem getOneItemByName(@PathVariable("menuItemName") String name);

    @RequestMapping(method = RequestMethod.POST, value = "/menuitems")
    @PreAuthorize("hasRole('ADMIN')")
    public void addMenuItem(@RequestBody MenuItem item);

    @RequestMapping(method = RequestMethod.PUT, value = "/menuitems/{menuItemName}")
    public void updateMenuItem(@PathVariable("menuItemName") String name, @RequestBody MenuItem item);

    @RequestMapping(method = RequestMethod.DELETE, value = "/menuitems/{menuItemId}")
    public void deleteMenuItem(@PathVariable("menuItemId") int id);

}
