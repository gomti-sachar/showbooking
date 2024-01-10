package com.example.restservice;

import com.example.restservice.models.Show;
import com.example.restservice.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {
    private final ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @GetMapping("/{id}")
    public Show getShowById(@PathVariable Integer id) {
        return showService.getShowById(id);
    }

    @PostMapping
    public Show createShow(@RequestBody Show show) {
        return showService.createShow(show);
    }

    @PutMapping("/{id}")
    public Show updateShow(@PathVariable Integer id, @RequestBody Show show) {
        show.setId(id);
        return showService.updateShow(show);
    }

    @DeleteMapping("/{id}")
    public void deleteShow(@PathVariable Integer id) {
        showService.deleteShow(id);
    }
    
    @PostMapping("/bulk")
    public List<Show> createShows(@RequestBody List<Show> shows) {
        return showService.createShows(shows);
    }
    
    @GetMapping("/shows")
    public ResponseEntity<List<Show>> getShowsByScreenIdAndMovieId(@RequestParam(name="screen_id") Integer screenId, @RequestParam(name="movie_id") Integer movieId) {
    	List<Show> listResponse = new ArrayList<Show>();
    	listResponse = showService.getShowsByScreenIdAndMovieId(screenId, movieId);
        
        if (listResponse.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(listResponse, HttpStatus.OK);
    }
    
    @GetMapping("/showsbydate")
    public List<Show> getShowsByScreenIdAndMovieIdAndDate(@RequestParam(name="screen_id") Integer screenId, @RequestParam(name="movie_id") Integer movieId, @RequestParam(name="showDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return showService.getShowsByScreenIdAndMovieIdAndDate(screenId, movieId, date);
    }
    
}
