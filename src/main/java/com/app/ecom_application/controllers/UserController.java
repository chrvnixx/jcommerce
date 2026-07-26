package com.app.ecom_application.controllers;

import com.app.ecom_application.models.User;
import com.app.ecom_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
      return ResponseEntity.ok(userService.getUser(id)) ;
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUserInfo(@RequestBody User user, @PathVariable Long Id){
       try {
           return ResponseEntity.ok(userService.updateUserInfo(user, Id)) ;
       }catch (ResponseStatusException e){
           return new ResponseEntity<>(e.getReason(),e.getStatusCode());
       }
    }

    @PostMapping("/users")
    public ResponseEntity<List<User>> createUser(@RequestBody User user){
        List<User> users = userService.createUser(user);
        return ResponseEntity.ok(users);
    }


}
