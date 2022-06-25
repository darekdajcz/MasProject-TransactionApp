package TransactionModels;

import java.util.Date;

public class Withdraw extends Transaction {
    String place;

    public Withdraw(Long idTransaction, Long amount, Date transactionDate, Date approvedDate, TransferType transferType, PayoutType payoutType, String place) {
        super(idTransaction, amount, transactionDate, approvedDate, transferType, payoutType);
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
                "place='" + place +
                ", amount=" + super.getAmount() +
                ", transactionDate=" + super.getTransferType() +
                ", approvedDate=" + super.getApprovedDate() +
                ", transferType=" + super.getTransferType() +
                ", payoutType=" + super.getPayoutType() +
                '}';
    }
}
