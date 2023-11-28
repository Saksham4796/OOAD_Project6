public class Truck extends Vehicle {
    private String type;

    public Truck(String licensePlate, String stockNumber, String model, int mileage, Parking parkingSpot, String type) {
        super(licensePlate, stockNumber, model, mileage, parkingSpot);
        this.type = type;
    }

    @Override
    public void serviceVehicle() {
        // Implementation for servicing a Truck
    }

    @Override
    public void returnVehicle() {
        // Implementation for returning a Truck
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
