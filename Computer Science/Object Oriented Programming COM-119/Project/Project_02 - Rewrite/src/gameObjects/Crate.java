package gameObjects;

import javax.swing.*;
import java.awt.*;

public class Crate extends MoveableSokobanObject{

    private boolean inStorage;
    private static Image storageImage;

    Crate(int x, int y, boolean inStorage) {
        super(x, y, ObjectType.CRATE);
        this.inStorage = inStorage;
        loadImage("src/images/BoxBlue.png");
        loadStorageImage("src/images/BoxRed.png");
    }

    public boolean isInStorage() {
        return inStorage;
    }

    public Image getStorageImage() {
        return storageImage;
    }

    public void setInStorage(boolean inStorage) {
        this.inStorage = inStorage;
        if(!inStorage) {
            loadImage("src/images/BoxBlue.png");
        } else {
            loadImage("src/images/BoxRed.png");
        }
    }

    private void loadStorageImage(String path) {
        ImageIcon ii = new ImageIcon(path);
        storageImage = ii.getImage();
    }
}
