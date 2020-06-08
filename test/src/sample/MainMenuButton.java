package sample;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Vector;

public class MainMenuButton extends Button {



//    private static Vector buttons = new Vector();
    private final static int BUTTON_WIDTH = 267;
    private final static int BUTTON_HEIGHT = 87;

    public static int getButtonWidth() {
        return BUTTON_WIDTH;
    }

    public static int getButtonHeight() {
        return BUTTON_HEIGHT;
    }
/*
    public static Vector getButtons() {
        return buttons;
    }


 */
    private final String FONT_PATH = "src/res/MenuButton/yoster.ttf";
    private final String BUTTON_PATH = "-fx-background-image: url('/res/MenuButton/testbutton2.png');";
    private final String BUTTON_PRESSED_PATH = "-fx-background-image: url('/res/MenuButton/testbutton.png');";


    public MainMenuButton(String text){
        setText(text);
        setButtonFont();
        setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);         //taille du bouton
        setStyle(BUTTON_PATH);
        initButtonListener();
        //buttons.addElement(this);
    }

    public void setButtonFont(){
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH),23));
        }
        catch (FileNotFoundException e){
            setFont(Font.font("Arial" , FontWeight.BOLD, 40));

        }
    }

    public void setButtonPressed(){
        setStyle(BUTTON_PRESSED_PATH);
    }

    public void setButton(){
        setStyle(BUTTON_PATH);
    }

    public void initButtonListener(){
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    setButtonPressed();
                }
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(!mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    setButton();
                }
            }
        });

        setOnMouseEntered(event -> setEffect(new DropShadow()));

        setOnMouseExited(event -> setEffect(null));

    }

/*
    public Button getStart() {
        return start;
    }

    public Button getSettings() {
        return settings;
    }

    public Button getCredits() {
        return credits;
    }

    Button start = new MainMenuButton("JOUER");
    Button settings = new MainMenuButton("PARAMETRES");
    Button credits = new MainMenuButton("CREDITS");

 */
}
