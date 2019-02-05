//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class AdminLogin implements UserLogin, ControlledScenes {
    @FXML
    private Label messageLabel;
    @FXML
    private PasswordField password;
    @FXML
    private TextField userName;
    @FXML
    private Button enterASAdmin;
    @FXML
    private Button yesBtn;
    @FXML
    private Button abandonBtn;
    private ScenesController myController;
    private String passwordRecFxmlFileName = "passwordRecovery.fxml";
    private static String currentUser;
    private String user;

    public AdminLogin() {
    }

    public void login(ActionEvent event) throws IOException {
        System.out.println("Login button pressed.");
        this.messageLabel.setText("");
        System.out.println("Entered username: " + this.userName.getText());
        System.out.println("Entered password: " + this.password.getText());

        if (!this.userName.getText().equals("") && !this.password.getText().equals("")) {
            DBConnections.connect();
            ArrayList<String> loginIDList = DBConnections.getLoginID();
            ArrayList<String> passwordList = DBConnections.getPassword();
            ArrayList<String> ssnList = DBConnections.getSSN();

            for(int i = 0; i < loginIDList.size(); ++i) {
                System.out.println("Checking for correct credentials...");
                if (this.userName.getText().equals(loginIDList.get(i)) && this.password.getText().equals(passwordList.get(i))) {
                    System.out.println("Checking admin status...");
                    if (DBConnections.isAdmin(ssnList.get(i))) {
                        System.out.println("Swapping scenes...");
                        user = userName.getText();
                        setCurrentUser(user);
                        messageLabel.setText("Welcome!");
                        messageLabel.setTextFill(Color.GREEN);
                        myController.loadScene(SchoolAppFramework.adminSceneID, SchoolAppFramework.adminSceneFile);
                        myController.setScenes(SchoolAppFramework.adminSceneID);
                    } else {
                        messageLabel.setText("You are not an admin, please log in to the\n correct page.");
                        messageLabel.setTextFill(Color.RED);
                    }
                    break;
                }

                messageLabel.setText("Please enter the correct credentials.");
                messageLabel.setTextFill(Color.RED);
            }
        } else {
            messageLabel.setText("Please enter your username and password \nin the fields below.");
            messageLabel.setTextFill(Color.RED);
        }

    }

    public void passwordRecovering(ActionEvent event) throws IOException {
        myController.popUpStage(passwordRecFxmlFileName);
    }

    public void abandonAction(ActionEvent event) {
        myController.setScenes(SchoolAppFramework.loginSceneID);
    }

    public void setScreenParent(ScenesController screenController) {
        myController = screenController;
    }

    public static String getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(String currentMethodUser) {
        currentUser = currentMethodUser;
    }
}
