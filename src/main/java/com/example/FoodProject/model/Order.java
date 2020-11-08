package com.example.FoodProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "orders_users")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "order_totalprice")
    private int totalPrice;
    //------------------------------------------------------>
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id",insertable = false,updatable = false, nullable = false)
    @JsonIgnoreProperties(value = {"orders_users", "hibernateLazyInitializer"})
    private User user;
    //------------------------------------------------------>
    @OneToMany(targetEntity = MenuItem.class, fetch = FetchType.LAZY)
    @JoinTable(name = "orders_items2",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    List<MenuItem> orderMenuItems;
    //------------------------------------------------------>

    public Order() {}
    public Order(int orderId, Long userId, User user) {
        this.orderId = orderId;
        this.userId = userId;
        this.user = user;
    }

    public Order(int orderId, long userId, User user, List<MenuItem> orderMenuItems) {
        this.orderId = orderId;
        this.userId = userId;
//        this.totalPrice = this.getTotalOrderPrice();
        this.user = user;
        this.orderMenuItems = orderMenuItems;
    }

    public int getTotalOrderPrice()
    {
        this.totalPrice=0;
        for(int i=0;i<this.orderMenuItems.size();i++)
        {
            this.totalPrice += this.orderMenuItems.get(i).getPrice();
        }
        return this.totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public List<MenuItem> getOrderMenuItems() {
        return orderMenuItems;
    }
    public void setOrderMenuItems(List<MenuItem> orderMenuItems) {
        this.orderMenuItems = orderMenuItems;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", totalPrice=" + totalPrice +
                ", user=" + user +
                ", orderMenuItems=" + orderMenuItems +
                '}';
    }
}
