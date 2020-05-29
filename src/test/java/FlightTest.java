import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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
        flight1 = new Flight(plane1,"AM001", "WDC","LAX","08:00");
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
        assertEquals("08:00", flight1.getDepTime());
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
    public void canAddPassenger() {
        flight1.bookPassenger(passenger1);
        assertEquals(1, flight1.getPassengerNo());
    }

    @Test
    public void cantAddPassengerWhenPlaneFull() {
        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger2);
        flight1.bookPassenger(passenger3);
        assertEquals(2, flight1.getPassengerNo());
    }
}
