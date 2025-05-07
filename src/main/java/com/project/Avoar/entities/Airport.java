package com.project.Avoar.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String state;
    private String country;
    private String codeIata;

    public Airport(){}

    public Airport(Long id, String name, String city, String state, String country, String codeIata) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.country = country;
        this.codeIata = codeIata;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCodeIata() {
        return codeIata;
    }

    public void setCodeIata(String codeIata) {
        this.codeIata = codeIata;
    }
}
