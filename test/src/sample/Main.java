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
    //pour la taille de la scene
    private final static int SCENE_WIDTH = 1000;

    public static int getSceneWidth() {
        return SCENE_WIDTH;
    }

    public static int getSceneHeight() {
        return SCENE_HEIGHT;
    }

    private final static int SCENE_HEIGHT = 600;


    //pour le handler event
    Text t = new Text(550, 100, "");

    //pour les boutons en gras
    TextFlow flow = new TextFlow();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Boumaragame");

        Button test = new Button("test"); test.setLayoutX(200); test.setLayoutY(200); test.setVisible(false); test.setDisable(true);
        Button start = new MainMenuButton("JOUER");
        Button settings = new MainMenuButton("PARAMETRES");
        Button credits = new MainMenuButton("CREDITS");
        Button[] buttons = {start, settings, credits};



        Pane root = new Pane();
        //root.setStyle("-fx-background-color: black;");

        // ------------------------START BUTTON----------------------

        //endroit où sera situé le bouton
        start.setLayoutX((getSceneWidth() / 2) - (MainMenuButton.getButtonWidth() / 2));
        start.setLayoutY(200);

        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t.setText("This is a test");
                t.setFont(Font.font("Arial" ,FontWeight.BOLD, 40));
                t.setStyle("-fx-font-weight: bold");
                t.setVisible(true);

                test.setVisible(true);
                test.setDisable(false);
                for (Button b : buttons) {
                    b.setDisable(true);
                    b.setVisible(false);
                }
            }
        });


        test.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                test.setVisible(false);
                test.setDisable(true);
                t.setVisible(false);

                for (Button b : buttons) {
                    b.setDisable(false);
                    b.setVisible(true);
                }
            }
        });
        //----------------------SETTINGS BUTTON----------------------
        settings.setLayoutX((getSceneWidth() / 2) - (MainMenuButton.getButtonWidth() / 2));
        settings.setLayoutY(300);
        //-----------------------CREDITS BUTTON----------------------
        credits.setLayoutX((getSceneWidth() / 2) - (MainMenuButton.getButtonWidth() / 2));
        credits.setLayoutY(400);

        //pour afficher dans le root les boutons
        root.getChildren().addAll(start, settings, credits, t, test);


        //création de la page (la "scene") de taille final
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);


        primaryStage.setResizable(false); //impossible de changer la taille de l'appli
        primaryStage.setScene(scene); //on ajoute la scene
        //primaryStage.setAlwaysOnTop(true); //qui sert à afficher en foreground du pc l'appli, inutile pour l'instant (peut-être jamais)
        primaryStage.show();
    }
}