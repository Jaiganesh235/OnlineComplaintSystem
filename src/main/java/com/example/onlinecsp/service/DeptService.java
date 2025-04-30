package com.example.onlinecsp.service;

import java.util.List;

import com.example.onlinecsp.dto.DeptDto;

public interface DeptService {
    DeptDto createDept(DeptDto deptDto);
    DeptDto getDeptById(Long id);
    List<DeptDto> getAllDepts();
    void deleteDept(Long id);
}
