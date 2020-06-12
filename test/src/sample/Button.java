package sample;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Button extends Pane {
    Image buttonimg = new Image(getClass().getResourceAsStream("1.png"));
    ImageView button;
    boolean eteint = true;

    public enum ButtonType {
        ALLUME, ETEINT
    }

    public Button(ButtonType buttontype, int x, int y) {
        button = new ImageView(buttonimg);
        button.setFitWidth(Game.BOUTON1_SIZE);
        button.setFitHeight(Game.BOUTON1_SIZE);
        setTranslateX(x);
        setTranslateY(y);

    }
}