package Vehicles;

import ParkingSpace.Parking;
import Vehicles.Vehicle;

public interface VehicleFactory {
    public Vehicle createVehicle(String type, String licenseNum, String stockNum, int capacity, String barcode, boolean hasSunroof, String status,
                                 String make, String model, int manufacturingYear, int mileage, Parking parking);

}

