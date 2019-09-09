package gameObjects.Interfaces;

public interface Moveable {
    int getX();

    int getY();

    void setPosition(int x, int y);

    void move(int dx, int dy);

    int getMoveCount();
}
