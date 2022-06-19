package TransactionModels;

import java.util.Date;

public class Payment extends Transaction {
    String place;
    int provision = 10;

    public Payment(Long amount, Date transactionDate, Date approvedDate, TransferType transferType, PayoutType payoutType, String place) {
        super(amount, transactionDate, approvedDate, transferType, payoutType);
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getProvision() {
        return provision;
    }

    public void setProvision(int provision) {
        this.provision = provision;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "place='" + place + '\'' +
                ", provision=" + provision +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", approvedDate=" + approvedDate +
                ", transferType=" + transferType +
                ", payoutType=" + payoutType +
                '}';
    }
}
