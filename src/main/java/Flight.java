import java.util.ArrayList;

public class Flight {

    private Plane plane;
    private String flightNo;
    private String depAirport;
    private String arrAirport;
    private String depTime;
    private ArrayList<Passenger> passengers;

    public Flight(Plane plane, String flightNo, String depAirport, String arrAirport, String depTime) {
        this.plane = plane;
        this.flightNo = flightNo;
        this.depAirport = depAirport;
        this.arrAirport = arrAirport;
        this.depTime = depTime;

        // Passengers list initially empty
        this.passengers = new ArrayList<Passenger>();
    }

    public Plane getPlane() {
        return plane;
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

    public String getDepTime() {
        return depTime;
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
            this.passengers.add(passenger);
        }
    }
}
