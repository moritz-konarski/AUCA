package gameObjects;

import javax.swing.*;
import java.awt.*;

public class Floor extends SokobanObject implements StorageLocation {

    private boolean isStorageLocation;
    private static Image storageLocationImage;

    Floor(boolean isStorageLocation) {
        super(ObjectType.FLOOR);
        this.isStorageLocation = isStorageLocation;
        loadImage("src/images/Floor.png");
        loadStorageImage("src/images/StorageArea.png");
    }

    @Override
    public boolean isStorageLocation() {
        return isStorageLocation;
    }

    private void loadStorageImage(String path) {
        ImageIcon ii = new ImageIcon(path);
        storageLocationImage = ii.getImage();
    }

    public Image getStorageLocationImage() {
        return storageLocationImage;
    }
}
