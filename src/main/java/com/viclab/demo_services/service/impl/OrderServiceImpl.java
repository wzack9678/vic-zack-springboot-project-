package com.viclab.demo_services.service.impl;

import com.viclab.demo_services.dao.OrderRepository;
import com.viclab.demo_services.dao.ProductRepository;
import com.viclab.demo_services.dao.UserRepository;
import com.viclab.demo_services.entity.Order;
import com.viclab.demo_services.entity.Product;
import com.viclab.demo_services.entity.User;
import com.viclab.demo_services.exception.ResourceNotFoundException;
import com.viclab.demo_services.payload.OrderDTO;
import com.viclab.demo_services.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Product product = productRepository.findById(orderDTO.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product","id",orderDTO.getProductId()));

        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", orderDTO.getUserId()));

        Order order = new Order();
        order.setQuantity(orderDTO.getQuantity());
        order.setProduct(product);
        order.setUser(user);

        Order savedOrder = orderRepository.save(order);
        return mapToDTO(savedOrder);
    }

    private OrderDTO mapToDTO(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getQuantity(),
                order.getProduct().getId(),
                order.getUser().getId()
        );
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));

        return mapToDTO(order);
    }

    @Override
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));

        Product product = productRepository.findById(orderDTO.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", orderDTO.getProductId()));

        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", orderDTO.getUserId()));

        order.setQuantity(orderDTO.getQuantity());
        order.setProduct(product);
        order.setUser(user);

        return mapToDTO(orderRepository.save(order));

    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        orderRepository.delete(order);
    }
}
