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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import javafx.util.converter.DoubleStringConverter;
import sample.SystemUsers.Grades;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewAddGrade implements Initializable, ControlledScenes {

    public Label messageLabel;
    ScenesController myController;

    @FXML
    private Button returnBtn;
    @FXML
    private TableColumn<Grades,String> name;
    @FXML
    private TableColumn<Grades,String> ssn;
    @FXML
    private TableColumn<Grades,String> email;
    @FXML
    private TableColumn<Grades,Double> mgrade1;
    @FXML
    private TableColumn<Grades,Double> mgrade2;
    @FXML
    private Button refresh;

    @FXML
    private Label groupName;

    @FXML
    private TableView<Grades> gradetable;

    public ViewAddGrade() {
    }



    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }




    @FXML
    private void handleReturnBtn() throws IOException {
        this.myController.setScenes(SchoolAppFramework.teacherSceneID);
    }

    /**
     * This method will load the Data from database and data will display in the tableView
     */
    private void loadData(){
        System.out.println("loadData running.");
        gradetable.getItems().clear();
        DBConnections.connect();
        ObservableList<Grades> gradeList = DBConnections.getGradeInfo(TeacherPortal.getSelectedGroup(), TeacherPortal.getCurrentUser());

        ssn.setCellValueFactory(new PropertyValueFactory("SSN"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        email.setCellValueFactory(new PropertyValueFactory("emailAddress"));
        mgrade1.setCellValueFactory (new PropertyValueFactory("Mgrade1"));
        mgrade1.setCellFactory(TextFieldTableCell.<Grades, Double>forTableColumn(new DoubleStringConverter()));
        mgrade2.setCellValueFactory (new PropertyValueFactory("Mgrade2"));
        mgrade2.setCellFactory(TextFieldTableCell.<Grades, Double>forTableColumn(new DoubleStringConverter()));
        gradetable.setItems(gradeList);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }

    @FXML
    private void gradeEdit(TableColumn.CellEditEvent<Grades, Double> event){
        Grades g = event.getRowValue();
        int i;
        if(event.getNewValue()==null){
            emptyMessage();
        }else{
            //Same thing but table name grades
            i = DBConnections.updateGradeTable("grades","GradeOne",event.getNewValue().toString(),
                   String.valueOf(g.getGid()));
            if(i!=0){
                messageLabel.setTextFill(Color.GREEN);
                messageLabel.setText("Grade updated.");
            }else{
                messageLabel.setTextFill(Color.RED);
                messageLabel.setText("The grade was not updated. \nPlease contact an admin.");
            }
        }
    }

    /**
     * This method is used to edit the grade Two column from tableView and update the tableView with database
     * @param event
     * @throws Exception
     */
    @FXML
    private void grade2Edit(TableColumn.CellEditEvent<Grades, Double> event){
        Grades g = event.getRowValue();
        int i;
        if(event.getNewValue()==null){
            emptyMessage();
        }else{
            //Same thing
           i = DBConnections.updateGradeTable("grades","GradeTwo",event.getNewValue().toString(),
                   String.valueOf(g.getGid()));
           if(i!=0){
               System.out.println("column updated");
           }else{
               System.out.println("column not updated");
           }
        }
    }

    /**
     * If any column is empty or null then the application will generate the error message
     * This method is used to create the alert message for empty columns
     */
    private void emptyMessage(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Empty");
        alert.setHeaderText(null);
        alert.setContentText("Please enter corrent value in the column");
        alert.showAndWait();
    }
}
