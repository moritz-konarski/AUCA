import java.util.ArrayList;
import java.util.Arrays;

/*The class for the snake that moves around */

class Snake {

    //instance variables
    private int headIndex, rows, cols;
    private int[] direction, lastDirection, lastTailPosition, headPosition;
    private boolean ignoreWalls;
    private ArrayList<Integer[]> body;

    //static class that contains directions
    private static class Direction {
        final static int[] UP = new int[]{0, -1};
        final static int[] DOWN = new int[]{0, 1};
        final static int[] LEFT = new int[]{-1, 0};
        final static int[] RIGHT = new int[]{1, 0};
    }

    //Constructor
    Snake(Integer[] givenPosition, int rows, int cols, boolean ignoreWalls) {
        this.rows = rows;
        this.cols = cols;
        this.ignoreWalls = ignoreWalls;
        //initiate the direction of the snake
        direction = new int[2];
        lastDirection = direction.clone();
        //initiate the body of the snake
        body = new ArrayList<>();
        body.add(givenPosition.clone());
        //set the index of the head for "ring buffer snake"
        headIndex = getSize() - 1;
        //initialize the head position
        headPosition = new int[2];//{body.get(headIndex)[0], body.get(headIndex)[1]};
        //initialize the last position of the tail, for growing the snake
        lastTailPosition = new int[2];//{body.get(headIndex)[0], body.get(headIndex)[1]};
    }

    void grow() {
        //add add a new element to the end of the snake
        body.add(headIndex + 1, new Integer[]{lastTailPosition[0], lastTailPosition[1]});
    }

    void move() {
        //get the last direction the snake moved int
        lastDirection = direction.clone();
        //copy the head current head position
        headPosition = new int[]{body.get(headIndex)[0], body.get(headIndex)[1]};
        //get new head index
        headIndex = (headIndex + 1) % getSize();
        //copy the last tail position
        lastTailPosition = new int[]{body.get(headIndex)[0], body.get(headIndex)[1]};
        //set the new head to the right position
        if (ignoreWalls) {
            if (Arrays.equals(direction, Direction.RIGHT) && headPosition[0] == cols - 1) {
                body.set(headIndex, new Integer[]{0, headPosition[1]});
            } else if (Arrays.equals(direction, Direction.DOWN) && headPosition[1] == rows - 1) {
                body.set(headIndex, new Integer[]{headPosition[0], 0});
            } else if (Arrays.equals(direction, Direction.LEFT) && headPosition[0] == 0) {
                body.set(headIndex, new Integer[]{cols - 1, headPosition[1]});
            } else if (Arrays.equals(direction, Direction.UP) && headPosition[1] == 0) {
                body.set(headIndex, new Integer[]{headPosition[0], rows - 1});
            } else {
                body.set(headIndex, new Integer[]{headPosition[0] + lastDirection[0], headPosition[1] + lastDirection[1]});
            }
        } else {
            body.set(headIndex, new Integer[]{headPosition[0] + lastDirection[0], headPosition[1] + lastDirection[1]});
        }

    }

    private int getSize() {
        return body.size();
    }

    private boolean bitItsTail() {
        ArrayList<Integer[]> copyOfBody = getPosition();
        Integer[] head = getHeadPosition();
        copyOfBody.remove(headIndex);
        for (Integer[] bodyPart : copyOfBody) {
            if (Arrays.equals(bodyPart, head)) {
                return true;
            }
        }
        return false;
    }

    private boolean hitWall() {
        Integer[] head = getHeadPosition();
        return (head[0] == -1 || head[0] == cols || head[1] == -1 || head[1] == rows);
    }

    boolean isDead() {
        return bitItsTail() || hitWall();
    }

    void goRight() {
        if (!Arrays.equals(lastDirection, Direction.LEFT))
            direction = Direction.RIGHT;
    }

    void goLeft() {
        if (!Arrays.equals(lastDirection, Direction.RIGHT))
            direction = Direction.LEFT;
    }

    void goUp() {
        if (!Arrays.equals(lastDirection, Direction.DOWN))
            direction = Direction.UP;
    }

    void goDown() {
        if (!Arrays.equals(lastDirection, Direction.UP))
            direction = Direction.DOWN;
    }

    ArrayList<Integer[]> getPosition() {
        return new ArrayList<>(body);
    }

    Integer[] getHeadPosition() {
        return body.get(headIndex).clone();
    }
}
