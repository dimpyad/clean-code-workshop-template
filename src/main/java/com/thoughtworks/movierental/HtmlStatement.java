package com.thoughtworks.movierental;

import java.util.List;

public class HtmlStatement {

    private String customerName;
    private Rentals rentals;

    // Constructor to initialize instance variables
    public HtmlStatement(String customerName, Rentals rentals) {
        this.customerName = customerName;
        this.rentals = rentals;
    }

    // Method to generate the HTML statement
    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return "<H3>Rental Record for " + customerName + " </H3><BR>";
    }

    private String body() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : rentals) {
            result.append("<body>")
                    .append(rental.getMovie().getTitle())
                    .append(" ")
                    .append(rental.amountFor())
                    .append("</body><BR>");
        }
        return result.toString();
    }

    private String footer() {
        String result = "";
        result += "<H2>Amount owed is <b>" + rentals.calculateTotalAmount() + "</b>";
        result += "<H2>You earned <b>" + rentals.calculateFrequentRenterPoints() + "</b> frequent renter points</H2>";
        return result;
    }
}
