package sample;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Block extends Pane {
    Image blocksImg = new Image(getClass().getResourceAsStream("/res/Game/essai2.png"));
    ImageView block;
    public enum BlockType {
        SOL_GAUCHE, SOL_DROIT, SOL, SOL_COTE_GAUCHE, SOL_COTE_DROIT, PLAFOND, PLAFOND_GAUCHE, PlAFOND_DROIT, PLATFORM_MILIEU, PLATFORM_GAUCHE, PLATFORM_DROIT
    }
    public Block(BlockType blockType, int x, int y) {

        block = new ImageView(blocksImg);
        block.setFitWidth(Game.BLOCK_SIZE);
        block.setFitHeight(Game.BLOCK_SIZE);
        setTranslateX(x);
        setTranslateY(y);
        switch (blockType) {
            case SOL_GAUCHE:
                block.setViewport(new Rectangle2D(0, 0, 29, 29));
                break;
            case SOL:
                block.setViewport(new Rectangle2D(30, 0, 29, 29));
                break;
            case SOL_DROIT:
                block.setViewport(new Rectangle2D(60, 0, 29, 29));
                break;
            case SOL_COTE_GAUCHE:
                block.setViewport(new Rectangle2D(90, 0, 29, 29));
                break;
            case SOL_COTE_DROIT:
                block.setViewport(new Rectangle2D(180, 0, 29, 29));
                break;
            case PLAFOND:
                block.setViewport(new Rectangle2D(120, 0, 29, 29));
                break;
            case PLAFOND_GAUCHE:
                block.setViewport(new Rectangle2D(240, 0, 29, 29));
                break;
            case PlAFOND_DROIT:
                block.setViewport(new Rectangle2D(210, 0, 29, 29));
                break;
            case PLATFORM_MILIEU:
                block.setViewport(new Rectangle2D(300, 0, 29, 29));
                break;
            case PLATFORM_GAUCHE:
                block.setViewport(new Rectangle2D(270, 0, 28, 28));
                break;
            case PLATFORM_DROIT:
                block.setViewport(new Rectangle2D(330, 0, 28, 28));
                break;
        }

        getChildren().add(block);
        Game.platforms.add(this);
        Game.gameRoot.getChildren().add(this);
    }
}
