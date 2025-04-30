package com.example.onlinecsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinecsp.entity.Dept;

public interface DeptRepository extends JpaRepository<Dept, Long> {
}
