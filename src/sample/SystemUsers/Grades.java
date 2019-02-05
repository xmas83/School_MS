package sample.SystemUsers;

import javafx.beans.property.*;

public class Grades {

    private StringProperty SSN = new SimpleStringProperty(this, "SSN");
    private StringProperty name = new SimpleStringProperty(this, "name");
    private StringProperty emailAddress = new SimpleStringProperty(this, "emailAddress");
    private DoubleProperty mgrade1 = new SimpleDoubleProperty(this, "mgrade1");
    private DoubleProperty mgrade2 = new SimpleDoubleProperty(this, "mgrade2");
    //these variables is used to update the columns
    //both variables are uniquely defined in the database,So we will easily update the columns
    //using these variables in the query or where clause
    private IntegerProperty gid = new SimpleIntegerProperty(this, "gid");
    private StringProperty loginId = new SimpleStringProperty(this, "loginId");


    public Grades() {
    }

    public Grades(StringProperty SSN, StringProperty name, StringProperty em,DoubleProperty mgrade1,DoubleProperty mgrade2){// StringProperty m, StringProperty b, StringProperty p, StringProperty en, StringProperty phil, StringProperty ch) {
        this.SSN = SSN;
        this.name = name;
        this.emailAddress = em;
        this.mgrade1 = mgrade1;
        this.mgrade2 = mgrade2;
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

    public String getEmailAddress() {
        return (String)this.emailAddress.get();
    }

    public StringProperty emailAddressProperty() {
        return this.emailAddress;
    }

    public void setEmailAdress(String name) {
        this.emailAddress.set(name);
    }

    public Double getMgrade1() {
        return (Double)this.mgrade1.get();
    }

    public void setMgrade1(Double name) {
        this.mgrade1.set(name);
    }

    public Double getMgrade2() {
        return this.mgrade2.get();
    }

    public void setMgrade2(Double name) {
        this.mgrade2.set(name);
    }

    public int getGid() {
        return (int)this.gid.get();
    }

    public void setGid(int gid) {
        this.gid.set(gid);
    }

    public String getLoginId() {
        return (String)this.loginId.get();
    }

    public void setLoginID(String loginId) {
        this.loginId.set(loginId);
    }


}
