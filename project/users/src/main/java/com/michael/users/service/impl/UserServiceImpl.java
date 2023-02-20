package com.michael.users.service.impl;

import com.michael.users.entity.User;
import com.michael.users.exceptions.payload.UserNotFoundException;
import com.michael.users.payload.request.UserRequest;
import com.michael.users.payload.response.UserResponse;
import com.michael.users.repository.UserRepository;
import com.michael.users.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = User.builder()
                .userId(UUID.randomUUID().toString())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .encryptedPassword(passwordEncoder.encode(userRequest.getPassword()))
                .build();
        user = userRepository.save(user);
        return mapper.map(user, UserResponse.class);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> mapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(Long userId) throws UserNotFoundException {
        User user = findUserById(userId);
        return mapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse updateUser(Long userId, UserRequest userRequest) throws UserNotFoundException {
        User user = findUserById(userId);
        return null;
    }

    @Override
    public String deleteUser(Long userId) throws UserNotFoundException {
        User user = findUserById(userId);
        userRepository.delete(user);
        return String.format("User with username %s was deleted", user.getUsername());
    }

    private User findUserById(Long userId) throws UserNotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id %s not found", userId)));
    }
}
