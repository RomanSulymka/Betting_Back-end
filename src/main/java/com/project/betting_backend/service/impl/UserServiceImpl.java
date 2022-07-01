package com.project.betting_backend.service.impl;

import com.project.betting_backend.domain.User;
import com.project.betting_backend.exceptions.NullEntityReferenceException;
import com.project.betting_backend.repository.UserRepository;
import com.project.betting_backend.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUserInfo(User user) {
        if (user != null) {
            User oldUser = getUserById(user.getId());
            if (oldUser != null) {
                return userRepository.save(user);
            }
        }
        throw new NullEntityReferenceException("User cannot be null");
    }

    @Override
    public void deleteAccount(Long id) {
        User user = getUserById(id);
        if (user != null) {
            userRepository.delete(user);
        } else {
            throw new NullEntityReferenceException("User with id: " + id + " was not found");
        }
    }

    @Override
    public User getUserById(Long id) {
        return userRepository
                .findUserById(id)
                .orElseThrow(() -> new NullEntityReferenceException("User by id: " + id + " was not found"));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.isEmpty() ? new ArrayList<>() : users;
    }
}
