package ClientModels;

import java.io.Serializable;

public class Address implements Serializable {
    String postalCode;
    String city;
    String street;
    String number;

    public Address(String postalCode, String city, String street, String number) {
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String saveDataToString() {
        return postalCode + "|" +
                city + "|" +
                street + "|" +
                number;
    }

        @Override
    public String toString() {
        return "Address{" +
                "postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
