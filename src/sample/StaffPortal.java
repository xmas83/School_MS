//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffPortal implements Initializable, Actions, ControlledScenes {
    @FXML
    private Button humanResOffice;
    @FXML
    private Button workTimeInfo;
    @FXML
    private Button salaryInfo;
    @FXML
    private Button logOut;
    @FXML
    private Button exit;
    @FXML
    private Button updatePw;
    @FXML
    private Label staffName;
    @FXML
    private Label startTime;
    @FXML
    private Label endTime;
    private ScenesController myController;
    private String fxmlFileChangePW = "changepword.fxml";
    private String fxmlFileHumanRes = "humanResOffice.fxml";

    public static String currentUser;

    public StaffPortal() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        currentUser = StaffLogin.getCurrentUser();
        staffName.setText(DBConnections.getFirstName(currentUser));
    }

    @FXML
    private void viewHumaRes() throws IOException {
        this.myController.popUpStage(this.fxmlFileHumanRes);
    }

    @FXML
    private void viewWorkTime() throws IOException {
    }

    @FXML
    private void viewSalaryInfo() throws IOException {
    }

    @FXML
    private void manageLogOUt() throws IOException {
    }

    public void exitBtn(ActionEvent event) throws IOException {
        this.myController.setScenes(SchoolAppFramework.loginSceneID);
    }

    public void updatePword(ActionEvent event) throws IOException {
        this.myController.popUpStage(this.fxmlFileChangePW);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }
}
