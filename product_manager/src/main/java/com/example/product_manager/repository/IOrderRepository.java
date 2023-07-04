package com.example.product_manager.repository;

import com.example.product_manager.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select * from orders where delete_status=false", nativeQuery = true)
    List<Order> findAllByDeleteStatusIsFalse();

    @Modifying
    @Transactional
    @Query(value = "UPDATE Order as o SET o.deleteStatus = true WHERE o.idOrder = :id")
    void deleteOrderById(@Param("id") Integer id);

    Order findByDeleteStatusIsFalseAndIdOrder(Integer id);
}
