class Turtle {

    //constants
    final char MARKED = '*';
    final char UNMARKED = '.';
    final char SIGN = 't';

    //state
    int posX, posY, dx, dy;
    double angle;
    boolean penUp;

    //constructor
    Turtle(int newPosX, int newPosY) {
        posX = newPosX;
        posY = newPosY;
        angle = 0;
        penUp = true;
    }

    void penUp(){
        penUp = true;
    }

    void penDown(){
        penUp = false;
    }

    //behavior
    void move(String distanceCommand, char[][] field) {
        int distance = Integer.parseInt(distanceCommand);
        dx = (int) Math.cos(angle);
        dy = (int) Math.sin(angle);
        for (int i = 0; i < distance; i++) {
            if (!penUp)
                field[posY][posX] = MARKED;
            else if (field[posY][posX] == SIGN)
                field[posY][posX] = UNMARKED;
            if (posX + dx >= field[1].length || posY + dy >= field.length ||
                    posX + dx < 0 || posY + dy < 0) {
                System.err.println("Hit the edge!");
                field[posY][posX] = SIGN;
                break;
            }
            posY += dy;
            posX += dx;
        }
        field[posY][posX] = SIGN;
    }

    void turnLeft() {
        angle -= Math.PI / 2;
    }

    void turnRight() {
        angle += Math.PI / 2;
    }

    void reset(char[][] field){
        field[posY][posX] = MARKED;
        posX = 0;
        posY = 0;
        field[posY][posX] = SIGN;
        angle = 0;
        penUp = true;
        System.out.println("reset turtle...");
    }
}
