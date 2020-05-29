public enum PlaneType {
    BOEING747(2),
    BOEING737(1),
    AIRBUSA350(2),
    AIRBUSA380(3);

    private final int capacity;

    PlaneType(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
