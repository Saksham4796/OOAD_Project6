public abstract class Payment {
    protected String paymentId;
    protected double amount;
    protected String paymentType; // This could be an enum in a more comprehensive design

    // Constructor
    public Payment(String paymentId, double amount, String paymentType) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentType = paymentType;
    }

    // Abstract method to be implemented by subclasses
    public abstract boolean makeTransaction();

    // Getters and setters
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}

