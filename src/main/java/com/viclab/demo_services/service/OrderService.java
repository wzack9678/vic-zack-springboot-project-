package com.viclab.demo_services.service;

import com.viclab.demo_services.payload.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Long id);
    OrderDTO updateOrder(Long id, OrderDTO orderDTO);
    void deleteOrder(Long id);
}
