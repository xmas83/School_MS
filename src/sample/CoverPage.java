//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class CoverPage implements Initializable, ControlledScenes {
    private ScenesController myController;
    @FXML
    private ChoiceBox schools;
    @FXML
    private Button option;
    @FXML
    private Button exit;
    String schoolName1 = "KILIMANJARO TECHNICAL HIGH SCHOOL";
    ObservableList<String> list;

    public CoverPage() {
        this.list = FXCollections.observableArrayList(new String[]{this.schoolName1});
    }

    public void initialize(URL location, ResourceBundle resources) {
        Line path = new Line(0.0D, 0.0D, 450.0D, 310.0D);
        Path path1 = new Path();
        path1.getElements().add(new MoveTo(0.0D, 0.0D));
        path1.getElements().add(new MoveTo(200.0D, 200.0D));
        PathTransition pt = new PathTransition(Duration.millis(2000.0D), path, this.option);
        pt.setAutoReverse(false);
        pt.play();
        this.schools.setValue(this.schoolName1);
        this.schools.setItems(this.list);
    }

    @FXML
    private void schoolOption() {
        this.myController.setScenes(SchoolAppFramework.loginSceneID);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }

    @FXML
    private void setExit() {
        Platform.exit();
    }
}
