package com.example.FoodProject.modelInterfaces;

import com.example.FoodProject.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface UserControllerInterface {

    @RequestMapping("/users")
    public List<User> getAllUsers();

    @RequestMapping("/users/{userId}")
    public User getOneUserByName(@PathVariable("userId") int id);

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user);

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}")
    public void updateUser(@PathVariable("userId") int id, @RequestBody User user);

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
    public void deleteUser(@PathVariable("userId") int id);
}
