package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Menu extends Main{
     private static Button start = new MainMenuButton("JOUER");
     private static Button settings = new MainMenuButton("PARAMETRES");
     private static Button credits = new MainMenuButton("CREDITS");

     static Button[] buttons = {start, settings, credits};

    public static void startMenu(){
        for(Button b : buttons){
            b.setTextFill(Color.WHITE);
        }
        // ------------------------START BUTTON----------------------

        //endroit où sera situé le bouton
        start.setLayoutX((Main.getSceneWidth() / 2) - (MainMenuButton.getButtonWidth() / 2));
        start.setLayoutY(200);

        //-------------------------test----------------------------

        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameStarted();
            }
        });

        //----------------------SETTINGS BUTTON----------------------
        settings.setLayoutX((Main.getSceneWidth() / 2) - (MainMenuButton.getButtonWidth() / 2));
        settings.setLayoutY(300);
        //-----------------------CREDITS BUTTON----------------------
        credits.setLayoutX((Main.getSceneWidth() / 2) - (MainMenuButton.getButtonWidth() / 2));
        credits.setLayoutY(400);

        //pour afficher dans le root les boutons
        root.getChildren().addAll(start, settings, credits);
    }

    public static void gameStarted(){
        root.getChildren().removeAll(start, settings, credits);
        Game g = new Game();
        g.startGame();
    }
}
