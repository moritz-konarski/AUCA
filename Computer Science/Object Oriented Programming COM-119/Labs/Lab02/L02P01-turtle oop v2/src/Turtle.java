class Turtle {

    //instance variables
    private int posX, posY;
    private double angle;
    private boolean penUp;

    //constructor
    Turtle(int newPosX, int newPosY) {
        posX = newPosX;
        posY = newPosY;
        angle = 0;
        penUp = true;
    }

    //get x position
    int getPosX(){
        return posX;
    }

    //get y position
    int getPosY(){
        return posY;
    }

    //put pen up
    void setPenUp() {
        penUp = true;
    }

    //put pen down
    void setPenDown() {
        penUp = false;
    }

    //move the turtle
    void move(String distanceCommand, Field field) {
        int distance = Integer.parseInt(distanceCommand);
        int dx = (int) Math.cos(angle);
        int dy = (int) Math.sin(angle);
        if (!penUp)
            field.setFieldMarked(posX, posY);
        for (int i = 0; i < distance; i++) {
            if (posX + dx >= field.getCols() || posY + dy >= field.getRows() ||
                    posX + dx < 0 || posY + dy < 0) {
                System.err.println("Hit the edge!");
                break;
            }
            posY += dy;
            posX += dx;
            if (!penUp)
                field.setFieldMarked(posX, posY);
        }
    }

    //change the direction by -90 degrees
    void turnLeft() {
        angle -= Math.PI / 2;
    }

    //change the direction by +90 degrees
    void turnRight() {
        angle += Math.PI / 2;
    }

    //turn 180 degrees
    void turnBack() {
        angle += Math.PI;
    }

    //reset the turtle's parameters
    void reset() {
        posX = 0;
        posY = 0;
        angle = 0;
        penUp = true;
    }
}