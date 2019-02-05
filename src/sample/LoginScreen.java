//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable, ControlledScenes {
    public TextArea newsArea;
    public Label titleLabel;
    public Label categoryLabel;
    @FXML
    private Button adminBtn;
    @FXML
    private Button staffBtn;
    @FXML
    private Button studentBtn;
    @FXML
    private Button teachersBtn;
    @FXML
    private Button exit;
    @FXML
    private TextArea sportNews;
    @FXML
    private TextArea commonNews;
    @FXML
    private TextArea meetings;
    private ScenesController myController;

    public LoginScreen() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        DBConnections.connect();
        ArrayList<String> list = DBConnections.getNews();

        titleLabel.setText(list.get(list.size()-3));
        categoryLabel.setText(list.get(list.size()-2));
        newsArea.setText(list.get(list.size()-1));

        newsArea.setEditable(false);
    }

    @FXML
    private void handleAdmBtn() throws IOException {
        this.myController.loadScene(SchoolAppFramework.adminLoginSceneID,SchoolAppFramework.adminLoginFile);
        this.myController.setScenes(SchoolAppFramework.adminLoginSceneID);
    }

    @FXML
    private void handleStudentBtn() throws IOException {
        this.myController.loadScene(SchoolAppFramework.studentLoginSceneID,SchoolAppFramework.studentLoginFile);
        this.myController.setScenes(SchoolAppFramework.studentLoginSceneID);
    }

    @FXML
    private void handleTeachersBtn() throws IOException {
        this.myController.loadScene(SchoolAppFramework.teacherLoginSceneID,SchoolAppFramework.teacherLoginFile);
        this.myController.setScenes(SchoolAppFramework.teacherLoginSceneID);
    }

    @FXML
    private void handleStaffBtn() throws IOException {
        this.myController.loadScene(SchoolAppFramework.staffLoginSceneID,SchoolAppFramework.staffLoginFile);
        this.myController.setScenes(SchoolAppFramework.staffLoginSceneID);
    }

    @FXML
    private void exitAppBtn() {
        this.myController.setScenes(SchoolAppFramework.coverPageSceneID);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }
}
