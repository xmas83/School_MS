//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample.SystemUsers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User extends Person {
    private StringProperty passWord = new SimpleStringProperty(this, "password");
    private StringProperty userName = new SimpleStringProperty(this, "userName");
    private StringProperty emailAddress = new SimpleStringProperty(this, "emailAddress");

    public User() {
    }
}
