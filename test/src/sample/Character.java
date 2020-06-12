package sample.mario;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class Character extends Pane{
    Image marioImg = new Image(getClass().getResourceAsStream("mario.png"));
    ImageView imageView = new ImageView(marioImg); //pour accéder à l'image avec les perso
    int count = 3; //+ count est élevé, + l'amplitude des gestes est grande
    int columns = 3; ///doit être ai dessis de 3
    int offsetX = 80; //abscisse sur le perso qu'on prend
    int offsetY = 22; //ordonnée sur le perso qu'on prend
    int width = 19; //largeur qu'on prend sur la photo mario.png
    int height = 28; //taille qu'on prend sur la photo mario.png
    public SpriteAnimation animation;
    public Point2D playerVelocity = new Point2D(0,0);
    private boolean canJump = true;

    public Character(){
        imageView.setFitHeight(45);
        imageView.setFitWidth(45);
        imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(this.imageView,Duration.millis(300),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(this.imageView);
    }

    public void moveX(int value){
        boolean movingRight = value > 0;
        for(int i = 0; i<Math.abs(value); i++) {
            for (Node platform : Game.platforms) {
                if(this.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingRight) {
                        if (this.getTranslateX() + Game.MARIO_SIZE == platform.getTranslateX()){
                            this.setTranslateX(this.getTranslateX() - 1);
                            return;
                        }
                    } else {
                        if (this.getTranslateX() == platform.getTranslateX() + Game.BLOCK_SIZE) {
                            this.setTranslateX(this.getTranslateX() + 1);
                            return;
                        }
                    }
                }
            }
            this.setTranslateX(this.getTranslateX() + (movingRight ? 1 : -1));
        }
    }
    public void moveY(int value){
        boolean movingDown = value >0;
        for(int i = 0; i < Math.abs(value); i++){
            for(Block platform :Game.platforms){
                if(getBoundsInParent().intersects(platform.getBoundsInParent())){
                    if(movingDown){
                        if(this.getTranslateY()+ Game.MARIO_SIZE == platform.getTranslateY()){
                            this.setTranslateY(this.getTranslateY()-1);
                            canJump = true;
                            return;
                        }
                    }
                    else{
                        if(this.getTranslateY() == platform.getTranslateY()+ Game.BLOCK_SIZE){
                            this.setTranslateY(this.getTranslateY()+1);
                            playerVelocity = new Point2D(0,10);
                            return;
                        }
                    }
                }
            }
            this.setTranslateY(this.getTranslateY() + (movingDown?1:-1));
            if(this.getTranslateY()>7000){ //pas touche à cette ligne
                this.setTranslateX(64);
                this.setTranslateY(800);
                Game.gameRoot.setLayoutX(0);
            }
        }
    }
    public void jumpPlayer(){
        if(canJump){
            playerVelocity = playerVelocity.add(40,-30);
            canJump = false;
        }
    }
}