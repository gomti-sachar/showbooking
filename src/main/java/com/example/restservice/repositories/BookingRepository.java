package com.example.restservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
