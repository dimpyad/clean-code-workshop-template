package com.thoughtworks.movierental;

public class RegularMovie implements Movie {
    private String title;

    public RegularMovie(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public double calculateAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }

    @Override
    public int calculateFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
