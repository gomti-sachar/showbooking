package com.example.restservice.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "genre")
    private String genre;
	
	@Column(name = "language")
    private String language;
	
	@Column(name = "duration")
    private Integer duration;
	
	@Column(name = "details")
    private String details;
	
	@JsonManagedReference(value="movie-show")
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Show> shows;

    //create a private constructor
    public Movie() {
    }
    
    public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	public Integer getId() {
  		return id;
  	}

  	public void setId(Integer id) {
  		this.id = id;
  	}

  	public String getGenre() {
  		return genre;
  	}

  	public void setGenre(String genre) {
  		this.genre = genre;
  	}

  	public String getLanguage() {
  		return language;
  	}

  	public void setLanguage(String language) {
  		this.language = language;
  	}

  	public Integer getDuration() {
  		return duration;
  	}

  	public void setDuration(Integer duration) {
  		this.duration = duration;
  	}

  	public String getDetails() {
  		return details;
  	}

  	public void setDetails(String details) {
  		this.details = details;
  	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", genre=" + genre + ", language=" + language + ", duration="
				+ duration + ", details=" + details + ", shows=" + shows + "]";
	}
	
}
