package com.app.ecom_application.service;

import com.app.ecom_application.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    private List<User> users = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public List<User> createUser(User user) {
        user.setId(nextId++);
         users.add(user);
         return users;
    }

    @Override
    public User getUser(Long id) {
        return users.stream().filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
    }

    @Override
    public String updateUserInfo(User user, Long id) {
        User existingUser = users.stream().filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        return "User with id:" + id + "has been updated";
    }
}
