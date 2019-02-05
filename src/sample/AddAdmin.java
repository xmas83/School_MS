//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.SystemUsers.AdminMember;

public class AddAdmin implements Initializable {
    ObservableList<String> list = FXCollections.observableArrayList(new String[]{"Principal", "Human Res.Manager", "IT-System Manager", "General Secretary"});
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
    private Button saveBtn;
    @FXML
    private ChoiceBox position;

    public AddAdmin() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.position.setItems(this.list);
    }

    @FXML
    private void handleSaveBtn() throws IOException {
        AdminMember newAdmin = new AdminMember();
        newAdmin.setSSN(ssn.getText());
        newAdmin.setName(firstName.getText());
        newAdmin.setSurname(lastName.getText());
        newAdmin.setDateOfBirth(dateOfB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        newAdmin.setHomeAddress(homeAddress.getText());
        newAdmin.setPhoneNum(phoneNumber.getText());
        newAdmin.setUserName(userName.getText());
        newAdmin.setPassWord(password.getText());
        newAdmin.setEmailAddress(userEmail.getText());
        newAdmin.setPosition(position.getValue().toString());

        DBConnections.connect();
        DBConnections.addAdmin(newAdmin);
        ((Stage)this.saveBtn.getScene().getWindow()).close();
    }
}
