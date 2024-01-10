package com.example.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.models.User;
import com.example.restservice.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;
	
	@Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("all")
    List<User> getAllUsers() {
        return userService.getAllUsers();
    } 
}
