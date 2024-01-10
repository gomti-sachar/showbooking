package com.example.restservice.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.models.Show;

public interface ShowRepository extends JpaRepository<Show, Integer> {
	 List<Show> findByScreenId(Integer screenId);
	 List<Show> findByScreenIdAndMovieId(Integer screenId, Integer movieId);
	 List<Show> findByScreenIdAndMovieIdAndShowDate(Integer screenId, Integer movieId, LocalDate showDate);
}
