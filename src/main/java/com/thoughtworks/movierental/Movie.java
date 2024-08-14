package com.thoughtworks.movierental;

public interface Movie {
    String getTitle();
    double calculateAmount(int daysRented);
    int calculateFrequentRenterPoints(int daysRented);
}
