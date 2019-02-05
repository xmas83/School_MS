package sample;

import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.SystemUsers.Storage.sendTranscript;
import static sample.SystemUsers.Storage.sendmail;


public class StudentPortal extends Application implements Initializable,Actions,ControlledScenes {

    @FXML private Button exit;
    @FXML private Button pdfViewT1;
    @FXML private Button pdfViewT2;
    @FXML private Button viewBoardMembers;
    @FXML private Button viewTeachers;
    @FXML private Button viewClassMates;
    @FXML private Button updatePw;
    @FXML private Button sendMsgTo;
    @FXML private Button checkMsgBtn;

    @FXML private Label mathsGrade1;
    @FXML private Label biologyGrade1;
    @FXML private Label chemistryGrade1;
    @FXML private Label englishGrade1;
    @FXML private Label philosophyGrade1;
    @FXML private Label physicsGrade1;

    @FXML private Label mathsGrade1Transcript;
    @FXML private Label biologyGrade1Transcript;
    @FXML private Label chemistryGrade1Transcript;
    @FXML private Label englishGrade1Transcript;
    @FXML private Label philosophyGrade1Transcript;
    @FXML private Label physicsGrade1Transcript;

    @FXML private Label mathsGrade2;
    @FXML private Label biologyGrade2;
    @FXML private Label chemistryGrade2;
    @FXML private Label englishGrade2;
    @FXML private Label philosophyGrade2;
    @FXML private Label physicsGrade2;

    @FXML private Label mathsGrade2Transcript;
    @FXML private Label biologyGrade2Transcript;
    @FXML private Label chemistryGrade2Transcript;
    @FXML private Label englishGrade2Transcript;
    @FXML private Label philosophyGrade2Transcript;
    @FXML private Label physicsGrade2Transcript;

    @FXML private Label studentNameTranscript1;
    @FXML private Label studentNameTranscript2;
    @FXML private Label userName;

    @FXML private Label labelComment1;
    @FXML private Label labelComment2;
    @FXML private Label labelComment3;
    @FXML private Label labelComment4;
    @FXML private Label labelComment5;
    @FXML private Label labelComment6;
    @FXML private Label labelComment7;
    @FXML private Label labelComment8;

    @FXML private AnchorPane transcript1;
    @FXML private AnchorPane transcript2;
    @FXML private ChoiceBox classmateBox;
//
//    private static String receiverName;
    private String receiver;
//    private static String userEmail;
//    private String usrEmail;
//    private static String userPassword;
//    private String passW;

    private ScenesController myController;
    private String fxmlFileClassmate = "classMates.fxml";
    private String fxmlFileContactTeacher = "studentContactTeacher.fxml";
    private String fxmlFileChangePW = "changePassword.fxml";
    private String fxmlFileSendMessageBox = "sendMessageBox1.fxml";
    private static String usr;
    private static String usrname;
    private static String fullname;
    private  String subjectPhysics="Physics";
    private  String subjectChemistry="Chemistry";
    private  String subjectEnglish="English";
    private  String subjectPhilosophy="Philosophy";
    private  String subjectMaths="Maths";
    private  String subjectBiology="Biology";
    DBConnections con = new DBConnections();

    private static String USER_NAME = "kt.highschool111@gmail.com";  // GMail user name
    private static String PASSWORD = "Projectcourse2"; // GMail password
    private static String RECIPIENT;
    String from = USER_NAME;
    String pass = PASSWORD;
    String to;
    String body = "Kilimajaro technical highschool";
    private ObservableList classMateList;
    private ObservableList groupTeacherList;
    private String groupID;




    public StudentPortal(){}

    @Override
    public void start(Stage primaryStage) throws Exception {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DBConnections.connect();

        usr = StudentLogin.getCurrentUser();
        usrname = con.getStudentfisrtName(usr);
        this.userName.setText(usrname);
        RECIPIENT = con.getCurrentUserEmail(usr);

        fullname = con.getStudentFullName(usr);
        this.studentNameTranscript1.setText(fullname);
        this.studentNameTranscript2.setText(fullname);
        System.out.println(usrname);
        System.out.println(fullname);

        groupID = con.getStudentGroup(usr);
        classMateList = con.ClassmatesName(groupID);
        groupTeacherList = con.groupTeacher(usr);

        classmateBox.setItems(classMateList);
        classmateBox.getItems().addAll(groupTeacherList);

        //**GRADE SEMESTER 1**//*
        physicsGrade1.setText(String.valueOf(con.getfirstSemesterGrades(usr,subjectPhysics)));
        physicsGrade1Transcript.setText(physicsGrade1.getText());

        philosophyGrade1.setText(String.valueOf(con.getfirstSemesterGrades(usr,subjectPhilosophy)));
        philosophyGrade1Transcript.setText(philosophyGrade1.getText());

        englishGrade1.setText(String.valueOf(con.getfirstSemesterGrades(usr,subjectEnglish)));
        englishGrade1Transcript.setText(englishGrade1.getText());

        biologyGrade1.setText(String.valueOf(con.getfirstSemesterGrades(usr,subjectBiology)));
        biologyGrade1Transcript.setText(biologyGrade1.getText());

        mathsGrade1.setText(String.valueOf(con.getfirstSemesterGrades(usr,subjectMaths)));
        mathsGrade1Transcript.setText(mathsGrade1.getText());

        chemistryGrade1.setText(String.valueOf(con.getfirstSemesterGrades(usr,subjectChemistry)));
        chemistryGrade1Transcript.setText(chemistryGrade1.getText());

        //**GRADE SEMESTER 2**//*
        physicsGrade2.setText(String.valueOf(con.getSecondSemesterGrades(usr,subjectPhysics)));
        physicsGrade2Transcript.setText(physicsGrade2.getText());

        philosophyGrade2.setText(String.valueOf(con.getSecondSemesterGrades(usr,subjectPhilosophy)));
        philosophyGrade2Transcript.setText(philosophyGrade2.getText());

        englishGrade2.setText(String.valueOf(con.getSecondSemesterGrades(usr,subjectEnglish)));
        englishGrade2Transcript.setText(englishGrade2.getText());

        biologyGrade2.setText(String.valueOf(con.getSecondSemesterGrades(usr,subjectBiology)));
        biologyGrade2Transcript.setText(biologyGrade2.getText());

        mathsGrade2.setText(String.valueOf(con.getSecondSemesterGrades(usr,subjectMaths)));
        mathsGrade2Transcript.setText(mathsGrade2.getText());

        chemistryGrade2.setText(String.valueOf(con.getSecondSemesterGrades(usr,subjectChemistry)));
        chemistryGrade2Transcript.setText(chemistryGrade2.getText());
        }


