package com.app.ecom_application.service;

import com.app.ecom_application.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    List<User> createUser(User user);

    User getUser(Long id);
}
