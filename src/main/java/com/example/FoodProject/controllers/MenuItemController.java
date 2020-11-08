package com.example.FoodProject.controllers;

import com.example.FoodProject.modelInterfaces.MenuItemControllerInterface;
import com.example.FoodProject.services.MenuItemService;
import com.example.FoodProject.model.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuItemController implements MenuItemControllerInterface {

    Logger logger = LoggerFactory.getLogger(MenuItemController.class);

    @Autowired
    MenuItemService menuItemService;

    public List<MenuItem> getAllItems()
    {
        logger.info("Getting all menu items ");
        return menuItemService.getAllItems();
    }

    public MenuItem getOneItemByName(String name)
    {
        logger.info("Getting menu item with name: " + name);
        return menuItemService.findByName(name);
    }

    public void addMenuItem(MenuItem item)
    {
        logger.info("Adding menu item with name: " + item.getName());
        menuItemService.addMenuItem(item);
    }

    public void updateMenuItem(String name, MenuItem item)
    {
        menuItemService.updateMenuItem(name,item);
    }

    public void deleteMenuItem(int id)
    {
        menuItemService.deleteMenuItem(id);
    }

}
