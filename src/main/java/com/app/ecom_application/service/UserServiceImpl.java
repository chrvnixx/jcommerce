package com.app.ecom_application.service;

import com.app.ecom_application.models.User;
import com.app.ecom_application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;
//    private List<User> users = new ArrayList<>();
//    private Long nextId = 1L;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String createUser(User user) {
         userRepository.save(user);
         return "User created";
    }

    @Override
    public User getUser(Long id) {
       return userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @Override
    public String updateUserInfo(User user, Long id) {
       User existingUser =  userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
       existingUser.setFirstName(user.getFirstName());
       existingUser.setLastName(user.getLastName());
       return "User has been updated";
    }
}
