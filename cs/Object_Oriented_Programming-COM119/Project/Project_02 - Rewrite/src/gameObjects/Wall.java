package gameObjects;

import gameObjects.Interfaces.Collision;

public class Wall extends SokobanObject implements Collision {

    Wall() {
        super(ObjectType.WALL);
        loadImage("src/images/Wall.png");
    }
}
