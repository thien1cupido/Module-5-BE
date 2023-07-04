package com.example.product_manager.repository;

import com.example.product_manager.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select * from orders where delete_status=false", nativeQuery = true)
    List<Order> findAllByDeleteStatusIsFalse();

    @Query(value = "UPDATE orders as o SET o.delete_status= 1 WHERE o.id_order = :id", nativeQuery = true)
    void deleteOrderById(@Param("id") Integer id);

    Order findByDeleteStatusIsFalseAndIdOrder(Integer id);
}
