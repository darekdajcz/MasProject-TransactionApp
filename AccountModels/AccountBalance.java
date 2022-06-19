package AccountModels;

public class AccountBalance {
    Long availableFounds;
    int accountFee = 20;
    int bonus;

    public AccountBalance(Long availableFounds, int accountFee, int bonus) {
        this.availableFounds = availableFounds;
        this.accountFee = accountFee;
        this.bonus = bonus;
    }
}
