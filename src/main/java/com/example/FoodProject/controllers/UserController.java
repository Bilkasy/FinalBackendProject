package com.example.FoodProject.controllers;

import com.example.FoodProject.model.User;
import com.example.FoodProject.modelInterfaces.UserControllerInterface;
import com.example.FoodProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController implements UserControllerInterface {

    @Autowired
    UserService userService;

    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    public User getOneUserByName(int id)
    {
        return userService.getOneUserById(id);
    }

    public void addUser(User user)
    {
        userService.addUser(user);
    }

    public void updateUser(int id, User user)
    {
        userService.updateUser(id, user);
    }

    public void deleteUser(int id)
    {
        userService.deleteUser(id);
    }

}
