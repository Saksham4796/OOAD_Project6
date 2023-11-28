public abstract class Vehicle {
    private String licensePlate;
    private String stockNumber;
    private String model;
    private int mileage;
    private Parking parkingSpot; // Assuming Parking is another class that you'll define

    // Constructor
    public Vehicle(String licensePlate, String stockNumber, String model, int mileage, Parking parkingSpot) {
        this.licensePlate = licensePlate;
        this.stockNumber = stockNumber;
        this.model = model;
        this.mileage = mileage;
        this.parkingSpot = parkingSpot;
    }

    // Abstract methods that subclasses need to implement
    public abstract void serviceVehicle();
    public abstract void returnVehicle();

    // Getters and Setters for the attributes
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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

    public Parking getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(Parking parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}

