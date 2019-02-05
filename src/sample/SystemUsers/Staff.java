//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample.SystemUsers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Staff extends Person {
    private StringProperty password = new SimpleStringProperty(this, "password");
    private StringProperty userName = new SimpleStringProperty(this, "userName");
    private StringProperty phoneNum = new SimpleStringProperty(this, "phoneNum");
    private StringProperty position = new SimpleStringProperty(this, "position");

    public Staff() {
    }

    public Staff(StringProperty password, StringProperty userName, StringProperty phoneNum) {
        this.password = password;
        this.userName = userName;
        this.phoneNum = phoneNum;
    }

    public Staff(StringProperty SSN, StringProperty name, StringProperty surname, StringProperty dateOfBirth, StringProperty gender, StringProperty homeAddress, StringProperty emailAddress, StringProperty password, StringProperty userName, StringProperty phoneNum, StringProperty position) {
        super(SSN, name, surname, dateOfBirth, gender, homeAddress, emailAddress);
        this.password = password;
        this.userName = userName;
        this.phoneNum = phoneNum;
        this.position = position;
    }

    public String getPassword() {
        return (String)this.password.get();
    }

    public StringProperty passwordProperty() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getUserName() {
        return (String)this.userName.get();
    }

    public StringProperty userNameProperty() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getPhoneNum() {
        return (String)this.phoneNum.get();
    }

    public StringProperty phoneNumProperty() {
        return this.phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum.set(phoneNum);
    }

    public String getPosition() {
        return (String)this.position.get();
    }

    public StringProperty positionProperty() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }
}
