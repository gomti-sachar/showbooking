package com.example.restservice;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.restservice.models.Theatre;
import com.example.restservice.services.TheatreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; // Import the necessary class
import static org.hamcrest.Matchers.equalTo; // Import the necessary class

@SpringBootTest
@AutoConfigureMockMvc
public class TheatreControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private TheatreService theatreService;

		@Test
		public void createTheater() throws Exception {
			Theatre theatre = new Theatre();
			//theatre.setId(1);
			theatre.setName("Theatre 1");

			Mockito.when(theatreService.createTheatre(Mockito.any(Theatre.class))).thenReturn(theatre);

			mockMvc.perform(post("/theatres").contentType(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(theatre)))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.name", equalTo("Theatre 1"))); // Use equalTo instead of is

			Mockito.verify(theatreService, Mockito.times(1)).createTheatre(Mockito.any(Theatre.class));
		}

}
