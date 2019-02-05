package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import sample.SystemUsers.Staff;

public class ViewStaff implements Initializable, ControlledScenes {
    public TableView staffTableView;
    public TableColumn ssnCol;
    public TableColumn firstNameCol;
    public TableColumn lastNameCol;
    public TableColumn dobCol;
    public TableColumn addressCol;
    public TableColumn telCol;
    public TableColumn emailCol;
    public TableColumn positionCol;
    public TableColumn usernameCol;
    public TableColumn passwordCol;
    public Label messageLabel;

    private ScenesController myController;

    public ViewStaff() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        DBConnections.connect();
        ObservableList<Staff> infoList = DBConnections.getStaffInfo();
        this.staffTableView.setEditable(true);
        this.ssnCol.setCellValueFactory(new PropertyValueFactory("SSN"));
        this.firstNameCol.setCellValueFactory(new PropertyValueFactory("name"));
        this.lastNameCol.setCellValueFactory(new PropertyValueFactory("surname"));
        this.dobCol.setCellValueFactory(new PropertyValueFactory("dateOfBirth"));
        this.addressCol.setCellValueFactory(new PropertyValueFactory("homeAddress"));
        this.telCol.setCellValueFactory(new PropertyValueFactory("phoneNum"));
        this.emailCol.setCellValueFactory(new PropertyValueFactory("emailAddress"));
        this.positionCol.setCellValueFactory(new PropertyValueFactory("position"));
        this.usernameCol.setCellValueFactory(new PropertyValueFactory("userName"));
        this.passwordCol.setCellValueFactory(new PropertyValueFactory("password"));

        this.staffTableView.setItems(infoList);

        ssnCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ssnCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setSSN(t.getNewValue());
                    }
                }
        );

        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setName(t.getNewValue());
                    }
                }
        );

        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setSurname(t.getNewValue());
                    }
                }
        );

        dobCol.setCellFactory(TextFieldTableCell.forTableColumn());
        dobCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setDateOfBirth(t.getNewValue());
                    }
                }
        );

        addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        addressCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setHomeAddress(t.getNewValue());
                    }
                }
        );


        telCol.setCellFactory(TextFieldTableCell.forTableColumn());
        telCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPhoneNum(t.getNewValue());
                    }
                }
        );

        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setEmailAddress(t.getNewValue());
                    }
                }
        );

        positionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        positionCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPosition(t.getNewValue());

                    }
                }
        );

        usernameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        usernameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setUserName(t.getNewValue());

                    }
                }
        );

        passwordCol.setCellFactory(TextFieldTableCell.forTableColumn());
        passwordCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPassword(t.getNewValue());

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
        ObservableList<Staff> editedList = staffTableView.getItems();
        DBConnections.connect();
        DBConnections.editStaff(editedList);
        messageLabel.setTextFill(Color.GREEN);
        messageLabel.setText("Changes saved.");
    }

    @FXML
    private void handleDeleteBtnBtn() {
        Staff staff = (Staff)staffTableView.getSelectionModel().getSelectedItem();
        DBConnections.deleteStaff(staff);
        messageLabel.setTextFill(Color.GREEN);
        messageLabel.setText("Staff member deleted \nfrom system.");
    }
}
