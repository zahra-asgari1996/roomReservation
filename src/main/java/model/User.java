package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private int nationalCode;
    @Column
    private int pass;
    @Column
    private String name;
    @Column
    private String lastName;

    public User(int nationalCode, int pass, String name, String lastName) {
        this.nationalCode = nationalCode;
        this.pass = pass;
        this.name = name;
        this.lastName = lastName;
    }

    public User() {
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "nationalCode=" + nationalCode +
                ", pass=" + pass +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
