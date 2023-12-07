package Vehicles;

import ParkingSpace.Parking;
import Vehicles.Vehicle;

public class SUV extends Vehicle {
    private String type;

    public SUV(String licenseNum, String stockNum, int capacity, String barcode, boolean hasSunroof, String status,
               String model, String make, int manufacturingYear, int mileage, String type, Parking parking) {
        super(licenseNum, stockNum, capacity, barcode, hasSunroof, status, model, make, manufacturingYear, mileage, parking);
        this.type = type;
    }


    @Override
    public void serviceVehicle() {
        // Implementation for servicing an Vehicles.SUV
    }

    @Override
    public void returnVehicle() {
        // Implementation for returning an Vehicles.SUV
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
