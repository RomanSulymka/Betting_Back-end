package com.project.betting_backend.service;

import com.project.betting_backend.domain.User;

import java.util.List;

public interface UserService {
    User addNewUser(User user);
    User updateUserInfo(User user);
    void deleteAccount(Long id);
    User getUserById(Long id);
    List<User> getAllUsers();
}
