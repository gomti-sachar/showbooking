package com.example.restservice.services;

import com.example.restservice.models.Screen;
import com.example.restservice.repositories.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenService {
    private final ScreenRepository screenRepository;

    @Autowired
    public ScreenService(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    public Screen getScreenById(Integer id) {
        return screenRepository.findById(id).orElse(null);
    }

    public Screen createScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    public Screen updateScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    public void deleteScreen(Integer id) {
        screenRepository.deleteById(id);
    }
}