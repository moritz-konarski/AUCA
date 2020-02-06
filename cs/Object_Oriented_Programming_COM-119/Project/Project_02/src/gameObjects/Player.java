package gameObjects;

import javax.swing.*;
import java.awt.*;

public class Player extends MoveableSokobanObject {
    private int dx, dy;
    private static Image backImage, rightImage, leftImage;

    Player(int x, int y) {
        super(x, y, ObjectType.PLAYER);
        dx = 0;
        dy = 1;
        loadImage("src/images/RobotDown.png");
        loadBackImage("src/images/RobotUp.png");
        loadLeftImage("src/images/RobotLeft.png");
        loadRightImage("src/images/RobotRight.png");
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    @Override
    public void move(int dx, int dy) {
        setDx(dx);
        setDy(dy);
        super.move(dx, dy);
    }

    public Image getBackImage() {
        return backImage;
    }

    public Image getRightImage() {
        return rightImage;
    }

    public Image getLeftImage() {
        return leftImage;
    }

    private void loadBackImage(String path) {
        ImageIcon ii = new ImageIcon(path);
        backImage = ii.getImage();
    }

    private void loadLeftImage(String path) {
        ImageIcon ii = new ImageIcon(path);
        leftImage = ii.getImage();
    }

    private void loadRightImage(String path) {
        ImageIcon ii = new ImageIcon(path);
        rightImage = ii.getImage();
    }
}
