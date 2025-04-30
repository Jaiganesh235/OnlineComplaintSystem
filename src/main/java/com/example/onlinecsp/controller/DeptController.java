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

import com.example.onlinecsp.dto.DeptDto;
import com.example.onlinecsp.service.DeptService;

@RestController
@RequestMapping("/api/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping
    public DeptDto createDept(@RequestBody DeptDto deptDto) {
        return deptService.createDept(deptDto);
    }

    @GetMapping("/{id}")
    public DeptDto getDeptById(@PathVariable Long id) {
        return deptService.getDeptById(id);
    }

    @GetMapping
    public List<DeptDto> getAllDepts() {
        return deptService.getAllDepts();
    }

    @DeleteMapping("/{id}")
    public void deleteDept(@PathVariable Long id) {
        deptService.deleteDept(id);
    }
}
