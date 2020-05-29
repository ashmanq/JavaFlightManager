import java.util.ArrayList;
import java.util.Collections;

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

    public void sortPassengersBySeatNo(Flight flight) {

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

    public ArrayList<Integer> bubbleSort(ArrayList<Integer> unsortedList) {
        // Create an unsorted list of Integers
//        ArrayList<Integer> unsortedList = new ArrayList<>();
//        unsortedList.add(2);
//        unsortedList.add(5);
//        unsortedList.add(1);
//        unsortedList.add(4);
//        unsortedList.add(3);

        //Cycle through (array size - 1) values
        for (int i = 0; i < unsortedList.size(); i++) {
            for(int j = 0; j < unsortedList.size() - i - 1; j++) {

                int firstVal = unsortedList.get(j);
                int secondVal = unsortedList.get(j+1);

                if(firstVal > secondVal) {
                    Collections.swap(unsortedList, j, j+1);
                }
            }
        }

        ArrayList<Integer> sortedList = unsortedList;

        return sortedList;

    }
}
