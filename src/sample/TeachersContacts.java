//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.SystemUsers.Teacher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeachersContacts implements Initializable, ControlledScenes {
    private ScenesController myController;
    @FXML
    private Button returnBtn;
    @FXML
    public TableView teacherTableView;
    @FXML
    public TableColumn firstNameCol;
    @FXML
    public TableColumn lastNameCol;
    @FXML
    public TableColumn emailCol;
    @FXML
    public TableColumn telCol;
    @FXML
    public TableColumn addressCol;
    @FXML
    public TableColumn subjectCol;
    @FXML
    public TableColumn genderCol;

    public TeachersContacts() {
    }

    public void initialize(URL location, ResourceBundle resources) {

        DBConnections.connect();
        ObservableList<Teacher> infoList = DBConnections.getTeacherInfo2();
        this.teacherTableView.setEditable(false);
        this.firstNameCol.setCellValueFactory(new PropertyValueFactory("name"));
        this.lastNameCol.setCellValueFactory(new PropertyValueFactory("surname"));
        this.emailCol.setCellValueFactory(new PropertyValueFactory("emailAddress"));
        this.telCol.setCellValueFactory(new PropertyValueFactory("phoneNum"));
        this.addressCol.setCellValueFactory(new PropertyValueFactory("homeAddress"));
        this.subjectCol.setCellValueFactory(new PropertyValueFactory("teachingField"));
        this.teacherTableView.setItems(infoList);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }

    @FXML
    private void handleReturnBtn() throws IOException {
        this.myController.setScenes(SchoolAppFramework.teacherSceneID);
    }
}
