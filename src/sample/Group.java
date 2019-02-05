package sample;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import sample.SystemUsers.Student;
import sample.SystemUsers.Teacher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Group implements Initializable, ControlledScenes {
    public TableColumn teacherSsnCol;
    private String addTeacherToGroupFxmlFile = "addteachertogroup.fxml";

    public TableView studentTable;
    public TableView teacherTable;

    public TableColumn studentSSNCol;
    public TableColumn studentFirstNameCol;
    public TableColumn studentLastNameCol;
    public TableColumn studentDateOfBirthCol;
    public TableColumn studentEmailCol;
    public TableColumn studentAddressCol;
    public TableColumn studentTelCol;
    public TableColumn studentUsernameCol;
    public TableColumn studentPasswordCol;

    public TableColumn teacherSubjectCol;
    public TableColumn teacherFirstNameCol;
    public TableColumn teacherLastNameCol;
    public TableColumn teacherEmailCol;
    public TableColumn teacherTelCol;

    public Button addTeacherButton;
    public Button removeTeacherButton;

    public Label messageLabel;

    private ScenesController myController;

    public static String selectedGroup;

    public Group() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        selectedGroup = AdminPortal.getSelectedGroup();

        DBConnections.connect();
        ObservableList<Student> infoList = DBConnections.getStudentInfo(selectedGroup);

        this.studentTable.setEditable(true);

        this.studentSSNCol.setCellValueFactory(new PropertyValueFactory("SSN"));
        this.studentFirstNameCol.setCellValueFactory(new PropertyValueFactory("name"));
        this.studentLastNameCol.setCellValueFactory(new PropertyValueFactory("surname"));
        this.studentDateOfBirthCol.setCellValueFactory(new PropertyValueFactory("dateOfBirth"));
        this.studentAddressCol.setCellValueFactory(new PropertyValueFactory("homeAddress"));
        this.studentTelCol.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
        this.studentEmailCol.setCellValueFactory(new PropertyValueFactory("emailAddress"));
        this.studentUsernameCol.setCellValueFactory(new PropertyValueFactory("username"));
        this.studentPasswordCol.setCellValueFactory(new PropertyValueFactory("password"));

        this.studentTable.setItems(infoList);

        studentSSNCol.setCellFactory(TextFieldTableCell.forTableColumn());
        studentSSNCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Student, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Student, String> t) {
                        ((Student) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setSSN(t.getNewValue());
                    }
                }
        );

        studentFirstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        studentFirstNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Student, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Student, String> t) {
                        ((Student) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setName(t.getNewValue());
                    }
                }
        );

        studentLastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        studentLastNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Student, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Student, String> t) {
                        ((Student) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setSurname(t.getNewValue());
                    }
                }
        );

        studentDateOfBirthCol.setCellFactory(TextFieldTableCell.forTableColumn());
        studentDateOfBirthCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Student, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Student, String> t) {
                        ((Student) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setDateOfBirth(t.getNewValue());
                    }
                }
        );

        studentAddressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        studentAddressCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Student, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Student, String> t) {
                        ((Student) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setHomeAddress(t.getNewValue());
                    }
                }
        );


        studentTelCol.setCellFactory(TextFieldTableCell.forTableColumn());
        studentTelCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Student, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Student, String> t) {
                        ((Student) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPhoneNumber(t.getNewValue());
                    }
                }
        );

        studentEmailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        studentEmailCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Student, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Student, String> t) {
                        ((Student) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setEmailAddress(t.getNewValue());
                    }
                }
        );

        studentUsernameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        studentUsernameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Student, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Student, String> t) {
                        ((Student) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setUsername(t.getNewValue());

                    }
                }
        );

        studentPasswordCol.setCellFactory(TextFieldTableCell.forTableColumn());
        studentPasswordCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Student, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Student, String> t) {
                        ((Student) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPassword(t.getNewValue());

                    }
                }
        );


        ObservableList<Teacher> infoList2 = DBConnections.getTeacherInfoGroup(selectedGroup);
        this.teacherTable.setEditable(true);
        this.teacherSsnCol.setCellValueFactory(new PropertyValueFactory("SSN"));
        this.teacherSubjectCol.setCellValueFactory(new PropertyValueFactory("TeachingField"));
        this.teacherFirstNameCol.setCellValueFactory(new PropertyValueFactory("name"));
        this.teacherLastNameCol.setCellValueFactory(new PropertyValueFactory("surname"));
        this.teacherEmailCol.setCellValueFactory(new PropertyValueFactory("emailAddress"));
        this.teacherTelCol.setCellValueFactory(new PropertyValueFactory("phoneNum"));
        this.teacherTable.setItems(infoList2);
    }

    @FXML
    private void handleReturnBtn() throws IOException {
        this.myController.setScenes(SchoolAppFramework.adminSceneID);
    }

    @FXML
    private void handleSaveBtn() {
        System.out.println("Editing students");
        ObservableList<Student> editedList = studentTable.getItems();
        DBConnections.connect();
        DBConnections.editStudents(editedList);
        messageLabel.setTextFill(Color.GREEN);
        messageLabel.setText("Changes saved.");
    }

    @FXML
    private void handleDeleteBtn() {
        Student student = (Student)studentTable.getSelectionModel().getSelectedItem();
        DBConnections.deleteStudent(student);
        messageLabel.setTextFill(Color.GREEN);
        messageLabel.setText("Student deleted \nfrom system.");
    }

    @FXML
    private void handleAddTeacher() throws IOException {
        this.myController.popUpStage(this.addTeacherToGroupFxmlFile);
    }

    @FXML
    private void handleRemoveTeacher() {
        Teacher removedTeacher = (Teacher)teacherTable.getSelectionModel().getSelectedItem();
        System.out.println(removedTeacher.getSSN());
        DBConnections.connect();
        DBConnections.removeTeacherFromGroup(removedTeacher, selectedGroup);
        messageLabel.setTextFill(Color.GREEN);
        messageLabel.setText("Teacher removed \nfrom group.");
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }
}
