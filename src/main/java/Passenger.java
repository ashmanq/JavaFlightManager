import java.util.ArrayList;

public class Passenger {

    private String name;
    Bag bag;
//    private ArrayList<Bag> bags;

//    Extensions for later
    private String FlightNo;
    private Integer SeatNo;


    public Passenger(String name){
        this.name = name;
//        this.bags = new ArrayList<Bag>();
        bag = new Bag("Suitcase");
        // FlightNo and SeatNo initialised as "" and 0;
        this.FlightNo = null;
        this.SeatNo = null;
    }

    public String getName() {
        return this.name;
    }

    public String getFlightNo() {
        return FlightNo;
    }

    public void setFlightNo(String flightNo) {
        this.FlightNo = flightNo;
    }

    public Integer getSeatNo() {
        return SeatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.SeatNo = seatNo;
    }

    //    public void addBag(Bag bag){
//        this.bags.add(bag);
//    }
//
//    public int getNoOfBags(){
//        return this.bags.size();
//    }

    public double getTotalBagWeight() {
//        Double totalWeight = 0.0;
//
//        for(Bag bag : this.bags) {
//            totalWeight += bag.getWeight();
//        }

        return this.bag.getWeight();
    }

}
