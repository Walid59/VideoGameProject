package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.FileNotFoundException;


public class Main extends Application {
    //attributs
    public static Pane root = new Pane();
    private static Scene scene;

    //pour la taille de la scene
    private final static int SCENE_WIDTH = 900;
    private final static int SCENE_HEIGHT = 720;

    //getters
    public static int getSceneWidth() {
        return SCENE_WIDTH;
    }

    public static int getSceneHeight() {
        return SCENE_HEIGHT;
    }

    public static Scene getScene(){
        return scene;
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("Boumaragame");
        
        root.setId("pane");

        //fin méthode
           
        //création de la page (la "scene") de taille final
     scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
           scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene); //on ajoute la scene
        primaryStage.show();
        Menu.startMenu();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
