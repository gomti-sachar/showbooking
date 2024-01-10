package com.example.restservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.models.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

}
