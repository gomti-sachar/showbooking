package com.example.restservice.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.restservice.models.Movie;
import com.example.restservice.models.Screen;
import com.example.restservice.models.Show;
import com.example.restservice.repositories.ShowRepository;

import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ShowServiceTest {

    @InjectMocks
    private ShowService showService;

    @Mock
    private ShowRepository showRepository;

    @Test
    public void testGetShowsByScreenIdAndMovieIdAndDate() {
        List<Show> shows = new ArrayList<Show>();
    	Show show = new Show();
        Screen screen = new Screen();
        screen.setId(1);
        
        Movie movie = new Movie();
        movie.setId(1);
        
        show.setMovie(movie);
        show.setScreen(screen);
        show.setShowDate(LocalDate.of(2022, 12, 31));
        
        shows.add(show);

       when(showRepository.findByScreenIdAndMovieIdAndShowDate(1, 1, LocalDate.of(2022, 12, 31)))
                .thenReturn(shows);

        List<Show> result = showService.getShowsByScreenIdAndMovieIdAndDate(1, 1, LocalDate.of(2022, 12, 31));

        assertEquals(1, result.size());
        assertEquals(show, result.get(0));

        verify(showRepository, times(1)).findByScreenIdAndMovieIdAndShowDate(1, 1, LocalDate.of(2022, 12, 31));
    }
}
