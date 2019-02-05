//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample.SystemUsers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private StringProperty SSN = new SimpleStringProperty(this, "SSN");
    private StringProperty name = new SimpleStringProperty(this, "name");
    private StringProperty surname = new SimpleStringProperty(this, "surname");
    private StringProperty dateOfBirth = new SimpleStringProperty(this, "dateOfBirth");
    private StringProperty gender = new SimpleStringProperty(this, "gender");
    private StringProperty homeAddress = new SimpleStringProperty(this, "homeAddress");
    private StringProperty emailAddress = new SimpleStringProperty(this, "emailAddress");

    public Person() {
    }

    public Person(StringProperty SSN, StringProperty name, StringProperty surname, StringProperty dateOfBirth, StringProperty gender, StringProperty homeAddress, StringProperty emailAddress) {
        this.SSN = SSN;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.homeAddress = homeAddress;
        this.emailAddress = emailAddress;
    }

    public String getSSN() {
        return (String)this.SSN.get();
    }

    public StringProperty SSNProperty() {
        return this.SSN;
    }

    public void setSSN(String SSN) {
        this.SSN.set(SSN);
    }

    public String getName() {
        return (String)this.name.get();
    }

    public StringProperty nameProperty() {
        return this.name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return (String)this.surname.get();
    }

    public StringProperty surnameProperty() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getDateOfBirth() {
        return (String)this.dateOfBirth.get();
    }

    public StringProperty dateOfBirthProperty() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public String getGender() {
        return (String)this.gender.get();
    }

    public StringProperty genderProperty() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getHomeAddress() {
        return (String)this.homeAddress.get();
    }

    public StringProperty homeAddressProperty() {
        return this.homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress.set(homeAddress);
    }

    public String getEmailAddress() {
        return (String)this.emailAddress.get();
    }

    public StringProperty emailAddressProperty() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress.set(emailAddress);
    }
}
