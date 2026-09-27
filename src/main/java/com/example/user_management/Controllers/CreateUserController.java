package com.example.user_management.Controller;

import com.example.user_management.Entity.User;
import com.example.user_management.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class CreateUserController {

    @Autowired
    private UserService userService;


    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {

        return userService.createUser(user);
    }
}