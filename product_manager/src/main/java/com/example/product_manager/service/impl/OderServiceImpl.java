package com.example.product_manager.service.impl;

import com.example.product_manager.model.Order;
import com.example.product_manager.repository.IOrderRepository;
import com.example.product_manager.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderServiceImpl implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public Order findALlById(Integer id) {
        return iOrderRepository.findByDeleteStatusIsFalseAndIdOrder(id);
    }

    @Override
    public List<Order> findAll() {
        return iOrderRepository.findAllByDeleteStatusIsFalse();
    }


    @Override
    public Boolean deleteOrder(Integer id) {
        try {
            iOrderRepository.deleteOrderById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean addNewOrder(Order order) {
        try {
            iOrderRepository.save(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
