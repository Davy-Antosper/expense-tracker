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
      @Autowired
     private UserMapper userMapper;

    public UserResponseDTO getUserById(int userId) {
        logger.info("Recuperation d un utilisateur by id: " + userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        return userMapper.toResponseDTO(user);
    }

`    @Transactional
    public AuthResponseDTO register(RegisterRequestDTO request) {
        logger.info("Register nouvel user: " + request.email());
 
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new EmailAlreadyUsedException(request.email());
        }
 
        User user = userMapper.toEntity(request);
 
        user.setPassword(passwordEncoder.encode(request.password()));
 
        User saved = userRepository.save(user);
 
        String token = jwtUtil.generateToken(saved.getEmail());
        return new AuthResponseDTO(token, userMapper.toResponseDTO(saved));
    }


    @Transactional
    public AuthResponseDTO login(LoginRequestDTO request) {
        logger.info("Login for: " + request.email());
 
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new BadCredentialsException("Invalid email or password"));
 
        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new BadCredentialsException("Invalid email or password");
        }
 
        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponseDTO(token, userMapper.toResponseDTO(user));
    }
}
