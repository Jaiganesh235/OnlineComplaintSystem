package com.example.onlinecsp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.onlinecsp.dto.DeptDto;
import com.example.onlinecsp.entity.Dept;
import com.example.onlinecsp.repository.DeptRepository;

@Service
public class DeptServiceImpl implements DeptService {

    private final DeptRepository deptRepository;

    
    public DeptServiceImpl(DeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    @Override
    public DeptDto createDept(DeptDto deptDto) {
        Dept dept = new Dept();
        dept.setDeptName(deptDto.getDeptName());

        Dept savedDept = deptRepository.save(dept);
        return new DeptDto(savedDept.getDeptId(), savedDept.getDeptName());
    }

    @Override
    public DeptDto getDeptById(Long id) {
        Dept dept = deptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return new DeptDto(dept.getDeptId(), dept.getDeptName());
    }

    @Override
    public List<DeptDto> getAllDepts() {
        return deptRepository.findAll().stream()
                .map(d -> new DeptDto(d.getDeptId(), d.getDeptName()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDept(Long id) {
        deptRepository.deleteById(id);
    }
}
