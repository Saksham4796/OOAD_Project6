package Vehicles;

import ParkingSpace.Parking;

public class Sedan extends Vehicle {
    private String type;

    public Sedan(String licenseNum, String stockNum, int capacity, String barcode, boolean hasSunroof, String status,
                 String model, String make, int manufacturingYear, int mileage, String type, Parking parking) {
        super(licenseNum, stockNum, capacity, barcode, hasSunroof, status, model, make, manufacturingYear, mileage ,parking);
        this.type = type;
    }


    @Override
    public void serviceVehicle() {
        // Implementation for servicing a Vehicles.Sedan
    }

    @Override
    public void returnVehicle() {
        // Implementation for returning a Vehicles.Sedan
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}