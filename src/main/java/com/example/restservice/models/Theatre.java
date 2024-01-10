package com.example.restservice.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "theatres")
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "city")
    private String city;
	
    @JsonManagedReference
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "theatre" )
    private List<Screen> screens;

    public Theatre() {
    }
    
    public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

	@Override
	public String toString() {
		return "Theatre [id=" + id + ", name=" + name + ", city=" + city + ", screens=" + screens + "]";
	}
    
}