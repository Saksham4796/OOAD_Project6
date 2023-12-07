import Account.Account;
import Reservation.VehicleReservation;

public class AdminAccountSingleton extends Account {
    // Static instance for the singleton
    private static AdminAccountSingleton instance = null;

    // Private constructor to prevent instantiation
    private AdminAccountSingleton(String accountId, String userId, String password, String status) {
        super(accountId, userId, password, status);
    }

    // Static method to get the instance of the singleton
    public static AdminAccountSingleton getInstance(String accountId, String userId, String password, String status) {
        if (instance == null) {
            instance = new AdminAccountSingleton(accountId, userId, password, status);
        }
        return instance;
    }

    // Method to get vehicle reservations
    //public List<VehicleReservation> getVehicleReservations() {
        // Implementation to get vehicle reservations
       // return new ArrayList<>(); // Placeholder return
    }

    // Other admin-specific methods can be added here

    // Note: We inherit accountId, userId, password, status from Account.Account
    // along with its getters, setters, and methods


