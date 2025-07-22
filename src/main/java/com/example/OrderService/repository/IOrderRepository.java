package com.example.OrderService.repository;


import com.example.OrderService.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {


}
