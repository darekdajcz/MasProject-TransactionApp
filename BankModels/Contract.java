package BankModels;

import ClientModels.Address;
import ClientModels.Client;

import java.util.List;

public class Contract {
    String nameOfBank;
    Address address;
    Bank bank;
    List<Client> clientList;

    public Contract(String nameOfBank, Address address) {
        this.nameOfBank = nameOfBank;
        this.address = address;
    }
}
