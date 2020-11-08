package com.example.FoodProject.services;

import com.example.FoodProject.model.Order;
import com.example.FoodProject.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class OrderService {

        @Autowired
        private OrderRepository orderRepository;

        public List<Order> getAllOrders() {
            return orderRepository.findAll();
        }

        public List<Order> getAllOrdersForOneUser(long userId)
        {
            return orderRepository.findByuserId(userId);
        }
        public void postAnOrder(Order order)
        {
            orderRepository.save(order);
        }
        public Order getOrderById(int id) {
            return orderRepository.findById(id);
        }
    }
