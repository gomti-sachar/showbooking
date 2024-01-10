package com.example.restservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
	private User user;
    
    @JsonBackReference(value="show-booking")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "show_id", nullable = false, referencedColumnName  = "id")
	private Show show;

	public Booking() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}
}