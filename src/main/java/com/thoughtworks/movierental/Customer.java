package com.thoughtworks.movierental;

public class Customer {
    private final String name;
    private final Rentals rentals;

    public Customer(String name) {
        this.name = name;
        this.rentals = new Rentals();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        TextStatement textStatement = new TextStatement(
                this.name,
                this.rentals
        );
        return textStatement.generate();
    }

    public String htmlStatement() {
        HtmlStatement htmlStatement = new HtmlStatement(
                this.name,
                this.rentals
        );
        return htmlStatement.generate();
    }
}