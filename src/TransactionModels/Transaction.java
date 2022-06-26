package TransactionModels;

import AccountModels.Account;

import java.util.Date;

public class Transaction {
    private Long idTransaction;
    private Long amount;
    private Date transactionDate;
    private Date approvedDate;
    private TransferType transferType;
    private PayoutType payoutType;
    private Account account;

    public Transaction(Long idTransaction, Long amount, Date transactionDate, Date approvedDate, TransferType transferType, PayoutType payoutType) {
        this.idTransaction = idTransaction;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.approvedDate = approvedDate;
        this.transferType = transferType;
        this.payoutType = payoutType;
    }

    public Long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    // qualified association
    public void addAccount(Account account) {
        if (this.account == null) {
            this.account = account;
            account.doTransaction(this);
        } else {
            System.out.println("this transaction: " + idTransaction + "  currently has an account: " + account.getAccountNumber());
        }
    }
}
