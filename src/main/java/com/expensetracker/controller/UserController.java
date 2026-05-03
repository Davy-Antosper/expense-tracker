package com.expensetracker.controller;

import com.expensetracker.entities.User;
import com.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private Logger logger = Logger.getLogger(UserController.class.getName());
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> getUserById(@RequestParam int userId){
        logger.info("Getting user by id: "+userId);

        Optional<User> userOptional = userService.getUserById(userId);
        if (userOptional.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
        }

    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String email,@RequestParam String passWord){
        Optional<User> userOptional= userService.getUserByEmail(email);

        if(userOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if(!passWord.equals(userOptional.get().getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
