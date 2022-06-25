import AccountModels.Account;
import AccountModels.AccountBalance;
import AccountModels.PackageType;
import ClientModels.Address;
import ClientModels.Client;
import GUI.MainGui;
import TransactionModels.PayoutType;
import TransactionModels.Transfer;
import TransactionModels.TransferType;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

//        new MainGui("AppBankMobile");


        // abstract class
        // dynamic
    /*    Address address = new Address("94-200", "Warszawa", "Dolna", "11");
        Client client1 = Client.makeClientUnregistered("Dariusz", "Dajcz", "99091292463");
        System.out.println(client1);
        client1.createClientAccount(
                123456L,
                "Polska",
                "darek@gmail.com",
                true,
                address,
                "421865552",
                new Date());
        System.out.println(client1);*/

        Account account = new Account(123243L, new Date(), true);
        // overlapping
        List<String> list = new ArrayList<>();
        list.add("Car");
        list.add("Holidays");
        account.makeAccountPersonal(PackageType.CLASSIC, list);
        account.makeAccountPremium(20);
        // composition
        AccountBalance.createAccountBalance(21150L, 10, account);
        System.out.println(account);


        // qualified association

        Transfer transfer = new Transfer(
                1234L,
                1111L,
                new Date(),
                new Date(),
                TransferType.LOCAL,
                PayoutType.CARD,
                true);

        Transfer transfer2 = new Transfer(
                1222L,
                21114L,
                new Date(),
                new Date(),
                TransferType.INTERNATIONAL,
                PayoutType.CARD,
                false);

        transfer.addAccount(account);
        transfer2.addAccount(account);
        System.out.println(transfer);
        System.out.println(transfer2);
        System.out.println(account);
        System.out.println(account.getTransactionMap());


    }
}
