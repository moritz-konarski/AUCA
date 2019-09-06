package gameObjects;

import java.util.ArrayList;

public class MoveableSokobanObject extends SokobanObject
        implements Collision, Moveable, Traceable {

    private int x ,y;
    private ArrayList<Integer[]> positionHistory;
    private int moveCount, currentMove;

    MoveableSokobanObject(int x, int y, ObjectType type) {
        super(type);
        this.x = x;
        this.y = y;
        moveCount = currentMove = 0;
        positionHistory = new ArrayList<>();
        positionHistory.add(new Integer[]{getX(), getY()});
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public void move(int dx, int dy) {
        setPosition(getX() + dx, getY() + dy);
        updateMoveHistory();
        currentMove++;
        moveCount++;
        positionHistory.add(new Integer[]{getX(), getY()});
    }

    @Override
    public void undoMove() {
        if (currentMove > 0) {
            currentMove--;
            setPosition(positionHistory.get(currentMove));
        }
    }

    @Override
    public void redoMove() {
        if (currentMove < moveCount) {
            currentMove++;
            setPosition(positionHistory.get(currentMove));
        }
    }

    @Override
    public void updateMoveHistory() {
        updateMoveHistory(currentMove);
    }

    private void updateMoveHistory(int currentMove) {
        while (moveCount > currentMove && moveCount > 0) {
            positionHistory.remove(moveCount--);
        }
    }

    private void setPosition(Integer[] position) {
        setPosition(position[0], position[1]);
    }
}
