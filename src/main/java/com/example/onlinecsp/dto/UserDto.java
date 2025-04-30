package com.example.onlinecsp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String regNo;
    private String name;
    private String contact;
    private String password;
    private String role;
    private Long deptId;
}
