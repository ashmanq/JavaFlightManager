public class Bag {

    private String bagType;
    private Double weight;

    // When instantiating a Bag class we allocate it a preset weight
    // of 10k as one of the assumptions for this app is that all bags
    // weigh the same. This leaves scope for allowing custom weights
    // when extending functionality in the app.
    public Bag(String bagType) {
        this.bagType = bagType;
        this.weight = 10.0;
    }

    public String getBagType() {
        return bagType;
    }

    public Double getWeight() {
        return weight;
    }
}
