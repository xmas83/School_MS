package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.SystemUsers.TeacherGroupedByGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentContactTeacher implements Initializable {

    @FXML private Button okBtn;
    @FXML private TableView<TeacherGroupedByGroup> TeacherViewedByStudentTable;
    @FXML private TableColumn name;
    @FXML private TableColumn email;
    @FXML private TableColumn subject;
    ObservableList<TeacherGroupedByGroup> list = FXCollections.observableArrayList();
    DBConnections con=new DBConnections();
    private static String loginID;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DBConnections.connect();
        loginID = StudentLogin.getCurrentUser();
        list = con.getTeacher(loginID);
        System.out.println(loginID);

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        email.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        subject.setCellValueFactory(new PropertyValueFactory<>("subject"));

        TeacherViewedByStudentTable.setItems(list);
    }

    @FXML private void handleOkBtn(){
        ((Stage)okBtn.getScene().getWindow()).close();
    }
}
