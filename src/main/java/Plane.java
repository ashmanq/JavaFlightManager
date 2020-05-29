public class Plane {

    private PlaneType planeType;

    public Plane(PlaneType planeType) {
        this.planeType = planeType;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public int getCapacity() {
        return this.planeType.getCapacity();
    }

    public Double getTotalWeight() {
        return this.planeType.getTotalWeight();
    }
}
