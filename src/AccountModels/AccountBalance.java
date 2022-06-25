package AccountModels;

public class AccountBalance {
    Long availableFounds;
    // class attribute
    int accountFee = 20;
    int bonus;
    // composition
    Account account;

    private AccountBalance(Long availableFounds, int bonus, Account account) {
        this.availableFounds = availableFounds;
        this.bonus = bonus;
        this.account = account;
    }

    public static AccountBalance createAccountBalance(Long availableFounds, int bonus, Account account) throws Exception {
        if (account == null) {
            throw new Exception("The account does not exist!");
        }
        AccountBalance accountBalance = new AccountBalance(availableFounds, bonus, account);

        account.addAccountBalance(accountBalance);

        return accountBalance;
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "availableFounds=" + availableFounds +
                ", accountFee=" + accountFee +
                ", bonus=" + bonus +
                '}';
    }
}
