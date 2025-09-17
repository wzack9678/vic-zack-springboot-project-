package com.viclab.demo_services.payload;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;          // 返回时用
    private String name;
    private String description;
    private Double price;
    private String status;    // ACTIVE / INACTIVE
}
