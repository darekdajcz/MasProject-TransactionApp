package PeselValidator;

import java.math.BigDecimal;

public class PeselModel {
    String idPesel;
    String peselNumber;
    boolean isAvaiable;
    boolean isAdult;
    boolean accountExist;

    public PeselModel() {
    }
    public PeselModel(String idPesel, String peselNumber, boolean isAvaiable, boolean isAdult, boolean accountExist) {
        this.idPesel = idPesel;
        this.peselNumber = peselNumber;
        this.isAvaiable = isAvaiable;
        this.isAdult = isAdult;
        this.accountExist = accountExist;
    }

    public String getIdPesel() {
        return idPesel;
    }

    public void setIdPesel(String idPesel) {
        this.idPesel = idPesel;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(String peselNumber) {
        this.peselNumber = peselNumber;
    }

    public boolean isAvaiable() {
        return isAvaiable;
    }

    public void setAvaiable(boolean avaiable) {
        isAvaiable = avaiable;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public boolean isAccountExist() {
        return accountExist;
    }

    public void setAccountExist(boolean accountExist) {
        this.accountExist = accountExist;
    }

    @Override
    public String toString() {
        return "PeselModel{" +
                "idPesel='" + idPesel + '\'' +
                ", peselNumber='" + peselNumber + '\'' +
                ", isAvaiable='" + isAvaiable + '\'' +
                ", isAdult='" + isAdult + '\'' +
                ", accountExist='" + accountExist + '\'' +
                '}';
    }
}
