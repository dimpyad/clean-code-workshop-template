package com.thoughtworks.movierental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTests {
    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John");
    }

    @Test
    public void testStatementWithRegularMovie() {
        Movie movie = new RegularMovie("The Matrix");
        Rental rental = new Rental(movie, 3);
        customer.addRental(rental);

        String expectedStatement = "Rental Record for John\n" +
                "\tThe Matrix\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementWithRegularMovieHtml() {
        Movie movie = new RegularMovie("The Matrix");
        Rental rental = new Rental(movie, 3);
        customer.addRental(rental);

        String expectedStatement = "<H3>Rental Record for John </H3><BR>"
                + "<body>The Matrix 3.5</body><BR>" +
                "<H2>Amount owed is <b>3.5</b></H2>" +
                "<H2>You earned <b>1</b> frequent renter points</H2>";

        assertEquals(expectedStatement, customer.htmlStatement());
    }

    @Test
    public void testStatementWithNewReleaseMovie() {
        Movie movie = new NewReleaseMovie("Inception");
        Rental rental = new Rental(movie, 2);
        customer.addRental(rental);

        String expectedStatement = "Rental Record for John\n" +
                "\tInception\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementWithChildrensMovie() {
        Movie movie = new ChildrenMovie("Finding Nemo");
        Rental rental = new Rental(movie, 4);
        customer.addRental(rental);

        String expectedStatement = "Rental Record for John\n" +
                "\tFinding Nemo\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementWithBluRayMovie() {
        Movie movie = new BluRayMovie("The Dark Knight");
        Rental rental = new Rental(movie, 3);
        customer.addRental(rental);

        String expectedStatement = "Rental Record for John\n" +
                "\tThe Dark Knight\t12.0\n" +
                "Amount owed is 12.0\n" +
                "You earned 3 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementWithMultipleRentals() {
        Movie movie1 = new RegularMovie("The Matrix");
        Rental rental1 = new Rental(movie1, 3);
        customer.addRental(rental1);

        Movie movie2 = new NewReleaseMovie("Inception");
        Rental rental2 = new Rental(movie2, 2);
        customer.addRental(rental2);

        Movie movie3 = new ChildrenMovie("Finding Nemo");
        Rental rental3 = new Rental(movie3, 4);
        customer.addRental(rental3);

        Movie movie4 = new BluRayMovie("The Dark Knight");
        Rental rental4 = new Rental(movie4, 3);
        customer.addRental(rental4);

        String expectedStatement = "Rental Record for John\n" +
                "\tThe Matrix\t3.5\n" +
                "\tInception\t6.0\n" +
                "\tFinding Nemo\t3.0\n" +
                "\tThe Dark Knight\t12.0\n" +
                "Amount owed is 24.5\n" +
                "You earned 7 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementWithMultipleRentalsHtml() {
        Movie movie1 = new RegularMovie("The Matrix");
        Rental rental1 = new Rental(movie1, 3);
        customer.addRental(rental1);

        Movie movie2 = new NewReleaseMovie("Inception");
        Rental rental2 = new Rental(movie2, 2);
        customer.addRental(rental2);

        Movie movie3 = new ChildrenMovie("Finding Nemo");
        Rental rental3 = new Rental(movie3, 4);
        customer.addRental(rental3);

        Movie movie4 = new BluRayMovie("The Dark Knight");
        Rental rental4 = new Rental(movie4, 3);
        customer.addRental(rental4);

        String expectedStatement = "<H3>Rental Record for John </H3><BR>" +
                "<body>The Matrix 3.5</body><BR>" +
                "<body>Inception 6.0</body><BR>" +
                "<body>Finding Nemo 3.0</body><BR>" +
                "<body>The Dark Knight 12.0</body><BR>" +
                "<H2>Amount owed is <b>24.5</b></H2>" +
                "<H2>You earned <b>7</b> frequent renter points</H2>";

        assertEquals(expectedStatement, customer.htmlStatement());
    }
}
