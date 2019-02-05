package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

public class ScenesController extends StackPane{
    //Holds the screens to be displayed

    private HashMap<String, Node> scenes = new HashMap<>();

    public ScenesController(){
        super();
    }

    //Add the screen to the collection
    public void addScene(String name, Node scene){
        scenes.put(name,scene);
    }


    //Returns the node with the appropriate name
    public Node getScenes(String name){
        return scenes.get(name);
    }

    //load the fxml file, add the scene to the scenes collection and finally injects the scenePane to the controller.
    public boolean loadScene(String name, String resource){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScene =(Parent) loader.load();
            ControlledScenes controlledScene= ((ControlledScenes)loader.getController());
            controlledScene.setScreenParent(this);
            addScene(name,loadScene);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean setScenes(final String name){
        if (scenes.get(name) != null){
            final DoubleProperty opacity = opacityProperty();

            if (!getChildren().isEmpty()){
                Timeline fade= new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(500), event -> {
                            getChildren().remove(0);
                            getChildren().add(0, scenes.get(name));
                            Timeline fadeIn=new Timeline(
                                    new KeyFrame(Duration.ZERO, new KeyValue(opacity,0.0)),
                                    new KeyFrame(new Duration(500), new KeyValue(opacity, 1.0)));
                            fadeIn.play();
                        },new KeyValue(opacity, 0.0)));
                fade.play();
            }else {
                setOpacity(0.0);
                getChildren().add(scenes.get(name));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity,0.0)),
                        new KeyFrame(new Duration(500), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        }else {
            System.out.println("Scene hasn't been loaded!!! \n");
            return false;
        }
    }

    public boolean unloadScene(String name){
        if (scenes.remove(name) == null){
            System.out.println("Scene didn't exist");
            return false;
        }else {
            return true;
        }
    }

    public void popUpStage(String fileName)throws IOException{

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fileName));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        stage.centerOnScreen();

        stage.setOnCloseRequest(event12 -> {
        });
        stage.setOnHiding(event1 -> {

        });
        }
}
