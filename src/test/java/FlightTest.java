import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FlightTest {

    private Flight flight1;
    private Plane plane1;
    private Passenger passenger1, passenger2, passenger3;

    @Before
    public void before() {
        plane1 = new Plane(PlaneType.BOEING747);
        passenger1 = new Passenger("Joe Bidden");
        passenger2 = new Passenger("Bernie Sanders");
        passenger3 = new Passenger("Donald Trump");
        flight1 = new Flight(plane1,"AM001", "WDC","LAX", "2020-06-20T08:00:00");
    }

    @Test
    public void canGetFlightNo() {
        assertEquals("AM001", flight1.getFlightNo());
    }

    @Test
    public void canGetDepAirport() {
        assertEquals("WDC", flight1.getDepAirport());
    }

    @Test
    public void canGetArrAirport() {
        assertEquals("LAX", flight1.getArrAirport());
    }

    @Test
    public void canGetDepTime(){
        assertEquals(LocalDateTime.parse("2020-06-20T08:00:00"), flight1.getDepTime());
    }

    @Test
    public void canGetDepPlane(){
        assertEquals(PlaneType.BOEING747, flight1.getPlaneType());
    }

    @Test
    public void canGetPassengers() {
        flight1.bookPassenger(passenger1);
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        passengers.add(passenger1);
        assertEquals(true, passengers.equals(flight1.getPassengers()));
    }

    @Test
    public void canGetPassengerNo(){
        assertEquals(0, flight1.getPassengerNo());
    }


    @Test
    public void canGetNoAvailableSeats(){
        assertEquals(2, flight1.getNoAvailableSeats());
    }

    @Test
    public void canBookPassenger() {
        assertEquals(null, passenger1.getFlightNo());
        assertEquals(null, passenger1.getSeatNo());
        flight1.bookPassenger(passenger1);
        assertEquals(1, flight1.getPassengerNo());
        assertEquals("AM001", passenger1.getFlightNo());
        assertNotEquals(null, passenger1.getSeatNo());
    }

    @Test
    public void cantAddPassengerWhenPlaneFull() {
        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger2);
        flight1.bookPassenger(passenger3);
        assertEquals(2, flight1.getPassengerNo());
    }

    @Test
    public void passengersHaveUniqueSeatNos() {

        Plane plane2 = new Plane(PlaneType.AIRBUSA380);
        Flight flight2 = new Flight(plane2,"AM090", "WDC","LAX", "2020-06-21T08:00:00");
        Passenger passenger4 = new Passenger("Anon4");
        Passenger passenger5 = new Passenger("Anon5");
        Passenger passenger6 = new Passenger("Anon6");
        Passenger passenger7 = new Passenger("Anon7");
        Passenger passenger8 = new Passenger("Anon8");
        Passenger passenger9 = new Passenger("Anon9");
        Passenger passenger10 = new Passenger("Anon10");
        flight2.bookPassenger(passenger1);
        flight2.bookPassenger(passenger2);
        flight2.bookPassenger(passenger3);
        flight2.bookPassenger(passenger4);
        flight2.bookPassenger(passenger5);
        flight2.bookPassenger(passenger6);
        flight2.bookPassenger(passenger7);
        flight2.bookPassenger(passenger8);
        flight2.bookPassenger(passenger9);
        flight2.bookPassenger(passenger10);
        ArrayList<Passenger> passengers = flight2.getPassengers();
        Boolean duplicates = true;

        // Test to check that all allocated seat numbers are unique
        HashSet set = new HashSet();
        for (int i = 0; i < passengers.size(); i++) {
            boolean val = set.add(passengers.get(i).getSeatNo());
            if (val == false) {
                duplicates = false;
            }
        }

        assertEquals(true, duplicates);
    }

}
