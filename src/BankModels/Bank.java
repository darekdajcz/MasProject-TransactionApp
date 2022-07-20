package BankModels;

import ClientModels.Address;
import ClientModels.Client;

import java.util.ArrayList;
import java.util.List;

// attribute association
public class Bank {
    String nameOfBank;
    Address address;

    public final List<Contract> contracts = new ArrayList<>();

    public Bank(String nameOfBank, Address address) {
        this.nameOfBank = nameOfBank;
        this.address = address;
    }

    public void addContract(Contract contract1) {
        // Check if we already have a client
        if (!contracts.contains(contract1)){
            contracts.add(contract1);
            contract1.addBank(this);
        }
    }

    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "nameOfBank='" + nameOfBank + '\'' +
                ", address=" + address +
                '}';
    }
}
