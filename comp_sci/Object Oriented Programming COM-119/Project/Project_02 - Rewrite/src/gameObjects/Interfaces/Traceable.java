package gameObjects.Interfaces;

public interface Traceable {
    void undoMove();

    void redoMove();

    void updateMoveHistory();
}

