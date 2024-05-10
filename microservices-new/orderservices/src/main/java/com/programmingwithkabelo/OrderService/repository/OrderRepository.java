package com.programmingwithkabelo.OrderService.repository;

import com.programmingwithkabelo.OrderService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order,Long> {
}
