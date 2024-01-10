package com.example.restservice.services;

import com.example.restservice.models.Show;
import com.example.restservice.repositories.MovieRepository;
import com.example.restservice.repositories.ScreenRepository;
import com.example.restservice.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;

    @Autowired
    public ShowService(ShowRepository showRepository, MovieRepository movieRepository, ScreenRepository screenRepository) {
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
        this.screenRepository = screenRepository;
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Show getShowById(Integer id) {
        return showRepository.findById(id).orElse(null);
    }

    public Show createShow(Show show) {
    	Show newShow = new Show();
    	newShow.setMovie(movieRepository.getReferenceById(show.getMovie().getId()));
    	newShow.setScreen(screenRepository.getReferenceById(show.getScreen().getId()));
    	newShow.setShowDate(newShow.getShowDate());
    	newShow.setShowTime(newShow.getShowTime());
    	return showRepository.save(show);
    }

    public Show updateShow(Show show) {
        return showRepository.save(show);
    }

    public void deleteShow(Integer id) {
        showRepository.deleteById(id);
    }
    
    public List<Show> createShows(List<Show> shows) {
    	List<Show> createdShows = new ArrayList<Show>();
    	
    	for(Show show : shows) {
    		createdShows.add(createShow(show));
    	}
    	return createdShows;
    }
    
    public List<Show> getShowsByScreenIdAndMovieId(Integer screenId, Integer movieId) {
    	List<Show> listResponse = new ArrayList<Show>();
    	listResponse = showRepository.findByScreenIdAndMovieId(screenId, movieId);
    	return listResponse;
    }
    
    public List<Show> getShowsByScreenIdAndMovieIdAndDate(Integer screenId, Integer movieId, LocalDate date) {
        return showRepository.findByScreenIdAndMovieIdAndShowDate(screenId, movieId, date);
    }
    
    public List<Show> getShowsByScreenId(Integer screenId) {
        return showRepository.findByScreenId(screenId);
    }
}