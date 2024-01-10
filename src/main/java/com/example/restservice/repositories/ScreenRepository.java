package com.example.restservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.models.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {

}
