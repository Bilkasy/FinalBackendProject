package com.example.FoodProject.controllers;

import com.example.FoodProject.model.Order;
//import com.example.FoodProject.model.OrderMenuItems;
//import com.example.FoodProject.repositories.OrderItemRepository;
import com.example.FoodProject.modelInterfaces.OrderInterface;
import com.example.FoodProject.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController implements OrderInterface {

    Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    OrderService orderService;


    public List<Order> getAllOrders()
    {
        logger.info("Getting all orders");
        return orderService.getAllOrders();
    }

    public Order getOrderById(int id)
    {
        logger.info("Getting an order of id: "+id);
        return orderService.getOrderById(id);

    }

    public List<Order> getUserOrders(Long userId)
    {
        logger.info("Getting all orders for " + userId);
        return orderService.getAllOrdersForOneUser(userId);

    }

    public void postOrder(Order order)
    {
        logger.info("Posting an order for user:  " + order.getUser().getUsername());
        order.setTotalPrice(order.getTotalOrderPrice());
        orderService.postAnOrder(order);
    }

}
