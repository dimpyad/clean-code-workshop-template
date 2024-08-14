package com.thoughtworks.movierental;

public class NewReleaseMovie implements Movie {
    private String title;

    public NewReleaseMovie(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int calculateFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
