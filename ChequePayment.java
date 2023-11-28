public class ChequePayment extends Payment {
    private String chequeNumber;
    private String bankName;
    private String issuedDate; // This could also be a Date object, but a String is used for simplicity.

    // Constructor
    public ChequePayment(String paymentId, double amount, String paymentType, String chequeNumber,
                         String bankName, String issuedDate) {
        super(paymentId, amount, paymentType);
        this.chequeNumber = chequeNumber;
        this.bankName = bankName;
        this.issuedDate = issuedDate;
    }

    // Implement the abstract method from the Payment class
    @Override
    public boolean makeTransaction() {
        // Logic to process the cheque payment
        // This would likely involve recording the cheque details and submitting them to a bank.

        // Placeholder for actual cheque processing logic
        System.out.println("Processing cheque payment...");

        // Return true if the transaction is recorded successfully, false if there's an error.
        return true; // This should be replaced with actual implementation
    }

    // Getters and setters for cheque-specific attributes
    public String getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }
}

