package ClientModels;

import java.io.Serializable;

public abstract class ClientAbstract implements Serializable {
    protected String firstName;
    protected String surName;

    public ClientAbstract(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

}
