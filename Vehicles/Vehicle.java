package Vehicles;

import ParkingSpace.Parking;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    private final String barcode;
    private final Parking parking;
    private String licenseNumber;
    private String stockNumber;
    private int passengerCapacity;
    private String uniqueId;
    private boolean hasSunroof;
    private String status;
    private String model;
    private String make;
    private int manufacturingYear;
    private int mileage;
    private List<String> log;

    public Vehicle(String licenseNum, String stockNum, int capacity, String barcode, boolean hasSunroof, String status,
                   String model,String make, int manufacturingYear, int mileage, Parking parking) {
        this.licenseNumber = licenseNum;
        this.stockNumber = stockNum;
        this.passengerCapacity = capacity;
        this.barcode = barcode;
        this.hasSunroof = hasSunroof;
        this.status = status;
        this.model = model;
        this.make=make;
        this.manufacturingYear = manufacturingYear;
        this.mileage = mileage;
        this.log = new ArrayList<>();
        this.parking=parking;
    }


    // Abstract methods that subclasses need to implement
    public abstract void serviceVehicle();
    public abstract void returnVehicle();

    // Getters and Setters for the attributes
    public String getLicensePlate() {
        return licenseNumber;
    }

    public void setLicensePlate(String licensePlate) {
        this.licenseNumber = licensePlate;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getCapacity() {
        return passengerCapacity;
    }

    public String getBarcode() {
        return barcode;
    }

    public boolean isHasSunroof() {
        return hasSunroof;
    }

    public String getStatus() {
        return status;

    }

    public String getMake() {
        return make;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    //public Parking getParkingSpot() {
        //return parkingSpot;
    //}

    //public void setParkingSpot(Parking parkingSpot) {
        //this.parkingSpot = parkingSpot;
    //}
}

