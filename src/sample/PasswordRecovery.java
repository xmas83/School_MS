package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.mail.MessagingException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.SystemUsers.Storage.sendMailToGroupParticipant;

public class PasswordRecovery implements Initializable {
    @FXML private Button okBtn;
    @FXML private TextField ssn;
    @FXML private TextField email;

    DBConnections con =new DBConnections();
    private static String USER_NAME = "kt.highschool111@gmail.com";  // GMail user name
    private static String PASSWORD = "Projectcourse2"; // GMail password
    private static String RECIPIENT;
    String from = USER_NAME;
    String pass = PASSWORD;
    String subject = "Recover your forgotten password.";
    String body;

    private String usrEmail;
    private String recoveredPassword;
    private String usrSSN;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DBConnections.connect();

        }

    @FXML private void okeyBtn(ActionEvent event) throws MessagingException {
        DBConnections.connect();

        usrEmail = email.getText();
        RECIPIENT = usrEmail;
        String[] to = {RECIPIENT};
        usrSSN=ssn.getText();
        recoveredPassword = con.recoveredPassword(usrSSN,usrEmail);
        body = " This is your password  : "+recoveredPassword;

        sendMailToGroupParticipant(from,pass,to,subject,body);

        Alert info=new Alert(Alert.AlertType.INFORMATION);
        info.setHeaderText("              PASSWORD RECOVERED!");
        info.setContentText("An email have been sent to you with your password.");
        info.show();
        ((Stage)okBtn.getScene().getWindow()).close();
    }

}
