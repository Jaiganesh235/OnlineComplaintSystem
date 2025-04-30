package com.example.onlinecsp.service;

import java.util.List;

import com.example.onlinecsp.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByRegNo(String regNo);
    List<UserDto> getAllUsers();
    void deleteUser(String regNo);
}
