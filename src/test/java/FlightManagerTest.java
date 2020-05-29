import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private FlightManager flightManager;
    private Plane plane1;
    private Passenger passenger1, passenger2, passenger3, passenger4;
    private Flight flightDem, flightRep;

    @Before
    public void before() {
        plane1 = new Plane(PlaneType.BOEING747);

        passenger1 = new Passenger("Joe Bidden");
        passenger2 = new Passenger("Bernie Sanders");
        passenger3 = new Passenger("Donald Trump");
        passenger4 = new Passenger("Mike Pence");

        flightRep = new Flight(plane1,"AM001", "WDC","LAX","2020-06-01T08:00:00");
        flightRep.bookPassenger(passenger3);
        flightRep.bookPassenger(passenger4);

        flightDem = new Flight(plane1,"AM002", "LAX","WDC","2020-06-01T10:00:00");
        flightDem.bookPassenger(passenger1);
        flightDem.bookPassenger(passenger2);

        flightManager = new FlightManager("TravelJava");
    }

    @Test
    public void canGetName() {
        assertEquals("TravelJava", flightManager.getName());
    }


    @Test
    public void canCalcBaggageWeightPerCustomer() {
        assertEquals(25.00, flightManager.getMaxBagWeightPerPassenger(flightRep), 0.01);
    }

    @Test
    public void canGetTotalPassengerBaggageWeightForFlight() {
        assertEquals(20.00, flightManager.getTotalPassengerBagWeight(flightDem), 0.01);
    }

    @Test
    public void canGetRemainingFlightBagWeightCapacity() {
        assertEquals(30.00, flightManager.getRemainingFlightBagWeightCapacity(flightDem), 0.01);
    }

    @Test
    public void canSortArrayList() {
        Plane plane2 = new Plane(PlaneType.AIRBUSA380);
        Flight flight5 = new Flight(plane2,"AM002", "LAX","WDC","2020-06-01T10:00:00");
        flight5.bookPassenger(passenger1);
        flight5.bookPassenger(passenger2);
        flight5.bookPassenger(passenger3);
        flight5.bookPassenger(passenger4);

        flightManager.sortPassengersBySeatNo(flight5);

        ArrayList<Integer> sortedResults = new ArrayList<>();
        for(Passenger passenger : flight5.getPassengers()) {
            sortedResults.add(passenger.getSeatNo());
        }

        boolean inOrder = true;
        for(int i = 0; i < sortedResults.size()-1; i++) {
            if(sortedResults.get(i) > sortedResults.get(i + 1)) {
                inOrder = false;
            }
        }
        assertEquals(true, inOrder);
    }
}
