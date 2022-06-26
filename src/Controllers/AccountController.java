package Controllers;

import BankModels.Bank;
import BankModels.Contract;
import ClientModels.Address;
import ClientModels.Client;
import PeselValidator.PeselModel;

import java.sql.*;

public class AccountController {

    public PeselModel getPeselData(String peselNumber) {
        var peselModelResponse = new PeselModel();
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3308/sys", "root", "Uzi2115");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from pesel_data where peselNumber = " + peselNumber);

                resultSet.next();
                String idPesel = resultSet.getString("idPesel");
                String name = resultSet.getString("peselNumber");
                boolean pages = resultSet.getBoolean("isAvaiable");
                boolean author = resultSet.getBoolean("isAdult");
                boolean accountExist = resultSet.getBoolean("accountExist");
                peselModelResponse = new PeselModel(idPesel, name, pages, author, accountExist);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peselModelResponse;
    }

    public void getContractList(String clientNumber) {


        try {
            var boolClient = false;
            var boolBank = false;


            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3308/sys", "root", "Uzi2115");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from contract where clientNumber = " + clientNumber);

            while (resultSet.next()) {
                String contractId = resultSet.getString("contractId");
                String nameOfBank = resultSet.getString("nameOfBank");

                if(resultSet.getInt("signedByClient") == 1) {
                    boolClient = true;
                } else boolClient = false;

                if(resultSet.getInt("approvedByBank") == 1) {
                    boolBank = true;
                } else boolBank = false;
                var contract = new Contract(boolClient, boolBank, contractId);
                contract.setNameOfBank(nameOfBank);
                System.out.println(contract.printContractInfo());
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Client getLogin(String clientNumber) {
        Client client = null;
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3308/sys", "root", "Uzi2115");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from logg where clientNumber = " + clientNumber);

            resultSet.next();
            String nationality = resultSet.getString("nationality");
            String firstName = resultSet.getString("firstName");
            String surName = resultSet.getString("surName");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            String contactNumber = resultSet.getString("contactNumber");
            boolean creditPossibility = resultSet.getBoolean("creditPossibility");
            var client1 = new Client(firstName, surName);
            client1.createClientAccount(Long.parseLong(clientNumber),nationality,email,creditPossibility,
                    new Address("XX","xx","xx", "xx"),contactNumber, new Date(2000,11,11));
            client = client1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    public Bank getBank(String nameOfBank) {
        Bank bank = null;
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3308/sys", "root", "Uzi2115");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from bank where nameOfBank = " + '"' + nameOfBank + '"');

            resultSet.next();
            String address = resultSet.getString("address");
            var bank1 = new Bank(nameOfBank, new Address("XX-XXX","xx", "XX", "1"));
            bank = bank1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bank;
    }



    public void signContract(Contract contract) {
        var boolClient = 0;
        var boolBank = 0;

        if(contract.isApprovedByBank()) {
            boolBank = 1;
        }

        if(contract.isSignedByClient()) {
            boolClient = 1;
        }
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3308/sys", "root", "Uzi2115");

            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into sys.contract (contractId, signedByClient, approvedByBank, nameOfBank, clientNumber) values(" +
                    contract.getContractId() + ",'" +
                    boolClient + "'," +
                    boolBank + ", '" +
                    contract.getBank().getNameOfBank() + "' ," +
                    "'" + contract.getClient().getClientNumber() + "'" + ")");

            System.out.println("You sign a contract");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
