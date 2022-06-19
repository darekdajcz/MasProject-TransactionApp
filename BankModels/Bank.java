package BankModels;

public class Bank {
    boolean signedByClient;
    boolean approvedByBank;

    public Bank(boolean signedByClient, boolean approvedByBank) {
        this.signedByClient = signedByClient;
        this.approvedByBank = approvedByBank;
    }
}
