package com.thoughtworks.movierental;

public class BluRayMovie implements Movie {
    private String title;

    public BluRayMovie(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented * 4;
    }

    @Override
    public int calculateFrequentRenterPoints(int daysRented) {
        return 3; // BluRay movies always give 3 frequent renter points
    }
}
