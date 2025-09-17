package com.viclab.demo_services.dao;

import com.viclab.demo_services.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}

