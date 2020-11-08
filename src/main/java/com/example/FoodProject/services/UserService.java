package com.example.FoodProject.services;

import com.example.FoodProject.model.User;
import com.example.FoodProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public User getOneUserById(long id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public void addUser(User user)
    {
        userRepository.save(user);
    }

    public void updateUser(long id, User user) {
        userRepository.save(user);
    }

    public void deleteUser(long id)
    {
        userRepository.deleteById(id);
    }

}
