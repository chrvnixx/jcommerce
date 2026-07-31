package com.app.ecom_application.service;

import com.app.ecom_application.models.User;

import java.util.List;

public interface UserService {


    String createUser(User user);

    List<User> getAllUsers();

    User getUser(Long id);

    Object updateUserInfo(Long id, User user);
}
