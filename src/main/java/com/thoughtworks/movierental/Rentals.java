package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {

    // Method to calculate the total amount owed
    public double calculateTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : this) {
            totalAmount += rental.amountFor();
        }
        return totalAmount;
    }

    // Method to calculate the frequent renter points
    public int calculateFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : this) {
            frequentRenterPoints++;
            if (rental.isRenterPoints()) frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}
