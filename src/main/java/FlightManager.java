import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class FlightManager {


    public static Passenger findPassengerBySeatNo(Flight flight, int seatNo) {
        // We first sort the passengers into order by seat number
        sortPassengersBySeatNo(flight);

        ArrayList<Passenger> passengers = flight.getPassengers();

        Passenger result = binarySearch(passengers, seatNo);

        return result;
    }

    private static Passenger binarySearch(ArrayList<Passenger> passengers, int seatNo) {
        if(passengers.size() == 0) {
            return null;
        }

        int midIndex = 0;
        if(passengers.size() > 1) {
            midIndex = (int) Math.ceil((double) passengers.size() / 2);
        }

        int midPoint = passengers.get(midIndex).getSeatNo();

        if(seatNo == midPoint) {
            return passengers.get(midIndex);
        }

        ArrayList<Passenger> newSearchArea;

        if(seatNo < midPoint) {
            newSearchArea = new ArrayList<>(passengers.subList(0, midIndex));
        } else {
            newSearchArea = new ArrayList<>(passengers.subList(midIndex + 1, passengers.size()));
        }
        return binarySearch(newSearchArea, seatNo);
    }


    public static Double getMaxBagWeightPerPassenger(Flight flight) {

        // We calculate max baggage weight by getting the Total allowed weight, halving it and then dividing
        // that number by the total number of passengers allowed on the plane.
        PlaneType planeType = flight.getPlaneType();
        Double maxBagWeight = (planeType.getTotalWeight()/2)/planeType.getCapacity();

        return maxBagWeight;
    }

    public static Double getTotalPassengerBagWeight(Flight flight) {

        Double totalBagWeight = 0.00;

        ArrayList<Passenger> passengers = flight.getPassengers();
        for(Passenger passenger : passengers) {
            totalBagWeight += passenger.getTotalBagWeight();
        }

        return totalBagWeight;
    }

    public static Double getRemainingFlightBagWeightCapacity(Flight flight) {

        Double totalAllowedBagWeight = flight.getPlaneType().getTotalWeight()/2;
        Double remainingBaggageCapacity = totalAllowedBagWeight - getTotalPassengerBagWeight(flight);

        return remainingBaggageCapacity;
    }

    public static void sortPassengersBySeatNo(Flight flight) {

        // Get Passengers from flight
        ArrayList<Passenger> passengers = flight.getPassengers();
        // Bubble sort gets first element and then compares to next element. If it is bigger it swaps them around

        int n = passengers.size();
        boolean incomplete = false;

        // Cycle through all elements until either end of array or n+1 element is bigger then break
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < (n - i - 1); j++) {
                int firstVal = passengers.get(j).getSeatNo();
                int secondVal = passengers.get(j+1).getSeatNo();
                if(firstVal > secondVal) {
                    Collections.swap(passengers, j, j+1);
                    incomplete = true;
                }
            }
            if(!incomplete) {
                break;
            }
        }

    }

}
