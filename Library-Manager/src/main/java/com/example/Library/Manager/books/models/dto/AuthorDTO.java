package com.example.Library.Manager.books.models.dto;

import com.example.Library.Manager.books.models.Author;

public class AuthorDTO {
    private int id;
    private String name;
    private String city;
    private String country;
    private String website;

    public AuthorDTO(int id, String name, String city, String country, String website) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.website = website;
    }

    public AuthorDTO(Author author)
    {
        this(author.getId(), author.getName(), author.getCity(), author.getCountry(), author.getWebsite());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
