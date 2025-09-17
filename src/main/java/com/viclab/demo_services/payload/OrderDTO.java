package com.viclab.demo_services.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private Integer quantity;

    private Long productId;  // 保存 Product 的 ID，而不是整个 Product 对象
    private Long userId;     // 保存 User 的 ID，而不是整个 User 对象
}
