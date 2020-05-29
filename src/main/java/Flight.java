import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Flight {

    private Plane plane;
    private String flightNo;
    private String depAirport;
    private String arrAirport;
    private LocalDateTime depTime;
    private ArrayList<Passenger> passengers;
    private ArrayList<Integer> unreservedSeatNos;

    public Flight(Plane plane, String flightNo, String depAirport, String arrAirport, String depTime) {
        this.plane = plane;
        this.flightNo = flightNo;
        this.depAirport = depAirport;
        this.arrAirport = arrAirport;
        // I used LocalDateTime instead of the Date class as it was easier for me to use and allocate
        // Date/Times to
        this.depTime = LocalDateTime.parse(depTime);

        // Passengers list initially empty
        this.passengers = new ArrayList<Passenger>();

        //Initialise availableSeats ArrayList with all available seats dependent on plane capacity
        this.unreservedSeatNos = new ArrayList<Integer>();

        for (int i = 1; i <= this.plane.getCapacity(); i++) {
            this.unreservedSeatNos.add(i);
        }
    }

    public PlaneType getPlaneType() {
        return plane.getPlaneType();
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getDepAirport() {
        return depAirport;
    }

    public String getArrAirport() {
        return arrAirport;
    }

    public LocalDateTime getDepTime() {
        return depTime;
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    public int getPassengerNo() {
        return this.passengers.size();
    }


    public int getNoAvailableSeats() {
        int availableSeats = this.plane.getCapacity() - this.getPassengerNo();
        return availableSeats;
    }

    public void bookPassenger(Passenger passenger) {
        if(getNoAvailableSeats() > 0) {
            passenger.setFlightNo(this.flightNo);

            //We allocate a random, available, seat to passenger
            int index = this.generateRandomIndexNo();
            Integer allocatedSeatNo = this.unreservedSeatNos.remove(index);
            passenger.setSeatNo(allocatedSeatNo);
            this.passengers.add(passenger);
        }
    }

    private int generateRandomIndexNo() {
        // a max and min index number are allocated based on size
        // of list of unreserved seats
        Random random = new Random();
        int max = this.unreservedSeatNos.size();
        // A index number is generated using the above max no for the range
        // (0 up to, but not including, max)
        int randomInt = random.nextInt(max);

        return randomInt;
    }

}
