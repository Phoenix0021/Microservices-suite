package com.prac.user_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac.user_service.entity.User;
import com.prac.user_service.repositories.UserRepository;
import com.prac.user_service.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    
    //create user
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    //get all users
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    
    //get user by id
    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
    }

    public ResponseEntity<User> ratingHotelFallback(String userId, Exception e) {
        
        return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

//3510d272-3ca0-427c-badc-5da5a6b0b6c5
    

}
