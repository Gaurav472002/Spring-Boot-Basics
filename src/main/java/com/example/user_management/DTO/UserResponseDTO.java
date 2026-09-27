package com.example.user_management.DTO;

import java.time.LocalDate;

public class UserResponseDTO {

    private Long id;
    private String name;
    private Integer age;
    private LocalDate doj;
    private String email;
    private String department;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, String name, Integer age,
                           LocalDate doj, String email, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.doj = doj;
        this.email = email;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}