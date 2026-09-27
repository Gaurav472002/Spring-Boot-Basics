package com.example.user_management.Controllers;

import com.example.user_management.Entity.User;
import com.example.user_management.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private  UserService userService;

    // CREATE
    @PostMapping("createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // GET ALL
    @GetMapping("getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET BY ID
    @GetMapping("getUser/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // UPDATE
    @PutMapping("updateUser/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody User user) {

        return userService.updateUser(id, user);
    }

    // DELETE
    @DeleteMapping("deleteUser/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}