package Vehicles;

import ParkingSpace.Parking;
import Vehicles.Vehicle;

public class Truck extends Vehicle {
    private String type;

    public Truck(String license_num, String stock_num, int capacity, String barcode, boolean has_sunroof, String status,
                 String model, String make, int manufacturing_year, int mileage, String type, Parking parking) {
        super(license_num, stock_num, capacity, barcode, has_sunroof, status, model, make, manufacturing_year, mileage, parking);
        this.type = type;
    }



    @Override
    public void serviceVehicle() {
        // Implementation for servicing a Vehicles.Truck
    }

    @Override
    public void returnVehicle() {
        // Implementation for returning a Vehicles.Truck
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
