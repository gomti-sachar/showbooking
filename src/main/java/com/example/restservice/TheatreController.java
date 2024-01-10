package com.example.restservice;

import com.example.restservice.models.Theatre;
import com.example.restservice.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {
    private final TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @GetMapping
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @GetMapping("/{id}")
    public Theatre getTheatreById(@PathVariable Integer id) {
        return theatreService.getTheatreById(id);
    }

    @PostMapping
    public Theatre createTheatre(@RequestBody Theatre theatre) {
        return theatreService.createTheatre(theatre);
    }

    @PutMapping("/{id}")
    public Theatre updateTheatre(@PathVariable Integer id, @RequestBody Theatre theatre) {
        theatre.setId(id);
        return theatreService.updateTheatre(theatre);
    }

    @DeleteMapping("/{id}")
    public void deleteTheatre(@PathVariable Integer id) {
        theatreService.deleteTheatre(id);
    }
}