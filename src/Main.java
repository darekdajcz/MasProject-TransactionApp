import ClientModels.Address;
import ClientModels.Client;
import GUI.MainGui;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        new MainGui("AppBankMobile");

        Address address = new Address("94-200", "Warszawa", "Dolna", "11");
        Client client1 = Client.makeClientUnregistered("Dariusz", "Dajcz", "99091292463");
        Client client2 = Client.makeClientUnregistered("Natalia", "M", "05041762137");
        System.out.println(client1);
        client1.createClientAccount(
                123456L,
                "Polska",
                "darek@gmail.com",
                true,
                address,
                "421865552",
                new Date());
        System.out.println(client1);
//        System.out.println(client1.validatePesel("05041762137"));

        //read from file

    }
}
