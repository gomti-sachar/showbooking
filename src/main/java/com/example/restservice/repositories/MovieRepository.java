package com.example.restservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
