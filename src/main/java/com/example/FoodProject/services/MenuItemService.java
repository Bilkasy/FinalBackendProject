package com.example.FoodProject.services;

import com.example.FoodProject.model.MenuItem;
import com.example.FoodProject.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

//   List<MenuItem> items = menuItemRepository.findAll();

    public MenuItemService() {
    }

    public List<MenuItem> getAllItems()
    {

        return menuItemRepository.findAll();
    }

    public MenuItem findByName(String name)
    {

        return menuItemRepository.findByName(name);
    }

    public String addMenuItem(MenuItem item)
    {
        menuItemRepository.save(item);
        return "MenuItem is added Successfully";
    }

    public void updateMenuItem(String name, MenuItem item) {
        menuItemRepository.save(item);
    }

    public void deleteMenuItem(int id)
    {
        menuItemRepository.deleteById(id);
    }
}
