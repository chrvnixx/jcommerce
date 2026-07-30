package com.app.ecom_application.service;

import com.app.ecom_application.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    
    String createUser(User newUser);


    List<User> getAllUsers();

    User getUser(Long id);
}
