import java.util.ArrayList;

public class FlightManager {

    private String name;

    public FlightManager(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }



    public Double getMaxBagWeightPerPassenger(Flight flight) {

        // We calculate max baggage weight by getting the Total allowed weight, halving it and then dividing
        // that number by the total number of passengers allowed on the plane.
        PlaneType planeType = flight.getPlaneType();
        Double maxBagWeight = (planeType.getTotalWeight()/2)/planeType.getCapacity();

        return maxBagWeight;
    }

    public Double getTotalPassengerBagWeight(Flight flight) {

        Double totalBagWeight = 0.00;

        ArrayList<Passenger> passengers = flight.getPassengers();
        for(Passenger passenger : passengers) {
            totalBagWeight += passenger.getTotalBagWeight();
        }

        return totalBagWeight;
    }

    public Double getRemainingFlightBagWeightCapacity(Flight flight) {

        Double totalAllowedBagWeight = flight.getPlaneType().getTotalWeight()/2;
        Double remainingBaggageCapacity = totalAllowedBagWeight - this.getTotalPassengerBagWeight(flight);

        return remainingBaggageCapacity;
    }
}
