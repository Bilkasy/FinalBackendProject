package com.example.FoodProject.repositories;

import com.example.FoodProject.model.Order;
import com.example.FoodProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findByuserId(long userId);
    Order findById(int id);


}
