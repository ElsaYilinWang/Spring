package com.elsa.ThymeleafDemo.model;

import java.util.List;

public class Student {

    private String firstName;
    private String lastName;

    // add a drop down list for countries
    private String country;

    // radio button for languages
    private String favouriteLanguage;

    private List<String> favouriteSystems;

    public Student(){}

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public List<String> getFavouriteSystems() {
        return favouriteSystems;
    }

    public void setFavouriteSystems(List<String> favouriteSystems) {
        this.favouriteSystems = favouriteSystems;
    }
}
