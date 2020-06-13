package sample;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GameButton extends Pane {
    Image BLACK = new Image(getClass().getResourceAsStream("/res/Game/bouton_eteint1.png"));
    Image WHITE = new Image(getClass().getResourceAsStream("/res/Game/bouton_allume1.png"));

    ImageView button;
    boolean eteint = true;

    public enum ButtonType {
        BLACK, WHITE
    }

    public GameButton(ButtonType buttontype, int x, int y) {
        setTranslateX(x);
        setTranslateY(y);
        button.setViewport(new Rectangle2D(0, 0, 16, 14));
        switch(buttontype){
            case BLACK:
                button = new ImageView(BLACK);
            case WHITE:
                button = new ImageView(WHITE);
        }
        getChildren().add(button);
        Game.gameRoot.getChildren().add(this);
    }
}