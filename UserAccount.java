public class UserAccount extends Account {
    // Attributes specific to UserAccount
    private List<VehicleReservation> vehicleReservations; // Assuming VehicleReservation is another class

    // Constructor
    public UserAccount(String accountId, String userId, String password, String status) {
        super(accountId, userId, password, status);
        this.vehicleReservations = new ArrayList<>();
    }

    // Method to add a vehicle reservation
    public void addReservation(VehicleReservation reservation) {
        vehicleReservations.add(reservation);
    }

    // Method to get the list of vehicle reservations
    public List<VehicleReservation> getVehicleReservations() {
        return vehicleReservations;
    }

    // Method to remove a vehicle reservation
    public void removeReservation(VehicleReservation reservation) {
        vehicleReservations.remove(reservation);
    }

    // Other methods can be added as per the application's requirements

    // Note: We inherit accountId, userId, password, status from Account
    // along with its getters, setters, and methods
}

// Assuming that VehicleReservation is a class that you will define elsewhere in your code.
public class VehicleReservation {
    // attributes and methods for VehicleReservation
}

