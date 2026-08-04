package com.app.ecom_application.service;

import com.app.ecom_application.dto.UserRequest;
import com.app.ecom_application.dto.UserResponse;
import com.app.ecom_application.models.User;

import java.util.List;

public interface UserService {


    String createUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();

    UserResponse getUser(Long id);

    Object updateUserInfo(Long id, User user);
}
