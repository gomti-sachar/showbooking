package com.example.restservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.restservice.models.Show;

public class BulkShowCreateRequest {
	private LocalDate date;
	private List<Show> shows = new ArrayList<Show>();
	
	public BulkShowCreateRequest() {
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<Show> getShows() {
		return shows;
	}
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	@Override
	public String toString() {
		return "BulkShowCreateRequest [date=" + date + ", shows=" + shows + "]";
	}
}
