package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class Menu extends Main{
     private static Button start = new MainMenuButton("JOUER");
     private static Button settings = new MainMenuButton("PARAMETRES");
     private static Button credits = new MainMenuButton("CREDITS");

     static Button[] buttons = {start, settings, credits};
    private static FileInputStream music;

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
            }
        });

        //----------------------SETTINGS BUTTON----------------------
        settings.setLayoutX((Main.getSceneWidth() / 2) - (MainMenuButton.getButtonWidth() / 2));
        settings.setLayoutY(300);
        //-----------------------CREDITS BUTTON----------------------
        credits.setLayoutX((Main.getSceneWidth() / 2) - (MainMenuButton.getButtonWidth() / 2));
        credits.setLayoutY(400);

        //-------------------------test-------------------------
        Text test = new Text((Main.getSceneWidth() / 2) - (MainMenuButton.getButtonWidth() / 2),100,"Hello World!");
        test.setFont(new Font (20));
        test.setFill(Color.WHITE);

        //pour afficher dans le root les boutons
        root.getChildren().addAll(start, settings, credits,test);

        //un petit test oklm
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("D:/MusicPlayer/pol_wav.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception e){
            System.out.println("musique pas trouvée");
        }
    }

    public static void gameStarted(){
        root.getChildren().removeAll(start, settings, credits);
        Game g = new Game();
        g.startGame();
    }
}
