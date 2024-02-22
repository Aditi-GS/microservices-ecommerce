package com.blueyonder.ecommerce.userservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserResponse {
    private Integer id;
    private String name;
    private String password;
    private String email;
}
