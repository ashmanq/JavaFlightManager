import java.lang.reflect.Array;
import java.util.ArrayList;

public class Passenger {

    private String name;
    Bag bag;
//    private ArrayList<Bag> bags;

//    Extensions for later
//    private String FlightNo;
//    private int SeatNo;


    public Passenger(String name){
        this.name = name;
//        this.bags = new ArrayList<Bag>();
        bag = new Bag("Suitcase");
    }

    public String getName() {
        return this.name;
    }

//    public void addBag(Bag bag){
//        this.bags.add(bag);
//    }
//
//    public int getNoOfBags(){
//        return this.bags.size();
//    }

//    public double getTotalBaggageWeight() {
//        Double totalWeight = 0.0;
//
//        for(Bag bag : this.bags) {
//            totalWeight += bag.getWeight();
//        }
//
//        return totalWeight;
//    }

}
