package com.michael.users.service;

import com.michael.users.exceptions.payload.UserNotFoundException;
import com.michael.users.payload.request.UserRequest;
import com.michael.users.payload.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long userId) throws UserNotFoundException;

    UserResponse updateUser(Long userId, UserRequest userRequest) throws UserNotFoundException;

    String deleteUser(Long userId) throws UserNotFoundException;

}
