package com.blueyonder.ecommerce.userservice.service;

import com.blueyonder.ecommerce.userservice.dto.UserRequest;
import com.blueyonder.ecommerce.userservice.exceptions.PasswordMismatchException;
import com.blueyonder.ecommerce.userservice.exceptions.UserAlreadyExistsException;
import com.blueyonder.ecommerce.userservice.exceptions.UserNameNotFoundException;
import com.blueyonder.ecommerce.userservice.model.User;
import com.blueyonder.ecommerce.userservice.repository.UserRepository;
import com.blueyonder.ecommerce.userservice.util.UserUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User userRegistration(UserRequest userRequest) throws PasswordMismatchException, UserAlreadyExistsException {
        User newUser = UserUtility.mapToUser(userRequest);
        //System.out.println(newUser);
        Optional<User> oldUser = userRepo.findByName(newUser.getUserName());
        if (oldUser.isPresent()) {
            log.error("User {} already exists. No duplicates allowed.", newUser.getUserName());
            throw new UserAlreadyExistsException();
        }

        else if (!newUser.getPassword().equals(newUser.getVerifypassword())) {
            log.error("Password does not match.");
            throw new PasswordMismatchException();
        }

        else {
            log.info("Registration of User {} successful.", newUser.getUserName());
            return userRepo.save(newUser);
        }
    }

    @Override
    public User userLogin(String userName, String password) throws UserNameNotFoundException, PasswordMismatchException {
        Optional<User> user = userRepo.findByName(userName);
        // no username
        if (user.isEmpty()) {
            log.error("User {} does not exist.", userName);
            throw new UserNameNotFoundException();
        } else {
            Optional<User> oldUser = userRepo.findValidUser(userName, password);
            if (oldUser.isPresent()) {
                log.info("User {} logged in.", userName);
                return oldUser.get();
            } else {
                log.error("Password does not match.");
                throw new PasswordMismatchException();
            }
        }
    }
}
