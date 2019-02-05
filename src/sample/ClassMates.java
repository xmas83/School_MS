package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.SystemUsers.Classmate;
import java.net.URL;
import java.util.ResourceBundle;

public class ClassMates implements Initializable {

    @FXML private Button okBtn;
    @FXML private TableView<Classmate> classmatestable;
    @FXML private TableColumn<Classmate,String> name;
    @FXML private TableColumn<Classmate, String> email;
    ObservableList<Classmate> list;
    DBConnections db=new DBConnections();
    private static String loginID;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DBConnections.connect();

        loginID=StudentLogin.getCurrentUser();
        System.out.println(loginID);


       String groupId=db.getStudentGroup(loginID);
       System.out.println(groupId);

       list= db.getGroupParticipant(groupId); //load classmates in the observableList

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        email.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));

        classmatestable.getItems().addAll(list); //Add mates in the table view.
        }

    @FXML
    private void handleOkBtn(){
        ((Stage)okBtn.getScene().getWindow()).close();
    }

}
