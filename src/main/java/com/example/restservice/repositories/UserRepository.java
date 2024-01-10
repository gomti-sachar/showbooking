package com.example.restservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
