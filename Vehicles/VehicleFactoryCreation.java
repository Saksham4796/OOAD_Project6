package Vehicles;

import ParkingSpace.Parking;

public class VehicleFactoryCreation implements VehicleFactory{
    @Override
    public Vehicle createVehicle(String type, String licenseNum, String stockNum, int capacity, String barcode, boolean hasSunroof, String status,
                                 String make, String model, int manufacturingYear, int mileage, Parking parking)
    {
        Vehicle vehicle;
        if(type=="Sedan"){
             vehicle = new Sedan(licenseNum, stockNum, capacity, barcode,
                    hasSunroof, status, model, make, manufacturingYear, mileage,"Sedan",parking);
        }
        else if(type=="SUV"){
             vehicle = new SUV(licenseNum, stockNum, capacity, barcode,
                    hasSunroof, status, model, make, manufacturingYear, mileage,"SUV",parking);
    }

        else{
             vehicle = new Truck(licenseNum, stockNum, capacity, barcode,
                    hasSunroof, status, model, make, manufacturingYear, mileage,"Sedan",parking);
        }

        return vehicle;
    }

}
