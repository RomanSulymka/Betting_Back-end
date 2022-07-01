package com.project.betting_backend.controller;

import com.project.betting_backend.domain.User;
import com.project.betting_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createNewUser(@RequestBody User user) {
        User newUser = userService.addNewUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setGames(user.getGames());
        user.setCoins(user.getCoins());
        User updatedUser = userService.updateUserInfo(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
