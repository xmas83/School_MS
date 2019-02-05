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
import sample.SystemUsers.Teacher;

public class AddTeacher implements Initializable {
    ObservableList<String> list = FXCollections.observableArrayList(new String[]{"Maths", "Physics", "Chemistry", "Biology", "Philosophy", "English"});
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
    private ChoiceBox subject;
    @FXML
    private Button saveBtn;

    public AddTeacher() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.subject.setItems(this.list);
    }

    @FXML
    private void handleSaveBtn() throws IOException {
        Teacher newTeacher = new Teacher();
        newTeacher.setSSN(ssn.getText());
        newTeacher.setName(firstName.getText());
        newTeacher.setSurname(lastName.getText());
        newTeacher.setDateOfBirth(dateOfB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        newTeacher.setHomeAddress(homeAddress.getText());
        newTeacher.setPhoneNum(phoneNumber.getText());
        newTeacher.setUserName(userName.getText());
        newTeacher.setPassWord(password.getText());
        newTeacher.setEmailAddress(userEmail.getText());
        newTeacher.setTeachingField(subject.getValue().toString());

        DBConnections.connect();
        DBConnections.addTeacher(newTeacher);

        ((Stage)this.saveBtn.getScene().getWindow()).close();
    }
}
