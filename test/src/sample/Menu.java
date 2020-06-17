package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;


public class Menu extends Main{
     private static Button start = new MainMenuButton("JOUER");
     private static Button settings = new MainMenuButton("PARAMETRES");
     private static Button credits = new MainMenuButton("CREDITS");

     static Button[] buttons = {start, settings, credits};
    private static MediaPlayer mediaPlayer;


    public static void startMenu(){
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
        //-----------------------CREDITS BUTTON----------------------
        credits.setLayoutX((Main.getSceneWidth() / 2) - (MainMenuButton.getButtonWidth() / 2));
        credits.setLayoutY(400);

        //-------------------------test-------------------------

        //pour afficher dans le root les boutons
        root.getChildren().addAll(start, settings, credits);
        menuMusic();

        //Titre du jeu
        setGameTitle();
    }

    public static void gameStarted(){
        root.getChildren().removeAll(start, settings, credits);
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
    //-----------------------TITRE--------------------------
    public static void setGameTitle(){
        GameTitle t = new GameTitle((Main.getSceneWidth() / 2) - (MainMenuButton.getButtonWidth() / 2),200,"test");
        root.getChildren().add(t);
    }

}
