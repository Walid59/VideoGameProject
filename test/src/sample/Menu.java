package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;


public class Menu extends Main{
     private static Button start = new MainMenuButton("JOUER");
     private static Button settings = new MainMenuButton("PARAMETRES");


     static Button[] buttons = {start, settings};
    private static MediaPlayer mediaPlayer;


    public static void startMenu() throws FileNotFoundException {
        for(Button b : buttons){
            b.setTextFill(Color.WHITE);
        }
        // ------------------------START BUTTON----------------------

        //endroit où sera situé le bouton
        start.setLayoutX((Main.getSceneWidth() / 2) - (MainMenuButton.getButtonWidth() / 2));
        start.setLayoutY(200);


        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameStarted();
                mediaPlayer.stop();
            }
        });

        //----------------------SETTINGS BUTTON----------------------
        settings.setLayoutX((Main.getSceneWidth() / 2) - (MainMenuButton.getButtonWidth() / 2));
        settings.setLayoutY(300);


        //titre
        Text title = new Text((Main.getSceneWidth() / 2.25),125,"Un jeu");
        title.setFill(Color.WHITE);
        title.setFont(Font.loadFont(new FileInputStream("src/res/MenuButton/yoster.ttf"),50));
        root.getChildren().add(title);
        title.setEffect(new DropShadow());


        //credits
        Text credits = new Text(300,500,"UN JEU REALISE PAR :");

        Text walid = new Text(40,475,"Walid");
        Text guillaume = new Text(150,475,"Guillaume");
        Text océane = new Text(625,475,"Océane");
        Text henri = new Text(775,475,"Henri");
        Text[] texts = {walid, guillaume, henri, océane, credits};
        for(Text t : texts){
            t.setFill(Color.WHITE);
            t.setFont(Font.loadFont(new FileInputStream("src/res/MenuButton/yoster.ttf"),23));
            root.getChildren().add(t);
        }


        //pour afficher dans le root les boutons
        root.getChildren().addAll(start, settings);
        menuMusic();

    }

    public static void gameStarted(){
        root.getChildren().removeAll(start, settings);
        Game g = new Game();
        g.startGame();
    }

    //------------------------MUSIQUE DU JEU---------------------
    public static void menuMusic(){
        String s = "src/res/Music/menu.mp3";
        Media h = new Media(Paths.get(s).toUri().toString()); //compliqué à expliquer ça
        mediaPlayer = new MediaPlayer(h);
        try{
            mediaPlayer.setVolume(0.1);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        } catch (MediaException e) {
            e.printStackTrace();
            System.out.println("pas trouvé");
        }
    }

}
