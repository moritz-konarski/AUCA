package gameObjects;

public interface Traceable {
    void undoMove();

    void redoMove();

    void updateMoveHistory();
}

