package com.elsa.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.elsa.OrderService.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
