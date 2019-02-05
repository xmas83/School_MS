//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.SystemUsers.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchResult implements Initializable {
    public TableColumn ssnCol;
    public TableColumn firstNameCol;
    public TableView searchResultText;
    public TableColumn lastNameCol;
    public TableColumn emailCol;
    @FXML
    private Button okeyBtn;
    private static String searchString;

    public static void setSearchString(String string) {
        searchString = string;
    }

    public SearchResult() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        setData(DBConnections.getSearchResult(searchString));
    }

    @FXML
    private void handleOkeyBtn() {
        ((Stage)this.okeyBtn.getScene().getWindow()).close();
    }

    public void setData(ObservableList<Person> list){
            if(list==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("No data found");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a different name.");
                alert.show();
            }else{
                this.ssnCol.setCellValueFactory(new PropertyValueFactory("SSN"));
                this.firstNameCol.setCellValueFactory(new PropertyValueFactory("name"));
                this.lastNameCol.setCellValueFactory(new PropertyValueFactory("surname"));
                this.emailCol.setCellValueFactory(new PropertyValueFactory("emailAddress"));

                searchResultText.setItems(list);
            }
    }

}
