package com.app.ecom_application.controllers;

import com.app.ecom_application.models.User;
import com.app.ecom_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

@PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
}

@GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
    return ResponseEntity.ok(userService.getAllUsers());
}

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
           return ResponseEntity.ok(userService.getUser(id));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUserInfo(@PathVariable Long id, @RequestBody User user){
        userService.updateUserInfo(id,user);
        return ResponseEntity.ok("user info updated");
    }
}
