package com.blueyonder.ecommerce.userservice.util;

import com.blueyonder.ecommerce.userservice.dto.UserRequest;
import com.blueyonder.ecommerce.userservice.dto.UserResponse;
import com.blueyonder.ecommerce.userservice.model.User;

public class UserUtility {

    private UserUtility() {}

    // Response to Model format
    public static User mapToUser(UserRequest userRequest) {
        User user = new User();
        user.setUserName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setVerifypassword(userRequest.getVerifypassword());
        user.setEmail(userRequest.getEmail());
        return user;
    }

    // Model to Request format
    public static UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getUserId());
        userResponse.setName(user.getUserName());
        userResponse.setPassword(user.getPassword());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }
}
