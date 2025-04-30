package com.example.onlinecsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinecsp.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}
