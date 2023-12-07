package ObserverForNotification;

import Reservation.VehicleReservation;

public class SMSConfirmation implements NotificationObserver{
        VehicleReservation reservation;
        public SMSConfirmation(VehicleReservation reservation){
            this.reservation = reservation;
        }

    @Override
    public void sendConfirmationUpdate() {
        reservation.fetchReservationDetails();
        System.out.println("SMS sent to the user");
    }
}
