package gameObjects;

public class Wall extends SokobanObject implements Collision {

    Wall() {
        super(ObjectType.WALL);
        loadImage("src/images/Wall.png");
    }
}
