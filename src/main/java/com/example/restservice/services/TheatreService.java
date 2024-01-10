package com.example.restservice.services;

import com.example.restservice.models.Screen;
import com.example.restservice.models.Theatre;
import com.example.restservice.repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    private final TheatreRepository theatreRepository;

    @Autowired
    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Theatre getTheatreById(Integer id) {
        return theatreRepository.findById(id).orElse(null);
    }

    /*public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }*/
    
    public Theatre createTheatre(Theatre theatre) {
    	List<Screen> screens = theatre.getScreens();
    	for (Screen screen : screens) {
    		screen.setTheatre(theatre);
    	}
        return theatreRepository.save(theatre);
    }

    public Theatre updateTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public void deleteTheatre(Integer id) {
        theatreRepository.deleteById(id);
    }
}