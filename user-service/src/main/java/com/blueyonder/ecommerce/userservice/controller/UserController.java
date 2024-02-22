package com.blueyonder.ecommerce.userservice.controller;

import com.blueyonder.ecommerce.userservice.dto.UserRequest;
import com.blueyonder.ecommerce.userservice.dto.UserResponse;
import com.blueyonder.ecommerce.userservice.exceptions.PasswordMismatchException;
import com.blueyonder.ecommerce.userservice.exceptions.UserAlreadyExistsException;
import com.blueyonder.ecommerce.userservice.exceptions.UserNameNotFoundException;
import com.blueyonder.ecommerce.userservice.model.User;
import com.blueyonder.ecommerce.userservice.service.UserService;
import com.blueyonder.ecommerce.userservice.util.UserUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/ecommerce/user")
public class UserController {
    @Autowired
    private UserService userService;

    // SIGN UP
    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse userRegistration(@RequestBody UserRequest userRequest) throws PasswordMismatchException, UserAlreadyExistsException {
        User user = userService.userRegistration(userRequest);
        return UserUtility.mapToUserResponse(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse userLogin(@RequestBody Map<String, String> loginDetails) throws UserNameNotFoundException, PasswordMismatchException {
        String userName = loginDetails.get("name");
        String password = loginDetails.get("password");
        User user = userService.userLogin(userName, password);
        return UserUtility.mapToUserResponse(user);
    }
}
