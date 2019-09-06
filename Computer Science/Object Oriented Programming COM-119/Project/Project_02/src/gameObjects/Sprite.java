package gameObjects;

import java.awt.Image;

public interface Sprite {
    void loadImage(String path);
    Image getImage();
}
