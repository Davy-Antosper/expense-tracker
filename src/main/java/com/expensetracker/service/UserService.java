package com.expensetracker.service;

import com.expensetracker.entities.User;
import com.expensetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(int userid) {
            logger.info("Getting user by id: "+userid);
            return userRepository.findById(userid);
    }

    public Optional<User> getUserByEmail(String email) {
      return   userRepository.findByEmail(email);
    }
}
