package Vehicles;

import ParkingSpace.Parking;
import VehicleFeatures.VehicleFeature;

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
    private float cost;

    //private List<String> features;

    VehicleFeature features;
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
        //this.features=new ArrayList<>();
        //this.cost=25;
    }

    public void addFeature(VehicleFeature feature){
        this.features=feature;
    }
    public void removeFeature(VehicleFeature feature){
        this.features=null;
    }

    // Abstract methods that subclasses need to implement
    public abstract void serviceVehicle();
    public abstract void returnVehicle();
    public float getFeatureCost(){
        return cost;
    }

    // List<String> getAdditionalFeatures(){
        //return features;
    //}
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

