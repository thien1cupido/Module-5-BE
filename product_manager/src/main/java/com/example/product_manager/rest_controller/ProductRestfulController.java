package com.example.product_manager.rest_controller;

import com.example.product_manager.model.Product;
import com.example.product_manager.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/product")
@CrossOrigin("*")
public class ProductRestfulController {
    @Autowired
    private IProductService iProductService;
    @GetMapping("/list")
    public ResponseEntity<List<Product>> showList() {
        return new ResponseEntity<>(iProductService.findAll(), HttpStatus.OK);
    }
}
