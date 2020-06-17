package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.util.Duration;
import javafx.event.ActionEvent;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

//import static sample.mario.Button.ButtonType.ETEINT;


public class Game extends Main {
    public static ArrayList<Block> platforms = new ArrayList<>();
    private HashMap<KeyCode,Boolean> keys = new HashMap<>();


    Image backgroundImg = new Image(getClass().getResourceAsStream("/res/Game/fond4.jpg"));
    public static final int BLOCK_SIZE = 45;
    public static final int MARIO_SIZE = 45;
    public static final int BOUTON1_SIZE = 40;


    public static Pane appRoot = new Pane();
    public static Pane gameRoot = new Pane();
    
    public Character player;
    int levelNumber = 0;
    private int levelWidth;
    private int levelHeight = 3000;


    //pour la musique
    private static MediaPlayer mediaPlayer;

    //pour les textes


    private void initContent() {
        ImageView backgroundIV = new ImageView(backgroundImg);
        backgroundIV.setFitHeight(74 * BLOCK_SIZE);
        backgroundIV.setFitWidth(76 * BLOCK_SIZE);

        levelWidth = LevelData.levels[levelNumber][0].length() * BLOCK_SIZE;
        for (int i = 0; i < LevelData.levels[levelNumber].length; i++) {
            String line = LevelData.levels[levelNumber][i];
            for (int j = 0; j < line.length(); j++) {
                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '2':
                        Block solGauche = new Block(Block.BlockType.SOL_GAUCHE, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '1':
                        Block sol = new Block(Block.BlockType.SOL, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '3':
                        Block solDroit = new Block(Block.BlockType.SOL_DROIT, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '4':
                        Block solCoteGauche = new Block(Block.BlockType.SOL_COTE_GAUCHE, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '5':
                        Block solCoteDroit = new Block(Block.BlockType.SOL_COTE_DROIT, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '6':
                        Block plafond = new Block(Block.BlockType.PLAFOND, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '7':
                        Block plafondGauche = new Block(Block.BlockType.PLAFOND_GAUCHE, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '8':
                        Block plafondDroit = new Block(Block.BlockType.PlAFOND_DROIT, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '9':
                        Block platformM= new Block(Block.BlockType.PLATFORM_MILIEU, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case 'a':
                        Block etoile3 = new Block(Block.BlockType.ETOILE1ROUGE, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case 'b':
                        Block etoile1= new Block(Block.BlockType.ETOILE2, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case 'c':
                        Block etoile2= new Block(Block.BlockType.ETOILE3BLEU, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case 'd':
                        Block etoile4= new Block(Block.BlockType.ETOILE4VERT, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                }
            }

        }

            player = new Character();
            //bouton = new Button(ETEINT, 64, 2000);
            player.setTranslateX(150); //pour gérer où va atterir le perso axe des abscisses
            player.setTranslateY(2000);//pour gérer où va atterir le perso axe des ordonnées (à partir de 799 -> problème)
            //IMPORTANT : code pour le background scrolling
            player.translateYProperty().addListener((obs, old, newValue) -> {
                int offset = newValue.intValue();
                if (offset > 540 && offset < levelHeight) { //pas touche non plus
                    gameRoot.setLayoutY(-(offset -  540)); //plus la salle est grande et plus le nombre devient petit
                    backgroundIV.setLayoutY(-(offset - 540)); //plus la salle est grande et plus le nombre devient petit
                }
            });
            //Fin du code pour background scrolling
            player.translateXProperty().addListener((obs, old, newValue) -> {
                int offset = newValue.intValue();
                if (offset > 340 && offset < levelWidth - 560) { //pas touche non plus
                    gameRoot.setLayoutX(-(offset - 340)); //plus la salle est grande et plus le nombre devient petit
                    backgroundIV.setLayoutX(-(offset - 340)); //plus la salle est grande et plus le nombre devient petit
                }
            });
            gameRoot.getChildren().add(player);
            Main.root.getChildren().addAll(backgroundIV, gameRoot);
/*
            GameButton b = new GameButton(GameButton.ButtonType.WHITE,300,300);
            GameButton c = new GameButton(GameButton.ButtonType.BLACK,350,300);
            Main.root.getChildren().addAll(b,c);

 */

    }

    private void update(){
        // joueur
        if(isPressed(KeyCode.UP) && player.getTranslateY()>=5){
            player.jumpPlayer();
        }
        if(isPressed(KeyCode.LEFT) && player.getTranslateX()>=5){
            player.setScaleX(-1);
            player.animation.play();
            player.moveX(-5);
        }
        if(isPressed(KeyCode.RIGHT) && player.getTranslateX()+40 <=levelWidth-5){
            player.setScaleX(1);
            player.animation.play();
            player.moveX(5);
        }
        if(player.playerVelocity.getY()<10){                          //ãðàâèòàöèÿ
            player.playerVelocity = player.playerVelocity.add(0,1);
        }
        player.moveY((int)player.playerVelocity.getY());



    }

    public void setText(int x,int y,String a){
        Text t = new Text(x , y , a);
        t.setFont(new Font(20));
        t.setFill(Color.WHITE);
        t.setEffect(new DropShadow());
        gameRoot.getChildren().add(t);
        t.setVisible(true);
    }

    public void startGame() {
        initContent();
        gameMusic();
        setText(400,2000,"ok boomer");
        getScene().setOnKeyPressed(event -> keys.put(event.getCode(), true));
        getScene().setOnKeyReleased(event -> {
            keys.put(event.getCode(), false);
            player.animation.stop();
        });
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
    }

    private boolean isPressed(KeyCode key){
        return keys.getOrDefault(key,false);
    }

    public static void gameMusic(){
        String s = "src/res/Music/game.mp3";
        Media h = new Media(Paths.get(s).toUri().toString()); //compliqué à expliquer ça
        mediaPlayer = new MediaPlayer(h);
        try{
            mediaPlayer.setVolume(0.05);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        } catch (MediaException e) {
            e.printStackTrace();
            System.out.println("pas trouvé");
        }
    }
}