    @FXML private void pdfViewBtn1(){
        WritableImage image = transcript1.snapshot(new SnapshotParameters(), null);
        File file = new File("transcript.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage=new Stage();
        File file1 = new File("transcript.png");

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(file1.toURI().toString());
        StackPane root = new StackPane();
        root.getChildren().add(webView);
        Scene scene = new Scene(root, 500, 700);
        primaryStage.setTitle("Transcript1");
        primaryStage.setScene(scene);
        primaryStage.show();


        PDDocument doc= new PDDocument();
        PDPage page = new PDPage();
        PDImageXObject pdImageXObject;
        PDPageContentStream content;
        try {
            pdImageXObject = PDImageXObject.createFromFile("transcript.png",doc);
            content = new PDPageContentStream(doc, page);
            content.drawImage(pdImageXObject,0,300);
            content.close();
            doc.addPage(page);
            doc.save("transcript1.pdf");
            doc.close();
            file.delete();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        to=RECIPIENT;
        System.out.println(RECIPIENT);
        String subject="First semesterTranscript";
        String pdfFile ="transcript1.pdf";
        try {
            sendTranscript(from, pass, to, subject, body,pdfFile);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }


    @FXML private void pdfVeiwBtn2() {
        WritableImage image = transcript2.snapshot(new SnapshotParameters(), null);
        File file = new File("transcript.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage=new Stage();
        File file1 = new File("transcript.png");

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(file1.toURI().toString());
        StackPane root = new StackPane();
        root.getChildren().add(webView);
        Scene scene = new Scene(root, 500, 700);
        primaryStage.setTitle("Transcript2");
        primaryStage.setScene(scene);
        primaryStage.show();

        PDDocument doc= new PDDocument();
        PDPage page = new PDPage();
        PDImageXObject pdImageXObject;
        PDPageContentStream content;
        try {
            pdImageXObject = PDImageXObject.createFromFile("transcript.png",doc);
            content = new PDPageContentStream(doc, page);
            content.drawImage(pdImageXObject,0,300);
            content.close();
            doc.addPage(page);
            doc.save("transcript2.pdf");
            doc.close();
            file.delete();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        to=RECIPIENT;
        System.out.println(RECIPIENT);
        String subject="Second semesterTranscript";
        String pdfFile="transcript2.pdf";
        try {
            sendTranscript(from, pass, to, subject, body,pdfFile);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }

    public void viewBoardMbrBtn() {
        myController.setScenes(SchoolAppFramework.studentContactAdminSceneID);
    }

    public void viewClassMateBtn() throws IOException {
        myController.popUpStage(fxmlFileClassmate);

    }

    public void viewTeacherBtn() throws IOException {
        myController.popUpStage(fxmlFileContactTeacher);
    }

    public void sendMsgToClassmate() throws URISyntaxException {
        DBConnections.connect();
        receiver = classmateBox.getValue().toString();
        String subj = "";
        String text = "";
        String recipient = con.getReceiverEmailAdddress(receiver);
        String cc = "";

        sendmail(subj,text,recipient,cc);
        }

        public void checkMail(){
            HostServicesDelegate hostServices = HostServicesFactory.getInstance(this);
            hostServices.showDocument("https://mail.google.com/mail/u/0/#inbox");
        }

    @Override
    public void exitBtn(ActionEvent event){
            myController.setScenes(SchoolAppFramework.loginSceneID);
    }

    @Override
    public void updatePword(ActionEvent event) throws IOException {
        myController.popUpStage(fxmlFileChangePW);
    }

    @Override
    public void setScreenParent(ScenesController screenController) {
        myController=screenController;
    }

}




