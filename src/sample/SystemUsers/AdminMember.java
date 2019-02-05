//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample.SystemUsers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AdminMember extends Person {
    private StringProperty passWord = new SimpleStringProperty(this, "password");
    private StringProperty userName = new SimpleStringProperty(this, "userName");
    private StringProperty phoneNum = new SimpleStringProperty(this, "phoneNum");
    private StringProperty position = new SimpleStringProperty(this, "position");

    public AdminMember() {
    }

    public AdminMember(StringProperty passWord, StringProperty userName, StringProperty phoneNum, StringProperty position) {
        this.passWord = passWord;
        this.userName = userName;
        this.phoneNum = phoneNum;
        this.position = position;
    }

    public AdminMember(StringProperty SSN, StringProperty name, StringProperty surname, StringProperty dateOfBirth, StringProperty gender, StringProperty homeAddress, StringProperty emailAddress, StringProperty passWord, StringProperty userName, StringProperty phoneNum, StringProperty position) {
        super(SSN, name, surname, dateOfBirth, gender, homeAddress, emailAddress);
        this.passWord = passWord;
        this.userName = userName;
        this.phoneNum = phoneNum;
        this.position = position;
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

    public String getPassWord() {
        return (String)this.passWord.get();
    }

    public StringProperty passWordProperty() {
        return this.passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord.set(passWord);
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
