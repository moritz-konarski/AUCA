import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

class Food {

    private static Integer[] position;

    Food(ArrayList<Integer[]> allowablePositions) {
        //choose one out of the permitted positions
        if (allowablePositions.size() > 0) {
            position = allowablePositions.get(ThreadLocalRandom.current().nextInt(0, allowablePositions.size())).clone();
        } else {
            position = new Integer[]{0, 0};
        }
    }

    int getX() {
        return position[0];
    }

    int getY() {
        return position[1];
    }
}
