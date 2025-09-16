package com.viclab.demo_services.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor //todo 是不是可以不写，之后试一下
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String status;
}
