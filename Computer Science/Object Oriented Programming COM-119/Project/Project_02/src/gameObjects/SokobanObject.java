package gameObjects;

import javax.swing.*;
import java.awt.Image;

public class SokobanObject implements ObjectType, Sprite {

    public enum ObjectType {
        WALL,
        CRATE,
        PLAYER,
        FLOOR,
        EMPTY
    }

    private ObjectType type;
    private Image image;

    SokobanObject(ObjectType type) {
        this.type = type;
    }

    @Override
    public void loadImage(String path){
        ImageIcon ii = new ImageIcon(path);
        image = ii.getImage();
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public ObjectType getType() {
        return type;
    }
}

