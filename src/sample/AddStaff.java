//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.SystemUsers.Staff;
import sample.SystemUsers.Teacher;

public class AddStaff implements Initializable {
    @FXML
    private Button saveBtn;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField ssn;
    @FXML
    private DatePicker dateOfB;
    @FXML
    private RadioButton maleGender;
    @FXML
    private RadioButton femaleGender;
    @FXML
    private TextField homeAddress;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    private TextField userEmail;
    @FXML
    private TextField position;

    public AddStaff() {
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void handleSaveBtn() throws IOException {
        Staff newStaff = new Staff();
        newStaff.setSSN(ssn.getText());
        newStaff.setName(firstName.getText());
        newStaff.setSurname(lastName.getText());
        newStaff.setDateOfBirth(dateOfB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        newStaff.setHomeAddress(homeAddress.getText());
        newStaff.setPhoneNum(phoneNumber.getText());
        newStaff.setUserName(userName.getText());
        newStaff.setPassword(password.getText());
        newStaff.setEmailAddress(userEmail.getText());
        newStaff.setPosition(position.getText());

        DBConnections.connect();
        DBConnections.addStaff(newStaff);
        
        DBConnections.connect();
        
        ((Stage)this.saveBtn.getScene().getWindow()).close();
    }
}
