package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.transform.Translate;
import javafx.scene.Node;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextFlow;





public class Main extends Application {
    //pour la taille de la scene
    private final static int WIDTH = 1280;
    private final static int HEIGHT = 720;

    //pour le handler event
    Text t = new Text(550, 100, "");

    //pour les boutons en gras
    TextFlow flow = new TextFlow();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");

        Button start = new Button("START GAME");
        Button settings = new Button("SETTINGS");
        Button credits = new Button("CREDITS");
        Button[] buttons = {start, settings, credits};

        for(Button b : buttons){
        b.setFont(Font.font("Arial", FontWeight.BOLD, 18));
    }


        Pane root = new Pane();
        // ------------------------START BUTTON----------------------



        //endroit où sera situé le bouton
        start.setLayoutX(200);
        start.setLayoutY(200);

        start.setPrefSize(150, 75);         //taille du bouton
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t.setText("This is a test");
                t.setFont(Font.font("Arial" ,FontWeight.BOLD, 40));
                t.setStyle("-fx-font-weight: bold");

                for (Button b : buttons) {
                    b.setDisable(true);
                    b.setVisible(false);
                }
            }
        });

        //----------------------SETTINGS BUTTON----------------------
        settings.setLayoutX(200);
        settings.setLayoutY(300);
        settings.setPrefSize(150, 75);

        //-----------------------CREDITS BUTTON----------------------
        credits.setLayoutX(200);
        credits.setLayoutY(400);
        credits.setPrefSize(150, 75);

        //pour afficher dans le root les boutons
        root.getChildren().addAll(start, settings, credits, t);


        //création de la page (la "scene") de taille final
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setResizable(false); //impossible de changer la taille de l'appli
        primaryStage.setScene(scene); //on ajoute la scene
        //primaryStage.setAlwaysOnTop(true); //qui sert à afficher en foreground du pc l'appli, inutile pour l'instant (peut-être jamais)
        primaryStage.show();
    }

}