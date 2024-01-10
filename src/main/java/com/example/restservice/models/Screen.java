package com.example.restservice.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "screens")
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "name")
    private String name;
   
    @JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theatre_id", nullable = false, referencedColumnName  = "id")
    private Theatre theatre;
    
    @JsonManagedReference(value="screen-show")
    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<Show> shows;
	
    @JsonManagedReference(value="screen-seats")
	@OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<Seat> seats;

    public Screen() {
    }
    
    public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShow(List<Show> shows) {
		this.shows = shows;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

	@Override
	public String toString() {
		return "Screen [id=" + id + ", name=" + name + ", theatre=" + theatre + ", shows=" + shows + ", seats=" + seats
				+ "]";
	}
}
