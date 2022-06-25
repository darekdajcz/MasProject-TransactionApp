package BankModels;

import ClientModels.Address;
import ClientModels.Client;

// attribute association
public class Contract {
    String nameOfBank;
    Address address;
    Bank bank;
    Client client;

    public Contract(String nameOfBank, Address address) {
        this.nameOfBank = nameOfBank;
        this.address = address;
    }

    public void addClient(Client client) {
        // Check if we already have a client
        if (this.client != null) {
            if (client.contracts.contains(client)) {
                this.client = client;
            }
            client.addContract(this);
        }
    }

    public void addBank(Bank bank) {
        // Check if we already have a client
        if (this.bank != null) {
            if (bank.contracts.contains(bank)) {
                this.bank = bank;
            }
            bank.addContract(this);
        }
    }

    @Override
    public String toString() {
        return "Contract{" +
                "nameOfBank='" + nameOfBank + '\'' +
                ", address=" + address +
                ", bank=" + bank +
                ", client=" + client +
                '}';
    }
}
