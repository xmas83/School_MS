//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SchoolAppFramework extends Application {
    public static String loginSceneID = "Login";
    public static String loginSceneFile = "login.fxml";
    public static String adminSceneID = "Admin Portal";
    public static String adminSceneFile = "admin.fxml";
    public static String teacherSceneID = "Teacher's Portal";
    public static String teacherSceneFile = "teacher.fxml";
    public static String studentSceneID = "Student's Portal";
    public static String studentSceneFile = "student.fxml";
    public static String staffSceneID = "StaffPortal's Portal";
    public static String staffSceneFile = "staff.fxml";
    public static String adminLoginSceneID = "Login as Admin";
    public static String adminLoginFile = "adminlogin.fxml";
    public static String teacherLoginSceneID = "Login as Teacher";
    public static String teacherLoginFile = "teacherslogin.fxml";
    public static String studentLoginSceneID = "Login as Student";
    public static String studentLoginFile = "studentlogin.fxml";
    public static String staffLoginSceneID = "Login as StaffPortal";
    public static String staffLoginFile = "stafflogin.fxml";
    public static String groupSceneID = "Group";
    public static String groupSceneIDFile = "group.fxml";
    public static String viewAddgradeSceneID = "View & Add Grade";
    public static String viewAddgradeSceneIDFile = "viewaddgrade.fxml";
    public static String viewAdminSceneID = "View Admin";
    public static String viewAdminSceneIDFile = "viewadmin.fxml";
    public static String viewStaffSceneID = "View Staff";
    public static String viewStaffSceneIDFile = "viewstaff.fxml";
    public static String viewTeacherSceneID = "View Teacher";
    public static String viewTeacherSceneIDFile = "viewteacher.fxml";
    public static String teacherContactAdminSceneID = "teacher view admin";
    public static String teacherContactAdminSceneFile = "teacherContactAdmin.fxml";
    public static String studentContactAdminSceneID = "student view admin";
    public static String studentContactAdminSceneFile = "studentContactAdmin.fxml";
    public static String teachersContactsSceneID = "teachers contacts";
    public static String teachersContactsSceneFile = "teachersContacts.fxml";
    public static String coverPageSceneID = "coverPage";
    public static String coverPageSceneFile = "coverPage.fxml";

    public SchoolAppFramework() {
    }

    public void start(Stage primaryStage) throws Exception {
        ScenesController mainContainer = new ScenesController();

        mainContainer.loadScene(coverPageSceneID, coverPageSceneFile);

        mainContainer.setScenes(coverPageSceneID);

        mainContainer.loadScene(loginSceneID, loginSceneFile);
        mainContainer.loadScene(teacherSceneID, teacherSceneFile);
        //mainContainer.loadScene(studentSceneID, studentSceneFile);
        //mainContainer.loadScene(staffSceneID, staffSceneFile);
        //mainContainer.loadScene(teacherLoginSceneID, teacherLoginFile);
        //mainContainer.loadScene(studentLoginSceneID, studentLoginFile);
        //mainContainer.loadScene(staffLoginSceneID, staffLoginFile);
        //mainContainer.loadScene(adminSceneID, adminSceneFile);
        //mainContainer.loadScene(adminLoginSceneID, adminLoginFile);
        //mainContainer.loadScene(groupSceneID, groupSceneIDFile);
        //mainContainer.loadScene(viewAddgradeSceneID, viewAddgradeSceneIDFile);
        mainContainer.loadScene(viewAdminSceneID, viewAdminSceneIDFile);
        //mainContainer.loadScene(viewStaffSceneID, viewStaffSceneIDFile);
        //mainContainer.loadScene(viewTeacherSceneID, viewTeacherSceneIDFile);
        mainContainer.loadScene(teacherContactAdminSceneID, teacherContactAdminSceneFile);
        mainContainer.loadScene(studentContactAdminSceneID, studentContactAdminSceneFile);
        //mainContainer.loadScene(teachersContactsSceneID, teachersContactsSceneFile);


        Group root = new Group();
        root.getChildren().add(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
