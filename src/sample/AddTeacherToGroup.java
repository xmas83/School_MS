package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.SystemUsers.Teacher;

public class AddTeacherToGroup{
    public TableColumn firstNameCol;
    public TableColumn lastNameCol;
    public TableColumn subjectCol;
    public TableView table;
    public TableColumn ssnCol;
    public ScenesController myController;

    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    public static String selectedGroup;

    public void initialize() {
        selectedGroup = AdminPortal.getSelectedGroup();
        ObservableList<Teacher> infoList2 = DBConnections.getTeacherInfoNotGroup(selectedGroup);

        this.table.setEditable(true);

        this.ssnCol.setCellValueFactory(new PropertyValueFactory("SSN"));
        this.firstNameCol.setCellValueFactory(new PropertyValueFactory("name"));
        this.lastNameCol.setCellValueFactory(new PropertyValueFactory("surname"));
        this.subjectCol.setCellValueFactory(new PropertyValueFactory("TeachingField"));

        table.setItems(infoList2);

    }

    @FXML
    public void handleSaveBtn(){
        Teacher addedTeacher = (Teacher)table.getSelectionModel().getSelectedItem();
        DBConnections.connect();
        DBConnections.addTeacherToGroup(addedTeacher, selectedGroup);
        ((Stage)this.saveButton.getScene().getWindow()).close();

    }

    @FXML
    public void handleCancelBtn(){
        ((Stage)this.cancelButton.getScene().getWindow()).close();
    }
}
