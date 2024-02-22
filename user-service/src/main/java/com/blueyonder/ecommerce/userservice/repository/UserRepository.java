package com.blueyonder.ecommerce.userservice.repository;

import com.blueyonder.ecommerce.userservice.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.userName=:userName")
    Optional<User> findByName(String userName);

    @Query("SELECT U from User U WHERE U.userName=:userName and U.password=:password")
    Optional<User> findValidUser(String userName, String password);
}
