package com.thoughtworks.movierental;

public class ChildrenMovie implements Movie {
    private String title;

    public ChildrenMovie(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public double calculateAmount(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3) {
            amount += (daysRented - 3) * 1.5;
        }
        return amount;
    }

    @Override
    public int calculateFrequentRenterPoints(int daysRented) {
        return 1; // Always 1 frequent renter point
    }
}
