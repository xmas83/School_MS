//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample.SystemUsers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Teacher extends Person {
    private StringProperty passWord = new SimpleStringProperty(this, "password");
    private StringProperty userName = new SimpleStringProperty(this, "userName");
    private StringProperty teachingField = new SimpleStringProperty(this, "teachingField");
    private StringProperty phoneNum = new SimpleStringProperty(this, "phoneNum");
    private Group[] gradeYearList;

    public Teacher() {
    }

    public Teacher(StringProperty passWord, StringProperty userName, StringProperty teachingField, StringProperty phoneNum, Group[] gradeYearList) {
        this.passWord = passWord;
        this.userName = userName;
        this.teachingField = teachingField;
        this.phoneNum = phoneNum;
        this.gradeYearList = gradeYearList;
    }

    public Teacher(StringProperty SSN, StringProperty name, StringProperty surname, StringProperty dateOfBirth, StringProperty gender, StringProperty homeAddress, StringProperty emailAddress, StringProperty passWord, StringProperty userName, StringProperty teachingField, StringProperty phoneNum, Group[] gradeYearList) {
        super(SSN, name, surname, dateOfBirth, gender, homeAddress, emailAddress);
        this.passWord = passWord;
        this.userName = userName;
        this.teachingField = teachingField;
        this.phoneNum = phoneNum;
        this.gradeYearList = gradeYearList;
    }

    public String getPassWord() {
        return (String)this.passWord.get();
    }

    public String getTeachingField() {
        return (String)this.teachingField.get();
    }

    public StringProperty teachingFieldProperty() {
        return this.teachingField;
    }

    public void setTeachingField(String teachingField) {
        this.teachingField.set(teachingField);
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

    public Group[] getGradeYearList() {
        return this.gradeYearList;
    }

    public void setGradeYearList(Group[] gradeYearList) {
        this.gradeYearList = gradeYearList;
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
}
