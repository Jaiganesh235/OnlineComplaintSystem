package com.example.onlinecsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinecsp.dto.UserDto;
import com.example.onlinecsp.service.UserService;  // Ensure the import is correct

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;  // Inject UserService instead of Enter

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/{regNo}")
    public UserDto getUser(@PathVariable String regNo) {
        return userService.getUserByRegNo(regNo);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{regNo}")
    public void deleteUser(@PathVariable String regNo) {
        userService.deleteUser(regNo);
    }
}
