package es.ull.flights;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestFlight {
    private Flight flight;

    @BeforeEach 
    void setup() throws Exception {
        flight = new Flight("BA113", 40);
    }

    @Test
    void NumberTest(){
        assertEquals(("BA113"), flight.getFlightNumber());;
    }
    
}
