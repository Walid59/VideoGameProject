package sample;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class Character extends Pane{
    Image marioImg = new Image(getClass().getResourceAsStream("/res/Game/mario.png"));
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
            // A CHANGER
            this.setTranslateY(this.getTranslateY() + (movingDown?1:-1));
            if(this.getTranslateY()>2790){ 
                this.setTranslateX(1475);
                this.setTranslateY(2789);
                Game.gameRoot.setLayoutX(1470);
                Game.gameRoot.setLayoutY(2789);
            }

            // 2eme étage
            //salle de base
            if(this.getTranslateX()>=2990 && this.getTranslateX()<=3045 && this.getTranslateY()<=1755 && this.getTranslateY()>=1599){ //pas touche à cette ligne
                this.setTranslateX(3306);
                this.setTranslateY(1754);
                Game.gameRoot.setLayoutX(64);
            }


            //Premiere salle
            //TP GAUCHE
            if(this.getTranslateX()>=3171 && this.getTranslateX()<=3221 && this.getTranslateY()<=1755 && this.getTranslateY()>=1680){ //pas touche à cette ligne
                this.setTranslateX(2815);
                this.setTranslateY(1754);
                Game.gameRoot.setLayoutX(64);
            }
            //TP HAUT
            if(this.getTranslateX()>3354 && this.getTranslateX()<3521 && this.getTranslateY()==1350){ //pas touche à cette ligne
                this.setTranslateX(2870);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }
            //TP BAS
            if(this.getTranslateX()>=3371 && this.getTranslateX()<=3521 && this.getTranslateY()==1800){ //pas touche à cette ligne
                this.setTranslateX(3965);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }
            //TP DROITE
            if(this.getTranslateX()>3671 && this.getTranslateX()<3706 && this.getTranslateY()<=1755 && this.getTranslateY()>=1600){ //pas touche à cette ligne
                this.setTranslateX(2870);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }


            //Deuxieme salle
            if(this.getTranslateX()>3845 && this.getTranslateX()<3890 && this.getTranslateY()<=1755 && this.getTranslateY()>=1600){ //pas touche à cette ligne
                this.setTranslateX(2870);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }
            if(this.getTranslateX()>4026 && this.getTranslateX()<4201 && this.getTranslateY()==1350){ //pas touche à cette ligne
                this.setTranslateX(2870);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }

            if(this.getTranslateX()>=4065 && this.getTranslateX()<=4220 && this.getTranslateY()==1800){ //pas touche à cette ligne
                this.setTranslateX(4645);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }
            if(this.getTranslateX()>4339 && this.getTranslateX()<4394 && this.getTranslateY()<=1755 && this.getTranslateY()>=1600){ //pas touche à cette ligne
                this.setTranslateX(2870);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }


            //Troisieme salle
            if(this.getTranslateX()>4519 && this.getTranslateX()<4574 && this.getTranslateY()<=1755 && this.getTranslateY()>=1600){ //pas touche à cette ligne
                this.setTranslateX(2815);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }
            if(this.getTranslateX()>4699 && this.getTranslateX()<4889 && this.getTranslateY()==1350){ //pas touche à cette ligne
                this.setTranslateX(275);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }

            if(this.getTranslateX()>=4734 && this.getTranslateX()<=4884 && this.getTranslateY()==1800){ //pas touche à cette ligne
                this.setTranslateX(2870);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }
            if(this.getTranslateX()>5024 && this.getTranslateX()<5074 && this.getTranslateY()<=1755 && this.getTranslateY()>=1600){ //pas touche à cette ligne
                this.setTranslateX(2870);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }


            //Quatrieme salle
            if(this.getTranslateX()>151 && this.getTranslateX()<206 && this.getTranslateY()<=1755 && this.getTranslateY()>=1600){ //pas touche à cette ligne
                this.setTranslateX(2815);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }
            if(this.getTranslateX()>331 && this.getTranslateX()<526 && this.getTranslateY()==1350){ //pas touche à cette ligne
                this.setTranslateX(2815);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }

            if(this.getTranslateX()>=366 && this.getTranslateX()<=514 && this.getTranslateY()==1800){ //pas touche à cette ligne
                this.setTranslateX(2815);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }
            if(this.getTranslateX()>649 && this.getTranslateX()<694 && this.getTranslateY()<=1755 && this.getTranslateY()>=1600){ //pas touche à cette ligne
                this.setTranslateX(956);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }


            // Cinquieme salle
            if(this.getTranslateX()>826 && this.getTranslateX()<871 && this.getTranslateY()<=1755 && this.getTranslateY()>=1600){ //pas touche à cette ligne
                this.setTranslateX(2815);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }
            if(this.getTranslateX()>1004 && this.getTranslateX()<1194 && this.getTranslateY()==1350){ //pas touche à cette ligne
                this.setTranslateX(2815);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }

            if(this.getTranslateX()>=1044 && this.getTranslateX()<=1194 && this.getTranslateY()==1800){ //pas touche à cette ligne
                this.setTranslateX(1620);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }
            if(this.getTranslateX()>1334 && this.getTranslateX()<1384 && this.getTranslateY()<=1755 && this.getTranslateY()>=1600){ //pas touche à cette ligne
                this.setTranslateX(2815);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }


            //Sixieme salle
            if(this.getTranslateX()>1504 && this.getTranslateX()<1564 && this.getTranslateY()<=1755 && this.getTranslateY()>=1600){ //pas touche à cette ligne
                this.setTranslateX(2815);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }
            if(this.getTranslateX()>1671 && this.getTranslateX()<1876 && this.getTranslateY()==1350){ //pas touche à cette ligne
                this.setTranslateX(1390);
                this.setTranslateY(620);
                Game.gameRoot.setLayoutX(64);
            }

            if(this.getTranslateX()>=1716 && this.getTranslateX()<=1876 && this.getTranslateY()==1800){ //pas touche à cette ligne
                this.setTranslateX(2815);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }
            if(this.getTranslateX()>2000 && this.getTranslateX()<2051 && this.getTranslateY()<=1755 && this.getTranslateY()>=1600){ //pas touche à cette ligne
                this.setTranslateX(2815);
                this.setTranslateY(1755);
                Game.gameRoot.setLayoutX(64);
            }




            // 3eme étage
            //salle de base
            if(this.getTranslateX()>1506 && this.getTranslateX()<1556 && this.getTranslateY()<=765 && this.getTranslateY()>=680){ //pas touche à cette ligne
                this.setTranslateX(2006);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }

            //Premiere salle
            //retour
            if(this.getTranslateX()>1901 && this.getTranslateX()<1651 && this.getTranslateY()<=765 && this.getTranslateY()>=680){ //pas touche à cette ligne
                this.setTranslateX(1390);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }
            //TP BAS DROITE
            if(this.getTranslateX()>=2266 && this.getTranslateX()<=2366 && this.getTranslateY()==772){ //pas touche à cette ligne
                this.setTranslateX(2884);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }
            //TP HAUT GAUCHE
            if(this.getTranslateX()>1911 && this.getTranslateX()<1961 && this.getTranslateY()<=585 && this.getTranslateY()>=540){ //pas touche à cette ligne
                this.setTranslateX(1390);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }

            //TP HAUT DROITE
            if(this.getTranslateX()>2364 && this.getTranslateX()<2406 && this.getTranslateY()<=630 && this.getTranslateY()>=560){ //pas touche à cette ligne
                this.setTranslateX(1390);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }


            //Deuxieme salle
            //retour
            if(this.getTranslateX()>2764 && this.getTranslateX()<2814 && this.getTranslateY()<=765 && this.getTranslateY()>=680){ //pas touche à cette ligne
                this.setTranslateX(1390);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }
            //TP BAS DROITE
            if(this.getTranslateX()>=3114 && this.getTranslateX()<=3214 && this.getTranslateY()==772){ //pas touche à cette ligne
                this.setTranslateX(1390);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }
            //TP HAUT GAUCHE
            if(this.getTranslateX()>2764 && this.getTranslateX()<2814 && this.getTranslateY()<=585 && this.getTranslateY()>=540){ //pas touche à cette ligne
                this.setTranslateX(1390);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }

            //TP HAUT DROITE
            if(this.getTranslateX()>3214 && this.getTranslateX()<3259 && this.getTranslateY()<=630 && this.getTranslateY()>=560){ //pas touche à cette ligne
                this.setTranslateX(3634);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }


            //Troisieme salle
            //retour
            if(this.getTranslateX()>3529 && this.getTranslateX()<3579 && this.getTranslateY()<=765 && this.getTranslateY()>=680){ //pas touche à cette ligne
                this.setTranslateX(1390);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }
            //TP BAS DROITE
            if(this.getTranslateX()>=3874 && this.getTranslateX()<=3979 && this.getTranslateY()==772){ //pas touche à cette ligne
                this.setTranslateX(1390);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }
            //TP HAUT GAUCHE
            if(this.getTranslateX()>3529 && this.getTranslateX()<3579 && this.getTranslateY()<=585 && this.getTranslateY()>=540){ //pas touche à cette ligne
                this.setTranslateX(4885);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }

            //TP HAUT DROITE
            if(this.getTranslateX()>3979 && this.getTranslateX()<4029 && this.getTranslateY()<=630 && this.getTranslateY()>=560){ //pas touche à cette ligne
                this.setTranslateX(1390);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }

            //Quatrieme salle
            //retour
            if(this.getTranslateX()>4735 && this.getTranslateX()<4805 && this.getTranslateY()<=765 && this.getTranslateY()>=680){ //pas touche à cette ligne
                this.setTranslateX(1390);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }
            //TP BAS DROITE
            if(this.getTranslateX()>=5090 && this.getTranslateX()<=5195 && this.getTranslateY()==772){ //pas touche à cette ligne
                this.setTranslateX(1390);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }
            //TP HAUT GAUCHE
            if(this.getTranslateX()>4735 && this.getTranslateX()<4805 && this.getTranslateY()<=585 && this.getTranslateY()>=540){ //pas touche à cette ligne
                this.setTranslateX(2500);
                this.setTranslateY(100);
                Game.gameRoot.setLayoutX(64);
            }

            //TP HAUT DROITE
            if(this.getTranslateX()>5195 && this.getTranslateX()<5240 && this.getTranslateY()<=630 && this.getTranslateY()>=560){ //pas touche à cette ligne
                this.setTranslateX(1390);
                this.setTranslateY(764);
                Game.gameRoot.setLayoutX(64);
            }
           /* if ((this.getTranslateY()==1299) && (this.getTranslateX()>590)) {
                this.setTranslateX(380);
                this.setTranslateY(2050);
                Game.gameRoot.setLayoutX(64);
            }*/

        }
    }
    public void jumpPlayer(){
        if(canJump){
            playerVelocity = playerVelocity.add(40,-30);
            canJump = false;
        }
    }
}
