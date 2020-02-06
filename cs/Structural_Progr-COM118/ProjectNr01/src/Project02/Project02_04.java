package Project02;
import processing.core.PApplet;
import javax.swing.*;
public class Project02_04 extends PApplet {

    //constants
    final int COLOR = 0xff0000ff;               //the color blue
    final int SIZE = 45;                        //the diameter of the balls
    final int BLACK = 0xff000000;               //the color black
    final int RADIUS = SIZE / 2;                //the radius of the balls
    final int MIN_ALPHA = 50;                   //the minimum alpha value of the balls
    final float[] VELOCITIES = {2f, 2f};        //the starting velocity of the balls, {x, y}

    //variables
    int nBallTrail;                             //number of balls, ball 0 is last in the chain
    float[] alphaValues;                        //the alpha values of each ball
    float[][] positions;                        //the position of each ball
    float[][] velocities;                       //the velocities of each ball

    //drawing the balls
    public void drawBalls() {
        for (int i = 0; i < nBallTrail; i++) {
            fill(BLACK);                                            //background ellipse to cover others
            ellipse(positions[i][0], positions[i][1], SIZE, SIZE);
            fill(COLOR, alphaValues[i]);                            //the actual ellipse
            ellipse(positions[i][0], positions[i][1], SIZE, SIZE);
        }
    }

    //moving the balls
    public void moveBalls() {
        for (int i = 0; i < nBallTrail; i++) {
            //if the ball hits a wall, reverse the velocity of x
            velocities[i][0] = (positions[i][0] + velocities[i][0] + RADIUS > width ||
                    positions[i][0] + velocities[i][0] - RADIUS < 0)
                    ? -velocities[i][0] : velocities[i][0];
            //if the ball hits a wall, reverse the velocity of y
            velocities[i][1] = (positions[i][1] + velocities[i][1] + RADIUS > height ||
                    positions[i][1] + velocities[i][1] - RADIUS < 0)
                    ? -velocities[i][1] : velocities[i][1];
            positions[i][0] += velocities[i][0];    //update x position
            positions[i][1] += velocities[i][1];    //update y position
        }
    }

    //setting up the balls and arrays at the start
    public void setUpBalls() {
        //getting user input
        nBallTrail = Integer.parseInt(JOptionPane.showInputDialog("Number of Shadows: "));
        //initializing arrays
        alphaValues = new float[nBallTrail];                  //alpha values of balls
        positions = new float[nBallTrail][2];                 //positions of balls, [][0] is x [][1] is y
        velocities = new float[nBallTrail][2];                //velocities, same as positions
        //the starting position of all balls, here center of the screen
        final int[] START_POS = {width / 2, height / 2};
        for (int i = 0; i < nBallTrail; i++) {
            velocities[i][0] = VELOCITIES[0];               //setting velocities to initial constant
            velocities[i][1] = VELOCITIES[1];               //
            positions[i][0] = START_POS[0];                 //setting position to starting position
            positions[i][1] = START_POS[1];                 //
            //mapping alpha values to specific balls, from 255 to min because ball goes last
            alphaValues[i] = map(i, 1, nBallTrail, 255, MIN_ALPHA);
        }
        int moved = 0;          //amount of balls that moves successfully
        /*this loop prepares the initial setup by moving the balls like one would normally do.
        * because they are all in the center, it moves the first one until that one is the correct distance
        * away from the second one. Then it starts to move both the first and the second one, until all
        * balls have been moved and are the correct distance (one SIZE) away from each other.*/
        while (moved < nBallTrail) {
            //for all balls that have been moved already, plus the one moving now
            for (int i = 0; i <= moved; i++) {
                //checking if next move would hit wall, if true, reverses velocity
                velocities[i][0] = (positions[i][0] + velocities[i][0] + RADIUS > width ||
                        positions[i][0] + velocities[i][0] - RADIUS < 0)
                        ? -velocities[i][0] : velocities[i][0];
                //checking if next move would hit wall, if true, reverses velocity
                velocities[i][1] = (positions[i][1] + velocities[i][1] + RADIUS > height ||
                        positions[i][1] + velocities[i][1] - RADIUS < 0)
                        ? -velocities[i][1] : velocities[i][1];
                positions[i][0] += velocities[i][0];    //updating positions
                positions[i][1] += velocities[i][1];    //
            }
            //if the ball is the correct distance (SIZE) from the start, move on to the next ball
            if (Math.pow(positions[moved][0] - START_POS[0] + velocities[moved][0], 2) +
                    Math.pow(positions[moved][1] - START_POS[1] + velocities[moved][1], 2) > Math.pow(SIZE, 2)) {
                moved++;
            }
        }
    }

    public void settings() {
        size(1280, 720);
        setUpBalls();                   //setting up arrays and preparing positions
    }

    public void setup() {
        background(0);
    }

    public void draw() {
        background(0);
        moveBalls();        //moving the balls
        drawBalls();        //drawing the balls
    }

    public static void main(String[] args) {
        PApplet.main("Project02.Project02_04");
    }
}