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
import sample.SystemUsers.Student;

public class AddStudent implements Initializable {


    ObservableList<String> list = FXCollections.observableArrayList(new String[]{"GroupYear9", "GroupYear10", "GroupYear11", "GroupYear12"});

    public TextField firstName;
    public TextField lastName;
    public TextField ssn;
    public DatePicker dateOfB;
    public TextField homeAddress;
    public TextField phoneNumber;
    public TextField userEmail;
    public TextField iceNumber;
    public TextField userName;
    public TextField password;
    public ChoiceBox group;

    @FXML
    private Button saveBtn;

    public AddStudent() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.group.setItems(this.list);
    }

    @FXML
    private void handleSaveBtn() throws IOException {
        Student newStudent = new Student();

        newStudent.setSSN(ssn.getText());
        newStudent.setName(firstName.getText());
        newStudent.setSurname(lastName.getText());
        newStudent.setDateOfBirth(dateOfB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        newStudent.setHomeAddress(homeAddress.getText());
        newStudent.setUsername(userName.getText());
        newStudent.setPassword(password.getText());
        newStudent.setEmailAddress(userEmail.getText());
        newStudent.setPhoneNumber(phoneNumber.getText());

        String groupID = "";
        if(group.getValue().toString().equals("GroupYear9")){
            groupID = "1";
        }else if(group.getValue().toString().equals("GroupYear10")){
            groupID = "2";
        }else if(group.getValue().toString().equals("GroupYear11")){
            groupID = "3";
        }else if(group.getValue().toString().equals("GroupYear12")){
            groupID = "4";
        }
        newStudent.setGradeYear(groupID);

        DBConnections.connect();
        DBConnections.addStudent(newStudent);

        ((Stage)this.saveBtn.getScene().getWindow()).close();
    }
}
