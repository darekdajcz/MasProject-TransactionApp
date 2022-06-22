package Controllers;

import PeselValidator.PeselModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountController {

    public PeselModel getPeselData(String peselNumber) {
        var peselModelResponse = new PeselModel();
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3308/sys", "root", "Uzi2115");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from pesel_data where peselNumber = " + peselNumber);

                resultSet.next();
                String idBook = resultSet.getString("idPesel");
                String name = resultSet.getString("peselNumber");
                boolean pages = resultSet.getBoolean("isAvaiable");
                boolean author = resultSet.getBoolean("isAdult");
                boolean accountExist = resultSet.getBoolean("accountExist");
                peselModelResponse = new PeselModel(idBook, name, pages, author, accountExist);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peselModelResponse;
    }
}
