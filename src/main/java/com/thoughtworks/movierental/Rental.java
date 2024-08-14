package com.thoughtworks.movierental;

public class Rental {
    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double amountFor() {
        return movie.calculateAmount(daysRented);
    }
    int getFrequentRenterPoints() {
        return movie.calculateFrequentRenterPoints(daysRented);
    }
}
