package com.blueyonder.ecommerce.userservice.dataLoader;

import com.blueyonder.ecommerce.userservice.model.User;
import com.blueyonder.ecommerce.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserDataLoader implements ApplicationRunner {
    @Autowired
    private UserRepository userRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create sample products
        List<User> sampleData = Arrays.asList(
                new User(1, "aditi", "aditi", "aditi", "aditi@gmail.com"),
                new User(2, "nihal", "nihal", "nihal", "nihal@gmail.com"),
                new User(3, "gagan", "gagan", "gagan", "gagan@gmail.com"),
                new User(4, "aryan", "aryan", "aryan", "aryan@gmail.com")
                );

        // populate the db
        userRepo.saveAll(sampleData);
    }
}
