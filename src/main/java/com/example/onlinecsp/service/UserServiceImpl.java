package com.example.onlinecsp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinecsp.dto.UserDto;
import com.example.onlinecsp.entity.Dept;
import com.example.onlinecsp.entity.User;
import com.example.onlinecsp.repository.DeptRepository;
import com.example.onlinecsp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        Dept dept = deptRepository.findById(userDto.getDeptId())
                .orElseThrow(() -> new RuntimeException("Dept not found"));

        User user = new User(
                userDto.getRegNo(),
                userDto.getName(),
                userDto.getContact(),
                userDto.getPassword(),
                userDto.getRole(),
                dept
        );

        userRepository.save(user);
        return userDto;
    }

    @Override
    public UserDto getUserByRegNo(String regNo) {
        User user = userRepository.findById(regNo)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserDto(
                user.getRegNo(),
                user.getName(),
                user.getContact(),
                user.getPassword(),
                user.getRole(),
                user.getDept().getDeptId()
        );
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(user ->
            new UserDto(
                user.getRegNo(),
                user.getName(),
                user.getContact(),
                user.getPassword(),
                user.getRole(),
                user.getDept().getDeptId()
            )
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(String regNo) {
        userRepository.deleteById(regNo);
    }
}
