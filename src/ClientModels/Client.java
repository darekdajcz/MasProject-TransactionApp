package ClientModels;

import PeselValidator.PeselValidator;

import java.io.Serializable;
import java.util.Date;


public class Client extends ClientAbstract implements Serializable {

    ClientDynamicType clientDynamicType;

    // UnregisteredClient
    String pesel;

    // RegisteredClient
    Long clientNumber;
    String nationality;
    String email;
    boolean creditPossibility;
    Address address;
    String contactNumber;
    Date birthDate;


    public Client(String firstName, String surName) {
        super(firstName, surName);
    }

    // Delete account / UnregisteredClient

    public static Client makeClientUnregistered(String firstName, String surName, String pesel) throws Exception {
        var peselValidator = new PeselValidator();
        var client = new Client(firstName, surName);
        if(!peselValidator.validatePesel(pesel)) {
            throw new Exception("PESEL " + pesel + "is invalid. Try again");
        }
        client.makeUnregistered(pesel);

        return client;
    }

    public void makeUnregistered(String pesel) {
        this.clientDynamicType = ClientDynamicType.UNREGISTERED_CLIENT;
        this.pesel = pesel;
        this.deleteRegisteredData();
    }


    // DELETE

    public static Client deleteClientAccount(String firstName, String surName, String pesel) {


        var client = new Client(firstName, surName);
        client.deleteAccount(pesel);

        return client;
    }

    public void deleteAccount(String pesel) {
        this.clientDynamicType = ClientDynamicType.UNREGISTERED_CLIENT;
        this.pesel = pesel;
        this.deleteRegisteredData();
    }

    public void deleteRegisteredData() {
        this.clientNumber = null;
        this.nationality = null;
        this.email = null;
        this.creditPossibility = Boolean.parseBoolean(null);
        this.address = null;
        this.contactNumber = null;
        this.birthDate = null;
    }

    // Create an account / change type to RegisteredClient

    public void createClientAccount(long clientNumber, String nationality,
                                    String email,
                                    boolean creditPossibility,
                                    Address address,
                                    String contactNumber,
                                    Date birthDate) throws Exception {

        if (this.clientDynamicType == ClientDynamicType.UNREGISTERED_CLIENT) {
            this.createAccount(clientNumber, nationality, email, creditPossibility, address, contactNumber, birthDate);
        } else {
            throw new Exception("This client does not exsist. Enter PESEL first");
        }
    }

    private void createAccount(Long clientNumber, String nationality,
                               String email, boolean creditPossibility,
                               Address address, String contactNumber,
                               Date birthDate) {
        this.clientDynamicType = ClientDynamicType.REGISTERED_CLIENT;
        this.clientNumber =
                clientNumber;
        this.nationality = nationality;
        this.email = email;
        this.creditPossibility = creditPossibility;
        this.address = address;
        this.contactNumber = contactNumber;
        this.birthDate = birthDate;
        this.deleteUnregisteredData();
    }

    public void deleteUnregisteredData() {
        this.pesel = null;
    }

    /// Getter and Setter

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getSurName() {
        return super.getSurName();
    }

    @Override
    public void setSurName(String surName) {
        super.setSurName(surName);
    }

    public String getPesel() throws Exception {
        if(this.clientDynamicType == ClientDynamicType.UNREGISTERED_CLIENT) {
            return this.pesel;
        } else throw new Exception("Not unregistered client");
    }

    @Override
    public String toString() {
        var toString = "Client { " +
                "firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", clientDynamicType=" + clientDynamicType;

        if (clientDynamicType == ClientDynamicType.UNREGISTERED_CLIENT) {
            toString += ", pesel=" + pesel;
        }

        if (clientDynamicType == ClientDynamicType.REGISTERED_CLIENT) {
            toString += ", clientNumber=" + clientNumber;
            toString += ", nationality=" + nationality;
            toString += ", email='" + email;
            toString += ", creditPossibility=" + creditPossibility;
            toString += ", address=" + address;
            toString += ", contactNumber='" + contactNumber;
            toString += ", birthDate=" + birthDate;
        }
        return toString + " }";
    }
}
