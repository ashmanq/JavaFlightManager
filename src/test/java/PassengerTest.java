import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger1;
//    private Bag bag1, bag2;

    @Before
    public void before() {
        passenger1 = new Passenger("Brad Pitt");
//        bag1 = new Bag("Suitcase");
//        bag2 = new Bag("Suitcase");
    }

    @Test
    public void canGetName() {
        assertEquals("Brad Pitt", passenger1.getName());
    }

    @Test
    public void canGetSeatNo() {
        assertEquals(null, passenger1.getSeatNo());
    }

    @Test
    public void canGetFlightNo() {
        assertEquals(null, passenger1.getFlightNo());
    }

    @Test
    public void canSetSeatNo() {
        passenger1.setSeatNo(1);
        assertEquals(1, passenger1.getSeatNo().intValue());
    }

    @Test
    public void canSetFlightNo() {
        passenger1.setFlightNo("AM001");
        assertEquals("AM001", passenger1.getFlightNo());
    }



    @Test
    public void canGetTotalBagWeight() {
        assertEquals(10.00, passenger1.getTotalBagWeight(), 0.01);
    }

//    @Test
//    public void canGetNoOfBags() {
//        assertEquals(0, passenger1.getNoOfBags());
//    }
//
//    @Test
//    public void canAddBag() {
//        passenger1.addBag(bag1);
//        assertEquals(1, passenger1.getNoOfBags());
//    }

//    @Test
//    public void canGetTotalBaggageWeight() {
//        passenger1.addBag(bag1);
//        passenger1.addBag(bag2);
//        assertEquals(10.0, passenger1.getTotalBaggageWeight(), 0.01);
//    }

}
