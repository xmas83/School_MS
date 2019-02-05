//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HumanResOffice implements Initializable {
    @FXML
    private Button okBtn;

    public HumanResOffice() {
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void handleOkBtn() {
        ((Stage)this.okBtn.getScene().getWindow()).close();
    }
}
