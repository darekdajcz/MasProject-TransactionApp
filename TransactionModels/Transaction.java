package TransactionModels;

import java.util.Date;

public class Transaction {
    Long amount;
    Date transactionDate;
    Date approvedDate;
    TransferType transferType;
    PayoutType payoutType;

    public Transaction(Long amount, Date transactionDate, Date approvedDate, TransferType transferType, PayoutType payoutType) {
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.approvedDate = approvedDate;
        this.transferType = transferType;
        this.payoutType = payoutType;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public TransferType getTransferType() {
        return transferType;
    }

    public void setTransferType(TransferType transferType) {
        this.transferType = transferType;
    }

    public PayoutType getPayoutType() {
        return payoutType;
    }

    public void setPayoutType(PayoutType payoutType) {
        this.payoutType = payoutType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", approvedDate=" + approvedDate +
                ", transferType=" + transferType +
                ", payoutType=" + payoutType +
                '}';
    }
}
