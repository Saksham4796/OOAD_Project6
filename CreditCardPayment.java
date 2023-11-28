public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate; // It could be a Date object, but for simplicity, we'll keep it as a String
    private String cvv;

    // Constructor
    public CreditCardPayment(String paymentId, double amount, String paymentType, String cardNumber,
                             String cardHolderName, String expirationDate, String cvv) {
        super(paymentId, amount, paymentType);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    // Implement the abstract method from Payment class
    @Override
    public boolean makeTransaction() {
        // Logic for processing the credit card payment
        // Placeholder for actual payment processing logic
        System.out.println("Processing credit card payment...");

        // Return true for success, false for failure
        // This should interact with a real payment gateway in a production environment
        return true;
    }

    // Getters and setters for credit card-specific attributes
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}

