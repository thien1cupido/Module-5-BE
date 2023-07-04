package com.example.product_manager.repository;

import com.example.product_manager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = " SELECT * FROM product", nativeQuery = true)
    List<Product> findAllProduct();
}
