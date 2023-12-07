package Reservation;

import JDBC.JDBCAddEntries;
import ObserverForNotification.NotificationObserver;
import ParkingSpace.Parking;
import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehicleReservation {
    private String reservationNumber;
    private String startDateTime;
    private String endDateTime;
    private String licensePlate; // Assuming this refers to the vehicle's license plate
    //private Parking parkingSpot; // Assuming Parking is another class that you'll define

    private String barcode;
    //private Account account; // The account associated with this reservation
    private Vehicle vehicle; // The vehicle being reserved
    List<NotificationObserver> observers=new ArrayList<>();
    Parking pickUpLocation;
    Parking returnLocation;

    // Constructor
    public void makeReservation(String reservationNumber, String startDateTime, String endDateTime, String licensePlate,
                                Parking pickUpLocation, Parking returnLocation) {
        this.reservationNumber = reservationNumber;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.licensePlate = licensePlate;
        //this.parkingSpot = parkingSpot;
        //this.account = account;
        //this.vehicle = vehicle;

        this.pickUpLocation = pickUpLocation;
        this.returnLocation= returnLocation;

        new JDBCAddEntries().addReservation();
        notifyObservers();
    }

    // Getters and setters for each property
    public void addConfirmationObserver(NotificationObserver observer){
        observers.add(observer);
        System.out.println("New Observer added");

    }
    public void removeConfirmationObserver(){

    }
    public void notifyObservers(){
        for (NotificationObserver observer:observers){
            observer.sendConfirmationUpdate();
        }
    }


    public void fetchReservationDetails() {
    }

}

