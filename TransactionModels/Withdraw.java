package TransactionModels;

import java.util.Date;

public class Withdraw extends Transaction {
    String place;

    public Withdraw(Long amount, Date transactionDate, Date approvedDate, TransferType transferType, PayoutType payoutType, String place) {
        super(amount, transactionDate, approvedDate, transferType, payoutType);
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Withdraw{" +
                "amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", approvedDate=" + approvedDate +
                ", transferType=" + transferType +
                ", payoutType=" + payoutType +
                ", place='" + place + '\'' +
                '}';
    }
}
