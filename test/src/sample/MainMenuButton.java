package sample;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainMenuButton extends Button {

    private final static int BUTTON_WIDTH = 200;
    private final static int BUTTON_HEIGHT = 75;

    public static int getButtonWidth() {
        return BUTTON_WIDTH;
    }

    public static int getButtonHeight() {
        return BUTTON_HEIGHT;
    }

    private final String FONT_PATH = "src/res/MenuButton/yoster.ttf";

    public MainMenuButton(String text){
        setText(text);
        setButtonFont();
        setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);         //taille du bouton
    }

    public void setButtonFont(){
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH),23));
        }
        catch (FileNotFoundException e){
            setFont(Font.font("Arial" , FontWeight.BOLD, 40));

        }
    }

}
