package com.thoughtworks.movierental;

public class TextStatement {

    private String customerName;
    private Rentals rentals;

    public TextStatement(String customerName, Rentals rentals) {
        this.customerName = customerName;
        this.rentals = rentals;
    }
    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + customerName + "\n";
    }

    private String body() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : rentals) {
            result.append("\t").
                    append(rental.getMovie().getTitle()).
                    append("\t").
                    append(rental.amountFor()).
                    append("\n");
        }
        return result.toString();
    }

    private String footer() {
        String result = "";
        result += "Amount owed is " + rentals.calculateTotalAmount() + "\n";
        result += "You earned " + rentals.calculateFrequentRenterPoints() + " frequent renter points";
        return result;
    }
}