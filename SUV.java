public class SUV extends Vehicle {
    private String type;

    public SUV(String licensePlate, String stockNumber, String model, int mileage, Parking parkingSpot, String type) {
        super(licensePlate, stockNumber, model, mileage, parkingSpot);
        this.type = type;
    }

    @Override
    public void serviceVehicle() {
        // Implementation for servicing an SUV
    }

    @Override
    public void returnVehicle() {
        // Implementation for returning an SUV
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
