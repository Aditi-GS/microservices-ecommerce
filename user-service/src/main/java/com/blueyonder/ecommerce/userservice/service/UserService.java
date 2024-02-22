package com.blueyonder.ecommerce.userservice.service;

import com.blueyonder.ecommerce.userservice.dto.UserRequest;
import com.blueyonder.ecommerce.userservice.exceptions.PasswordMismatchException;
import com.blueyonder.ecommerce.userservice.exceptions.UserAlreadyExistsException;
import com.blueyonder.ecommerce.userservice.exceptions.UserNameNotFoundException;
import com.blueyonder.ecommerce.userservice.model.User;

public interface UserService {
    // SIGN UP - need all details
    User userRegistration(UserRequest userRequest) throws PasswordMismatchException, UserAlreadyExistsException;

    // LOGIN - need username and password OR email and password
    public User userLogin(String userName, String password) throws UserNameNotFoundException, PasswordMismatchException;
}
