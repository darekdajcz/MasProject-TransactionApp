package BankModels;

import ClientModels.Client;

import java.util.ArrayList;
import java.util.List;

public class Contract {
    String contractId;
    boolean signedByClient;
    boolean approvedByBank;
    String nameOfBank;
    Bank bank;
    Client client;

    // attribute association
    public void addBank(Bank bank1) {
        if (bank1 != null){
            System.out.println("XX");
            System.out.println(bank1);
            bank = bank1;
        } else {
            System.out.println("Contract already has bank");
        }
    }

    public void addClient(Client client1) {
        if (client1 != null){
            client = client1;
        } else {
            System.out.println("Contract already has client");
        }
    }
    public Contract(boolean signedByClient, boolean approvedByBank, String contractId) {
        this.contractId = contractId;
        this.signedByClient = signedByClient;
        this.approvedByBank = approvedByBank;
    }

    public String isNameOfBank() {
        return nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public boolean isSignedByClient() {
        return signedByClient;
    }

    public void setSignedByClient(boolean signedByClient) {
        this.signedByClient = signedByClient;
    }

    public boolean isApprovedByBank() {
        return approvedByBank;
    }

    public void setApprovedByBank(boolean approvedByBank) {
        this.approvedByBank = approvedByBank;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "signedByClient=" + signedByClient +
                ", approvedByBank=" + approvedByBank +
                ", bank=" + bank +
                ", client=" + client +
                '}';
    }

    public String printContractInfo() {
        return "Contract{" +
                "signedByClient=" + signedByClient +
                ", approvedByBank=" + approvedByBank +
                ", bank=" + nameOfBank +
                '}';
    }
}
