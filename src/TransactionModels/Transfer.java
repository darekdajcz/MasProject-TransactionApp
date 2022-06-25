package TransactionModels;

import AccountModels.Account;

import java.util.Date;

public class Transfer extends Transaction{
    boolean express;
    int transferFee = 5;

    public Transfer(Long idTransaction,Long amount, Date transactionDate, Date approvedDate, TransferType transferType, PayoutType payoutType, boolean express) {
        super(idTransaction, amount, transactionDate, approvedDate, transferType, payoutType);
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
    public void addAccount(Account account) {
        if (super.getAccount() == null) {
            super.setAccount(account);
            account.doTransaction(this);
        } else {
            System.out.println("this transaction: " + super.getIdTransaction() + "  currently has an account: " + account.getAccountNumber());
        }
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "amount=" + super.getAmount() +
                ", transactionDate=" + super.getTransferType() +
                ", approvedDate=" + super.getApprovedDate() +
                ", transferType=" + super.getTransferType() +
                ", payoutType=" + super.getPayoutType() +
                ", express=" + express +
                ", transferFee=" + transferFee +
                '}';
    }
}
