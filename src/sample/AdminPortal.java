//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminPortal implements Initializable, Actions, ControlledScenes {
    @FXML
    private Button teachersModule;
    @FXML
    private MenuButton studentGroup;
    @FXML
    private MenuButton addPerson;
    @FXML
    private MenuButton addmanagePerson;
    @FXML
    private MenuItem addStudent;
    @FXML
    private MenuItem addTeacher;
    @FXML
    private MenuItem addStaff;
    @FXML
    private MenuItem addAdmin;
    @FXML
    private MenuItem groupYear9;
    @FXML
    private MenuItem groupYear10;
    @FXML
    private MenuItem groupYear11;
    @FXML
    private MenuItem groupYear12;
    @FXML
    private Button staffsModule;
    @FXML
    private Button classessModule;
    @FXML
    private Button coursessModule;
    @FXML
    private Button newsModule;
    @FXML
    private Button exit;
    @FXML
    private Button updatePw;
    @FXML
    private Button searchBtn;
    @FXML
    private Button managePerson;
    @FXML
    private Label username;
    @FXML
    private TextField searchField;
    private static String selectedGroup;
    private String group;
    private ScenesController myController;
    private String newsFxmlFileName = "news.fxml";
    private String searchFxmlFileName = "searchresult.fxml";
    private String addStudentFxmlFileName = "addstudent.fxml";
    private String addTeacherFxmlFileName = "addteacher.fxml";
    private String addStaffFxmlFileName = "addstaff.fxml";
    private String addAdminFxmlFileName = "addadmin.fxml";
    private String changePWFxmlFileName = "changePassword.fxml";

    public static String currentUser;

    public AdminPortal() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        currentUser = AdminLogin.getCurrentUser();
        this.username.setText(DBConnections.getFirstName(currentUser));
    }

    @FXML
    private void manageBoardMbr() throws IOException {
        this.myController.setScenes(SchoolAppFramework.viewAdminSceneID);
    }

    @FXML
    private void manageStaff() throws IOException {
        this.myController.loadScene(SchoolAppFramework.viewStaffSceneID, SchoolAppFramework.viewStaffSceneIDFile);
        this.myController.setScenes(SchoolAppFramework.viewStaffSceneID);
    }

    @FXML
    private void manageTeacher() throws IOException {
        this.myController.loadScene(SchoolAppFramework.viewTeacherSceneID, SchoolAppFramework.viewTeacherSceneIDFile);
        this.myController.setScenes(SchoolAppFramework.viewTeacherSceneID);
    }

    @FXML
    private void upgradeNews() throws IOException {
        this.myController.popUpStage(this.newsFxmlFileName);
    }

    @FXML
    private void handleSearchBtn() throws IOException {
        SearchResult.setSearchString(searchField.getText());
        this.myController.popUpStage(this.searchFxmlFileName);
    }

    @FXML
    private void addNewStudent() throws IOException {
        this.myController.popUpStage(this.addStudentFxmlFileName);
    }

    @FXML
    private void addNewTeacher() throws IOException {
        this.myController.popUpStage(this.addTeacherFxmlFileName);
    }

    @FXML
    private void addNewStaff() throws IOException {
        this.myController.popUpStage(this.addStaffFxmlFileName);
    }

    @FXML
    private void addNewAdmin() throws IOException {
        this.myController.popUpStage(this.addAdminFxmlFileName);
    }

    @FXML
    private void manageGroupYear9() throws IOException {
        this.group = "1";
        setSelectedGroup(this.group);
        this.myController.loadScene(SchoolAppFramework.groupSceneID, SchoolAppFramework.groupSceneIDFile);
        this.myController.setScenes(SchoolAppFramework.groupSceneID);
    }

    @FXML
    private void manageGroupYear10() throws IOException {
        this.group = "2";
        setSelectedGroup(this.group);
        this.myController.loadScene(SchoolAppFramework.groupSceneID, SchoolAppFramework.groupSceneIDFile);
        this.myController.setScenes(SchoolAppFramework.groupSceneID);
    }

    @FXML
    private void manageGroupYear11() throws IOException {
        this.group = "3";
        setSelectedGroup(this.group);
        this.myController.loadScene(SchoolAppFramework.groupSceneID, SchoolAppFramework.groupSceneIDFile);
        this.myController.setScenes(SchoolAppFramework.groupSceneID);
    }

    @FXML
    private void manageGroupYear12() throws IOException {
        this.group = "4";
        setSelectedGroup(this.group);
        this.myController.loadScene(SchoolAppFramework.groupSceneID, SchoolAppFramework.groupSceneIDFile);
        this.myController.setScenes(SchoolAppFramework.groupSceneID);
    }

    public void exitBtn(ActionEvent event) throws IOException {
        this.myController.setScenes(SchoolAppFramework.loginSceneID);
    }

    public void updatePword(ActionEvent event) throws IOException {
        this.myController.popUpStage(this.changePWFxmlFileName);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }

    public static String getSelectedGroup() {
        return selectedGroup;
    }

    public static void setSelectedGroup(String group) {
        selectedGroup = group;
    }
}
