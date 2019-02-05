//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

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
import sample.SystemUsers.Teacher;

public class ViewTeacher implements Initializable, ControlledScenes {
    public TableView teacherTableView;
    public TableColumn ssnCol;
    public TableColumn firstNameCol;
    public TableColumn lastNameCol;
    public TableColumn dobCol;
    public TableColumn addressCol;
    public TableColumn telCol;
    public TableColumn emailCol;
    public TableColumn subjectCol;
    public TableColumn usernameCol;
    public TableColumn passwordCol;
    public Label messageLabel;
    private ScenesController myController;
    @FXML
    private Button returnBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button deleteBtn;

    public ViewTeacher() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        DBConnections.connect();
        ObservableList<Teacher> infoList = DBConnections.getTeacherInfo();
        this.teacherTableView.setEditable(true);

        this.ssnCol.setCellValueFactory(new PropertyValueFactory("SSN"));
        this.firstNameCol.setCellValueFactory(new PropertyValueFactory("name"));
        this.lastNameCol.setCellValueFactory(new PropertyValueFactory("surname"));
        this.dobCol.setCellValueFactory(new PropertyValueFactory("dateOfBirth"));
        this.addressCol.setCellValueFactory(new PropertyValueFactory("homeAddress"));
        this.telCol.setCellValueFactory(new PropertyValueFactory("phoneNum"));
        this.emailCol.setCellValueFactory(new PropertyValueFactory("emailAddress"));
        this.subjectCol.setCellValueFactory(new PropertyValueFactory("teachingField"));
        this.usernameCol.setCellValueFactory(new PropertyValueFactory("userName"));
        this.passwordCol.setCellValueFactory(new PropertyValueFactory("passWord"));

        this.teacherTableView.setItems(infoList);

        ssnCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ssnCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setSSN(t.getNewValue());
                    }
                }
        );

        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setName(t.getNewValue());
                    }
                }
        );

        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setSurname(t.getNewValue());
                    }
                }
        );

        dobCol.setCellFactory(TextFieldTableCell.forTableColumn());
        dobCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setDateOfBirth(t.getNewValue());
                    }
                }
        );

        addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        addressCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setHomeAddress(t.getNewValue());
                    }
                }
        );


        telCol.setCellFactory(TextFieldTableCell.forTableColumn());
        telCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPhoneNum(t.getNewValue());
                    }
                }
        );

        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setEmailAddress(t.getNewValue());
                    }
                }
        );

        subjectCol.setCellFactory(TextFieldTableCell.forTableColumn());
        subjectCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setTeachingField(t.getNewValue());

                    }
                }
        );

        usernameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        usernameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setUserName(t.getNewValue());

                    }
                }
        );

        passwordCol.setCellFactory(TextFieldTableCell.forTableColumn());
        passwordCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPassWord(t.getNewValue());

                    }
                }
        );
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }

    @FXML
    private void handleReturnBtn() throws IOException {
        this.myController.setScenes(SchoolAppFramework.adminSceneID);
    }

    @FXML
    private void handleUpdateBtn() {
        ObservableList<Teacher> editedList = teacherTableView.getItems();
        DBConnections.connect();
        DBConnections.editTeacher(editedList);
        messageLabel.setTextFill(Color.GREEN);
        messageLabel.setText("Changes saved.");
    }

    @FXML
    private void handleDeleteBtnBtn() {
        Teacher teacher = (Teacher)teacherTableView.getSelectionModel().getSelectedItem();
        DBConnections.deleteTeacher(teacher);
        messageLabel.setTextFill(Color.GREEN);
        messageLabel.setText("Teacher deleted \nfrom system.");
    }


}
