public class Bill {
    private double totalAmount;

    // Constructor
    public Bill(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // Getter and setter for totalAmount
    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // The UML diagram suggests there may be a connection to a Payment class
    // Here's a simple method that takes a Payment object and processes the payment
    // The Payment class would need to be defined elsewhere
    public void processPayment(Payment payment) {
        payment.makeTransaction(totalAmount);
    }
}

