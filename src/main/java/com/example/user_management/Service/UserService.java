package com.example.user_management.Service;

import com.example.user_management.DTO.UserRequestDTO;
import com.example.user_management.DTO.UserResponseDTO;
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
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

        User user = new User();

        user.setName(userRequestDTO.getName());
        user.setAge(userRequestDTO.getAge());
        user.setDoj(userRequestDTO.getDoj());
        user.setEmail(userRequestDTO.getEmail());
        user.setDepartment(userRequestDTO.getDepartment());
        user.setSalary(userRequestDTO.getSalary());

        User savedUser = userRepository.save(user);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getAge(),
                savedUser.getDoj(),
                savedUser.getEmail(),
                savedUser.getDepartment()
        );
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