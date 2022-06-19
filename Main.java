import ClientModels.Address;
import ClientModels.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

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
        System.out.println(client1.validatePesel("05041762137"));

        //read from file

//
//        try {
//            // create a reader
//           ObjectInputStream ois = new ObjectInputStream(new FileInputStream("client.txt"));
//
//            while (ois.readObject() != null) {
//        System.out.println(ois);
//            }
//            ois.close();
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

//        File file = new File("client.txt");
//        Scanner scanner = new Scanner(file);
//        ArrayList<Client> clientArrayList = new ArrayList<>();
//
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//            System.out.println(line);
//        }



        // writing to file
        try (FileOutputStream fos = new FileOutputStream("client.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // write object to file
            oos.writeUTF("XX");
//            oos.writeUTF(client2.saveDataToString());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
