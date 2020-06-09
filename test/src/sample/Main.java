package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;



public class Main extends Application {
    //attributs
    public static Pane root = new Pane();

    //pour la taille de la scene
    private final static int SCENE_WIDTH = 1000;
    private final static int SCENE_HEIGHT = 600;

    //getters
    public static int getSceneWidth() {
        return SCENE_WIDTH;
    }

    public static int getSceneHeight() {
        return SCENE_HEIGHT;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Boumaragame");
        root.setStyle("-fx-background-color: black;");

        //création de la page (la "scene") de taille final
    Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        primaryStage.setResizable(false); //impossible de changer la taille de l'appli
        primaryStage.setScene(scene); //on ajoute la scene
    //primaryStage.setAlwaysOnTop(true); //qui sert à afficher en foreground du pc l'appli, inutile pour l'instant (peut-être jamais)
        primaryStage.show();
        Menu.startMenu();
    }
}