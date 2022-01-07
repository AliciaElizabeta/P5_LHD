package es.ull.passengers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPassenger {

    private Passenger passenger;

    @BeforeEach 
    void setup() throws Exception {
        passenger = new Passenger("012", "Bob", "US");
    }

    @Test
    void IdentifierTest() {
        assertEquals(("012"), passenger.getIdentifier());
    }

    @Test
    void NameTest() {
        assertEquals(("Bob"), passenger.getName());
    }

    @Test
    void CountryTest() {
        assertEquals(("US"), passenger.getCountryCode());
    }
}