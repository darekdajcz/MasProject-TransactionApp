package TransactionModels;

import java.util.Date;

public class Transfer extends Transaction{
    boolean express;
    int transferFee = 5;

    public Transfer(Long amount, Date transactionDate, Date approvedDate, TransferType transferType, PayoutType payoutType, boolean express) {
        super(amount, transactionDate, approvedDate, transferType, payoutType);
        this.express = express;
    }

    public boolean isExpress() {
        return express;
    }

    public void setExpress(boolean express) {
        this.express = express;
    }

    public int getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(int transferFee) {
        this.transferFee = transferFee;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", approvedDate=" + approvedDate +
                ", transferType=" + transferType +
                ", payoutType=" + payoutType +
                ", express=" + express +
                ", transferFee=" + transferFee +
                '}';
    }
}
