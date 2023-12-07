package Account;

public abstract class Account {
    private String accountId;
    private String userId;
    private String password;
    private String status;

    // Constructor
    public Account(String accountId, String userId, String password, String status) {
        this.accountId = accountId;
        this.userId = userId;
        this.password = password;
        this.status = status;
    }

    // Getters and setters for each field
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Methods as per UML diagram
    public void addAccount() {
        // Implementation for adding an account
    }

    public void activateAccount() {
        // Implementation for activating an account
    }

    public void deactivateAccount() {
        // Implementation for deactivating an account
    }

    // Other methods can be added as per the application's requirements
}

