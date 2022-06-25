package BankModels;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    boolean signedByClient;
    boolean approvedByBank;
    public final List<Contract> contracts = new ArrayList<>();

    // attribute association
    public void addContract(Contract contract) {
        if (!contracts.contains(contract)){
            contracts.add(contract);
        }
    }
    public Bank(boolean signedByClient, boolean approvedByBank) {
        this.signedByClient = signedByClient;
        this.approvedByBank = approvedByBank;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "signedByClient=" + signedByClient +
                ", approvedByBank=" + approvedByBank +
                ", contracts=" + contracts +
                '}';
    }
}
