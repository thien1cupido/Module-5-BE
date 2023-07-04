package com.example.product_manager.service;


import com.example.product_manager.model.Order;

import java.util.List;


public interface IOrderService {
    Order findALlById(Integer id);

    List<Order> findAll();

    Boolean deleteOrder(Integer id);

    Boolean addNewOrder(Order order);
}
