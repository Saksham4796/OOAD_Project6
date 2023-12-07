package ObserverForNotification;
import Reservation.VehicleReservation;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.email.EmailBuilder;

public class EmailConfirmation implements NotificationObserver{
    VehicleReservation reservation;
    public EmailConfirmation(VehicleReservation reservation){
        this.reservation = reservation;
    }

    @Override


    public void sendConfirmationUpdate() {

        reservation.fetchReservationDetails();
        System.out.println("Email sent to the user");
        Email email = EmailBuilder.startingBlank()
                .from("From", "aayushmanbhat501@gmail.com")
                .to("1 st Receiver", "aayushmanbhat@gmail.com")
                //.to("2 nd Receiver", "rec2@example.com")
                .withSubject("Email Subject")
                .withPlainText("Email Body")
                .buildEmail();
    }
}
