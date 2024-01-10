package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // Import the necessary class
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; // Import the necessary class

@SpringBootTest
@AutoConfigureMockMvc
public class ShowControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetShowsByScreenIdAndMovieIdAndDate() throws Exception {
		this.mockMvc.perform(get("/shows?screenId=1&movieId=1&date=2022-12-31")).andExpect(status().isOk());
	}

	@Test
	public void testCreateShow() throws Exception {
		String showJson = "{\"screen\":{\"id\":5},\"movie\":{\"id\":1},\"showDate\":\"2023-03-31\",\"showTime\":\"10:00\"}";

		mockMvc.perform(post("/shows").contentType(MediaType.APPLICATION_JSON).content(showJson))
				.andExpect(status().isOk());
	}
	@Test
    public void testCreateShows() throws Exception {
        //String showsJson = "[{\"screen\":{\"id\":5},\"movie\":{\"id\":1},\"showDate\":\"2023-03-31\",\"showTime\":\"10:00\"}, {\"screen\":{\"id\":5},\"movie\":{\"id\":1},\"showDate\":\"2023-03-31\",\"showTime\":\"08:30\"}]";

		String showsJson = "[{\"screen\":{\"id\":5},\"movie\":{\"id\":1},\"showDate\":\"2024-02-15\",\"showTime\":\"13:20\"},{\"screen\":{\"id\":7},\"movie\":{\"id\":1},\"showDate\":\"2024-02-16\",\"showTime\":\"08:30\"}]";
		
        mockMvc.perform(post("/shows/bulk")
                .contentType(MediaType.APPLICATION_JSON)
                .content(showsJson))
                .andExpect(status().isOk());
    }
}
