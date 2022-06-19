package AccountModels;

import AccountModels.AccountBalance;
import AccountModels.AccountType;
import AccountModels.PackageType;

import java.util.Date;
import java.util.EnumSet;
import java.util.List;

public class Account {
    private Long accountNumber;
    private Date creationDate;
    private String usingTime;
    private boolean blik;

    // Overlapping
    private EnumSet<AccountType> accountTypes = EnumSet.of(AccountType.ACCOUNT);

    // Composition
    private AccountBalance accountBalance;

    // PERSONAL
    private PackageType packageType;
    private List<String> expenseList;

    // STUDENT
    private int studentCard;
    private List<String> studentDiscount;

    // PREMIUM
    private int vipDiscount;

    public Account(Long accountNumber, Date creationDate, String usingTime, boolean blik, AccountBalance accountBalance) {
        this.accountNumber = accountNumber;
        this.creationDate = creationDate;
        this.usingTime = usingTime;
        this.blik = blik;
        this.accountBalance = accountBalance;
    }

    // Personal overlapping
    public void makeAccountPersonal(PackageType packageType, List<String> expenseList) {
        this.packageType = packageType;
        this.expenseList = expenseList;
        this.accountTypes.add(AccountType.PERSONAL);
    }

    public void removePersonalType() {
        if (this.accountTypes.contains(AccountType.PERSONAL)) {
            this.packageType = null;
            this.expenseList = null;
            this.accountTypes.remove(AccountType.PERSONAL);
        } else {
            System.out.println("This account has not PERSONAL type");
        }
    }


    // Student overlapping
    public void makeAccountStudent(int studentCard, List<String> studentDiscount) {
        this.studentCard = studentCard;
        this.studentDiscount = studentDiscount;
        this.accountTypes.add(AccountType.STUDENT);
    }

    public void removeStudentType() {
        if (this.accountTypes.contains(AccountType.STUDENT)) {
            this.studentCard = Integer.parseInt(null);
            this.studentDiscount = null;
            this.accountTypes.remove(AccountType.STUDENT);
        } else {
            System.out.println("This account has not STUDENT type");
        }
    }

    // Premium overlapping
    public void makeAccountPremium(int vipDiscount) {
        this.vipDiscount = vipDiscount;
        this.accountTypes.add(AccountType.VIP);
    }

    public void removePremiumType() {
        if (this.accountTypes.contains(AccountType.VIP)) {
            this.vipDiscount = Integer.parseInt(null);
            this.accountTypes.remove(AccountType.VIP);
        } else {
            System.out.println("This account has not VIP type");
        }
    }

    // ###########################
    // Getters and setters
    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getUsingTime() {
        return usingTime;
    }

    public void setUsingTime(String usingTime) {
        this.usingTime = usingTime;
    }

    public boolean isBlik() {
        return blik;
    }

    public void setBlik(boolean blik) {
        this.blik = blik;
    }

    public EnumSet<AccountType> getAccountTypes() {
        return accountTypes;
    }

    public AccountBalance getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(AccountBalance accountBalance) {
        this.accountBalance = accountBalance;
    }

    public PackageType getPackageType() throws Exception {
        if (!this.accountTypes.contains(AccountType.PERSONAL)) {
            throw new Exception("AccountModels.Account is not a PERSONAL");
        }
        return packageType;
    }

    public void setPackageType(PackageType packageType) throws Exception {
        if (!this.accountTypes.contains(AccountType.PERSONAL)) {
            throw new Exception("AccountModels.Account is not a PERSONAL");
        }
        this.packageType = packageType;
    }

    public List<String> getExpenseList() throws Exception {
        if (!this.accountTypes.contains(AccountType.PERSONAL)) {
            throw new Exception("AccountModels.Account is not a PERSONAL");
        }
        return expenseList;
    }

    public void setExpenseList(List<String> expenseList) throws Exception {
        if (!this.accountTypes.contains(AccountType.PERSONAL)) {
            throw new Exception("AccountModels.Account is not a PERSONAL");
        }
        this.expenseList = expenseList;
    }

    public int getStudentCard() throws Exception {
        if (!this.accountTypes.contains(AccountType.STUDENT)) {
            throw new Exception("AccountModels.Account is not a STUDENT");
        }
        return studentCard;
    }

    public void setStudentCard(int studentCard) throws Exception {
        if (!this.accountTypes.contains(AccountType.STUDENT)) {
            throw new Exception("AccountModels.Account is not a STUDENT");
        }
        this.studentCard = studentCard;
    }

    public List<String> getStudentDiscount() throws Exception {
        if (!this.accountTypes.contains(AccountType.STUDENT)) {
            throw new Exception("AccountModels.Account is not a STUDENT");
        }
        return studentDiscount;
    }

    public void setStudentDiscount(List<String> studentDiscount) throws Exception {
        if (!this.accountTypes.contains(AccountType.STUDENT)) {
            throw new Exception("AccountModels.Account is not a STUDENT");
        }
        this.studentDiscount = studentDiscount;
    }

    public int getVipDiscount() throws Exception {
        if (!this.accountTypes.contains(AccountType.VIP)) {
            throw new Exception("AccountModels.Account is not a VIP");
        }
        return vipDiscount;
    }

    public void setVipDiscount(int vipDiscount) throws Exception {
        if (!this.accountTypes.contains(AccountType.VIP)) {
            throw new Exception("AccountModels.Account is not a VIP");
        }
        this.vipDiscount = vipDiscount;
    }

    @Override
    public String toString() {
        var toString = "AccountModels.Account{" +
                "accountNumber=" + accountNumber +
                ", creationDate=" + creationDate +
                ", usingTime='" + usingTime + '\'' +
                ", blik=" + blik +
                ", accountTypes=" + accountTypes +
                ", accountBalance=" + accountBalance;
        if (accountTypes.contains(AccountType.PERSONAL)) {
            toString += ", packageType=" + packageType;
            toString += ", expenseList=" + expenseList;
        }
        if (accountTypes.contains(AccountType.STUDENT)) {
            toString += ", studentCard = " + studentCard;
            toString += ", studentDiscount=" + studentDiscount;
        }
        if (accountTypes.contains(AccountType.PERSONAL)) {

            toString += ", vipDiscount=" + vipDiscount;
        }
        return toString + " }";
    }
}
