public enum PlaneType {
    BOEING747(2, 100),
    BOEING737(1, 50),
    AIRBUSA350(2, 200),
    AIRBUSA380(3, 300);

    private final int capacity;
    private final Double totalWeight;

    PlaneType(int capacity, double totalWeight){
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Double getTotalWeight() {
        return this.totalWeight;
    }
}
