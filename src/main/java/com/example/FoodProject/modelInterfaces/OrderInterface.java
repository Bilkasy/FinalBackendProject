package com.example.FoodProject.modelInterfaces;

import com.example.FoodProject.model.Order;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

public interface OrderInterface {

    @RequestMapping("/orders")
    public List<Order> getAllOrders();

    @RequestMapping("/users/{userId}/orders")
    public List<Order> getUserOrders(@PathVariable(value = "userId") Long userId);

    @RequestMapping(method = RequestMethod.POST,value = "/users/makeOrder")
    public void postOrder(@RequestBody Order order);

    @RequestMapping("/orders/{orderId}")
    public Order getOrderById(@PathVariable("orderId")int id);

}
