public class WireTransaction extends Payment {
    private String fromBankAccountNumber;
    private String toBankAccountNumber;
    private String beneficiaryName;

    // Constructor
    public WireTransaction(String paymentId, double amount, String paymentType,
                           String fromBankAccountNumber, String toBankAccountNumber, String beneficiaryName) {
        super(paymentId, amount, paymentType);
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankAccountNumber = toBankAccountNumber;
        this.beneficiaryName = beneficiaryName;
    }

    // Implement the abstract method from the Payment class
    @Override
    public boolean makeTransaction() {
        // Logic to process the wire transaction
        // This should interact with bank systems in a real application

        // Placeholder for actual wire transfer processing logic
        System.out.println("Processing wire transaction...");

        // Return true if the transaction was successful, otherwise false
        return true; // This should be replaced with actual implementation
    }

    // Getters and setters for wire transaction-specific attributes
    public String getFromBankAccountNumber() {
        return fromBankAccountNumber;
    }

    public void setFromBankAccountNumber(String fromBankAccountNumber) {
        this.fromBankAccountNumber = fromBankAccountNumber;
    }

    public String getToBankAccountNumber() {
        return toBankAccountNumber;
    }

    public void setToBankAccountNumber(String toBankAccountNumber) {
        this.toBankAccountNumber = toBankAccountNumber;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }
}

