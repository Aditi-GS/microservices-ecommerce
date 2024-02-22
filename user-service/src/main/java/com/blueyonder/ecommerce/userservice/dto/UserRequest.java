package com.blueyonder.ecommerce.userservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserRequest {
    private String name;
    private String password;
    private String verifypassword;
    private String email;
}
