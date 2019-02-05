package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class News implements Initializable{
    public Button updateBtn;
    public TextField title;
    public ChoiceBox category;
    public TextArea newsText;

    ObservableList<String> list = FXCollections.observableArrayList(new String[]{"Sports", "Events", "Study", "Other"});

    public void initialize(URL location, ResourceBundle resources) {
        this.category.setItems(this.list);
    }

    public void addItem() {
        System.out.println("Adding news item");
        DBConnections.connect();
        DBConnections.addNewsItem(title.getText(), category.getValue().toString(), newsText.getText());
        ((Stage)updateBtn.getScene().getWindow()).close();
    }
}
