package sample;

import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.SystemUsers.Storage.sendmail;

public class TeacherPortal extends Application implements Initializable,Actions,ControlledScenes {
    public Label username;
    @FXML private Button viewTeacherBtn;
    @FXML private Button viewStudentBtn;
    @FXML private Button viewAdministrationBtn;
    @FXML private Button exitBtn;
    @FXML private Button updatePwBtn;
    @FXML private Button searchBtn;
    @FXML private MenuButton groups;
    @FXML private MenuItem groupYear9;
    @FXML private MenuItem groupYear10;
    @FXML private MenuItem groupYear11;
    @FXML private MenuItem groupYear12;
    @FXML private TextField searchField;
    @FXML private ComboBox administrationBox;
    @FXML private ComboBox teachersBox;
    @FXML private ComboBox group1Box;
    @FXML private ComboBox group2Box;
    @FXML private ComboBox group3Box;
    @FXML private ComboBox group4Box;
    @FXML private Button okBtn;

    private ScenesController myController;
    private String searchFxmlFile="searchresult.fxml";
    private String passwordchangeFxmlFile="changePassword.fxml";
    DBConnections con = new DBConnections();
    private String receiver;

    private ObservableList adminList;
    private ObservableList teacherList;
    private ObservableList group1List;
    private ObservableList group2List;
    private ObservableList group3List;
    private ObservableList group4List;
    private String groupID1 = "1";
    private String groupID2 = "2";
    private String groupID3 = "3";
    private String groupID4 = "4";

    public static String currentUser;
    private static String selectedGroup;

    public static String getCurrentUser() {
        return currentUser;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        currentUser = TeachersLogIn.getCurrentUser();
        username.setText(DBConnections.getFirstName(currentUser));

        DBConnections.connect();

        teacherList = con.teachersName();
        adminList = con.adminsName();
        group1List = con.studentNamesByGroup(groupID1);
        group2List = con.studentNamesByGroup(groupID2);
        group3List = con.studentNamesByGroup(groupID3);
        group4List = con.studentNamesByGroup(groupID4);

        group1Box.setItems(group1List);
        group2Box.getItems().addAll(group2List);
        group3Box.getItems().addAll(group3List);
        group4Box.getItems().addAll(group4List);
        teachersBox.getItems().addAll(teacherList);
        administrationBox.setItems(adminList);

    }

    public void sendMail() throws URISyntaxException {
        DBConnections.connect();

        if (administrationBox.getSelectionModel().isEmpty()==false){
            receiver=administrationBox.getValue().toString();
        String subj1 = "";
        String text1 = "";
        String recipient1 = con.getReceiverEmailAdddress(receiver);
        String cc1 = "";
        sendmail(subj1,text1,recipient1,cc1);
        administrationBox.getSelectionModel().clearSelection();
        }
        if (teachersBox.getSelectionModel().isEmpty()==false){
            receiver=teachersBox.getValue().toString();
            String subj1 = "";
            String text1 = "";
            String recipient1 = con.getReceiverEmailAdddress(receiver);
            String cc1 = "";
            sendmail(subj1,text1,recipient1,cc1);
            teachersBox.getSelectionModel().clearSelection();
        }
        if (group1Box.getSelectionModel().isEmpty()==false){
            receiver=group1Box.getValue().toString();
            String subj1 = "";
            String text1 = "";
            String recipient1 = con.getReceiverEmailAdddress(receiver);
            String cc1 = "";
            sendmail(subj1,text1,recipient1,cc1);
            group1Box.getSelectionModel().clearSelection();
        }
        if (group2Box.getSelectionModel().isEmpty()==false){
            receiver=group2Box.getValue().toString();
            String subj1 = "";
            String text1 = "";
            String recipient1 = con.getReceiverEmailAdddress(receiver);
            String cc1 = "";
            sendmail(subj1,text1,recipient1,cc1);
            group2Box.getSelectionModel().clearSelection();
        }
        if (group3Box.getSelectionModel().isEmpty()==false){
            receiver=group3Box.getValue().toString();
            String subj1 = "";
            String text1 = "";
            String recipient1 = con.getReceiverEmailAdddress(receiver);
            String cc1 = "";
            sendmail(subj1,text1,recipient1,cc1);
            group3Box.getSelectionModel().clearSelection();
        }
        if (group4Box.getSelectionModel().isEmpty()==false){
            receiver=group4Box.getValue().toString();
            String subj1 = "";
            String text1 = "";
            String recipient1 = con.getReceiverEmailAdddress(receiver);
            String cc1 = "";
            sendmail(subj1,text1,recipient1,cc1);
            group4Box.getSelectionModel().clearSelection();
        }

        }

        @FXML private void checkmails(){
            HostServicesDelegate hostServices = HostServicesFactory.getInstance(this);
            hostServices.showDocument("https://mail.google.com/mail/u/0/#inbox");
        }

    @FXML private void handleSearchBtn() throws IOException {
            SearchResult.setSearchString(searchField.getText());
            myController.popUpStage(searchFxmlFile);
    }

    @FXML private void goToGroup9()throws IOException {
        setSelectedGroup("1");
        myController.loadScene(SchoolAppFramework.viewAddgradeSceneID, SchoolAppFramework.viewAddgradeSceneIDFile);
        myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);

    }
    @FXML private void goToGroup10()throws IOException {
        setSelectedGroup("2");
        myController.loadScene(SchoolAppFramework.viewAddgradeSceneID, SchoolAppFramework.viewAddgradeSceneIDFile);
        myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);

    }
    @FXML private void goToGroup11()throws IOException {
        setSelectedGroup("3");
        myController.loadScene(SchoolAppFramework.viewAddgradeSceneID, SchoolAppFramework.viewAddgradeSceneIDFile);
        myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);

    }
    @FXML private void goToGroup12()throws IOException {
        setSelectedGroup("4");
        myController.loadScene(SchoolAppFramework.viewAddgradeSceneID, SchoolAppFramework.viewAddgradeSceneIDFile);
        myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);

    }

    @FXML private void goToAdminMbr()throws IOException{
        myController.setScenes(SchoolAppFramework.teacherContactAdminSceneID);

    }
    @FXML private void goToTeacher()throws IOException{
        myController.setScenes(SchoolAppFramework.teachersContactsSceneID);

    }

    @Override
    public void exitBtn(ActionEvent event) throws IOException {
        myController.setScenes(SchoolAppFramework.loginSceneID);

    }
    @Override
    public void updatePword(ActionEvent event) throws IOException {
        myController.popUpStage(passwordchangeFxmlFile);

    }

    @Override
    public void setScreenParent(ScenesController screenController) {
        myController=screenController;
    }

    @Override
    public void start(Stage primaryStage){

    }


    public static String getSelectedGroup() {
        return selectedGroup;
    }

    public static void setSelectedGroup(String selectedGroup) {
        TeacherPortal.selectedGroup = selectedGroup;
    }
}
