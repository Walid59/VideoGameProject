package sample;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.io.IOException;

public class MainCharacter extends Application {
    final static Image DROITE = new Image(MainCharacter.class.getResource("/../res/character/droite.png").toString());
    final static Image DROITE2 = new Image(MainCharacter.class.getResource("/../res/character/droite2.png").toString());
    final static Image GAUCHE = new Image(MainCharacter.class.getResource("/../res/character/gauche.png").toString());
    final static Image GAUCHE2 = new Image(MainCharacter.class.getResource("/../res/character/gauche2.png").toString());
    final static Image NORMAL = new Image(MainCharacter.class.getResource("/../res/character/normal.png").toString());
    final static Image SAUT1 = new Image(MainCharacter.class.getResource("/../res/character/saut1.png").toString());
    final static Image SAUT2 = new Image(MainCharacter.class.getResource("/../res/character/saut2.png").toString());
    final static Image SAUT_DROIT1 = new Image(MainCharacter.class.getResource("/../res/character/sautdroit1.png").toString());
    final static Image SAUT_DROIT2 = new Image(MainCharacter.class.getResource("/../res/character/sautdroit2.png").toString());
    final static Image SAUT_GAUCHE1 = new Image(MainCharacter.class.getResource("/../res/character/sautgauche1.png").toString());
    final static Image SAUT_GAUCHE2 = new Image(MainCharacter.class.getResource("/../res/character/sautgauche2.png").toString());


    private Group characterLeft, characterRight, characterJumping, charUpRight, charUpLeft;
    @Override
    public void start(Stage stage) throws IOException {
        stage.setScene(new Scene(characterRight,600,400));
        stage.show();

        final ImageView charLeft1 = new ImageView(GAUCHE);
        final ImageView charLeft2 = new ImageView(GAUCHE2);

        /*
        final ImageView charJumpLeft1 = new ImageView(SAUT_GAUCHE1);
        final ImageView charJumpLeft2 = new ImageView(SAUT_GAUCHE2);

        final ImageView charJumping1 = new ImageView(SAUT1);
        final ImageView charJumping2 = new ImageView(SAUT2);

        final ImageView charRight1 = new ImageView(DROITE);
        final ImageView charRight2 = new ImageView(DROITE2);

        final ImageView charJumpRight1 = new ImageView(SAUT_DROIT1);
        final ImageView charJumpRight2 = new ImageView(SAUT_DROIT2);
*/
        characterLeft = new Group(charLeft1);
       /* characterRight = new Group(charRight1);
        characterJumping =new Group(charJumping1);
        charUpRight =new Group(charJumpRight1);
        charUpLeft =new Group(charJumpLeft1);
*/
       characterLeft.setTranslateX(150);
       characterLeft.setTranslateY(500);
        Timeline runLeft = new Timeline();
        runLeft.setCycleCount(Timeline.INDEFINITE);
/*
        Timeline jumpUpLeft = new Timeline();
        jumpUpLeft.setCycleCount(Timeline.INDEFINITE);

        Timeline jump = new Timeline();
        jump.setCycleCount(Timeline.INDEFINITE);

        Timeline jumpUpRight = new Timeline();
        jumpUpRight.setCycleCount(Timeline.INDEFINITE);

        Timeline runRight = new Timeline();
        runRight.setCycleCount(Timeline.INDEFINITE);
*/

        runLeft.getKeyFrames().add(
                new KeyFrame(Duration.millis(200), (event) -> {
                    characterLeft.getChildren().setAll(charLeft2);
                }
        ));
/*
        jumpUpLeft.getKeyFrames().add(new KeyFrame(
                Duration.millis(200),( event) -> {charUpLeft.getChildren().setAll(charJumpLeft2);}
        ));

        jump.getKeyFrames().add(new KeyFrame(
                Duration.millis(200),( event) -> {characterJumping.getChildren().setAll(charJumping2);}
        ));

        jumpUpRight.getKeyFrames().add(new KeyFrame(
                Duration.millis(200),( event) -> {charUpRight.getChildren().setAll(charJumpRight2);}
        ));

        runRight.getKeyFrames().add(new KeyFrame(
                Duration.millis(200),( event) -> {characterRight.getChildren().setAll(charRight2);}
        ));

        runRight.play();

 */
    }
}
