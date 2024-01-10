package com.example.restservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.models.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
