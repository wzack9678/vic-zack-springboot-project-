package com.viclab.demo_services.dao;

import com.viclab.demo_services.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
