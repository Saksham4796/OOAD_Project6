import java.util.Date;

public class VehicleReservation {
    private String reservationNumber;
    private Date startDateTime;
    private Date endDateTime;
    private String licensePlate; // Assuming this refers to the vehicle's license plate
    private Parking parkingSpot; // Assuming Parking is another class that you'll define
    private Account account; // The account associated with this reservation
    private Vehicle vehicle; // The vehicle being reserved

    // Constructor
    public VehicleReservation(String reservationNumber, Date startDateTime, Date endDateTime, String licensePlate,
                              Parking parkingSpot, Account account, Vehicle vehicle) {
        this.reservationNumber = reservationNumber;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.licensePlate = licensePlate;
        this.parkingSpot = parkingSpot;
        this.account = account;
        this.vehicle = vehicle;
    }

    // Getters and setters for each property
    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Parking getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(Parking parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // Other methods can be added as per the application's requirements

    // Example method to check if the reservation is active
    public boolean isActive() {
        Date now = new Date();
        return now.after(startDateTime) && now.before(endDateTime);
    }
}

