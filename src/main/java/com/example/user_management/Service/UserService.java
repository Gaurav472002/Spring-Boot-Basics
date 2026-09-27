package com.example.user_management.Service;

import com.example.user_management.Entity.User;
import com.example.user_management.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;


    // CREATE
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // GET ALL
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET BY ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // UPDATE
    public User updateUser(Long id, User user) {

        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser == null) {
            return null;
        }

        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setDoj(user.getDoj());
        existingUser.setEmail(user.getEmail());
        existingUser.setDepartment(user.getDepartment());

        return userRepository.save(existingUser);
    }

    // DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}