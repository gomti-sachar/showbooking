package com.example.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; // Import the necessary class

@SpringBootTest
@AutoConfigureMockMvc
public class TheatreControllerTest {

	@Autowired
	private MockMvc mockMvc;

		@Test
		public void testCreateTheatre() throws Exception {
			String theatreJson = "{\"name\": \"Theatre 5\", \"city\": \"New Delhi\", \"screens\": [{\"name\": \"NDScreen 1\"},{\"name\": \"NDScreen 2\"}]}";

			this.mockMvc.perform(post("/theatres").contentType(MediaType.APPLICATION_JSON).content(theatreJson))
					.andExpect(status().isOk());
			
		}
		
		@Test
	    public void testGetAllTheatres() throws Exception {
	        this.mockMvc.perform(get("/theatres"))
	                .andExpect(status().isOk());
	    }

}
