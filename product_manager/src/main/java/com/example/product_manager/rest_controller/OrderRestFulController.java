package com.example.product_manager.rest_controller;

import com.example.product_manager.model.Order;
import com.example.product_manager.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/order")
@CrossOrigin("*")
public class OrderRestFulController {
    @Autowired
    private IOrderService iOrderService;

    @GetMapping("/list")
    public ResponseEntity<List<Order>> showList() {
        List<Order>orderList=iOrderService.findAll();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @DeleteMapping("/delete-order/{id}")
    public ResponseEntity<Boolean> deleteOder(@PathVariable("id") Integer id) {
        Boolean check = iOrderService.deleteOrder(id);
        return new ResponseEntity<>(check, HttpStatus.OK);
    }
    @PostMapping("/create-order")
    public ResponseEntity<Boolean> createOrder(@ModelAttribute("values")Order order) {
        Boolean check=iOrderService.addNewOrder(order);
        return new ResponseEntity<>(check, HttpStatus.OK);
    }
}
