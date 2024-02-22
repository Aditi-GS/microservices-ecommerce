package com.blueyonder.ecommerce.userservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "name")
    @NotNull
    private String userName;

    @Column(name = "password")
    @NotNull
//    @Pattern(regexp ="^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[#$@!%&?])[A-Za-z\\d#$@!%&?]{8,}$")
    private String password;

    @Transient
    private String verifypassword;

    @Email
//    @Pattern(regexp = ".*@gmail\\.com$")
    private String email;

    // role - admin or not
}
