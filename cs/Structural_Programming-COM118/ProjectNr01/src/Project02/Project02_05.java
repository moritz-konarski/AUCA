package Project02;
import processing.core.PApplet;
import javax.swing.*;

public class Project02_05 extends PApplet {

    //constants
    final int SIZE = 45;                        //the diameter of the balls
    final int MIN_ALPHA = 50;                   //the minimum alpha value of the balls
    final int RED = 0xffff0000;                 //the color red
    final int BLUE = 0xff0000ff;                //the color blue
    final int GREEN = 0xff00ff00;               //the color green
    final int BLACK = 0xff000000;               //the color black
    final int RADIUS = SIZE / 2;                //the radius of the balls
    final int[] COLORS = {RED, BLUE, GREEN};    //all the available colors
    final float[] VELOCITY_RANGE = {-4f, 4f};   //the range of the starting velocity of the balls

    //variables
    int nBallTrail;                             //number of balls, ball 0 is last in the chain
    int nElements;                              //number of elements with trails
    float[][] alphaValues;                      //the alpha values of each ball [snake][ball]
    float[][][] positions;                      //the position of each ball [snake][ball][x and y]
    float[][][] velocities;                     //the velocities of each ball [snake][ball][vx and vy]

    //drawing the balls
    public void drawBalls() {
        for (int j = 0; j < nElements; j++) {
            for (int i = 0; i < nBallTrail; i++) {
                fill(BLACK);                                                //background ellipse to cover others
                ellipse(positions[j][i][0], positions[j][i][1], SIZE, SIZE);
                fill(COLORS[j % COLORS.length], alphaValues[j][i]);         //the actual ellipse
                ellipse(positions[j][i][0], positions[j][i][1], SIZE, SIZE);
            }
        }
    }

    //moving the balls
    public void moveBalls() {
        for (int j = 0; j < nElements; j++) {       //all snakes
            for (int i = 0; i < nBallTrail; i++) {  //all balls of each snake
                //if the ball hits a wall, reverse the velocity of x
                velocities[j][i][0] = (positions[j][i][0] + velocities[j][i][0] + RADIUS > width ||
                        positions[j][i][0] + velocities[j][i][0] - RADIUS < 0)
                        ? -velocities[j][i][0] : velocities[j][i][0];
                //if the ball hits a wall, reverse the velocity of y
                velocities[j][i][1] = (positions[j][i][1] + velocities[j][i][1] + RADIUS > height ||
                        positions[j][i][1] + velocities[j][i][1] - RADIUS < 0)
                        ? -velocities[j][i][1] : velocities[j][i][1];
                positions[j][i][0] += velocities[j][i][0];    //update x position
                positions[j][i][1] += velocities[j][i][1];    //update y position
            }
        }
    }

    //setting up the balls and arrays at the start
    public void setUpBalls() {
        //getting user input, number of snakes
        nElements = Integer.parseInt(JOptionPane.showInputDialog("Number of Elements: "));
        //balls per snake
        nBallTrail = Integer.parseInt(JOptionPane.showInputDialog("Number of Shadows: "));
        //initializing arrays
        alphaValues = new float[nElements][nBallTrail];     //alpha values of balls
        positions = new float[nElements][nBallTrail][2];    //positions of balls, [snake][ball][0] is x [][][1] is y
        velocities = new float[nElements][nBallTrail][2];   //velocities, same as positions

        for (int j = 0; j < nElements; j++) {
            //getting a random start position
            final int[] START_POS = {(int)random(SIZE, width - SIZE), (int)random(SIZE, height - SIZE)};
            //getting random velocities
            final float VEL_X = random(VELOCITY_RANGE[0], VELOCITY_RANGE[1]);
            final float VEL_Y = random(VELOCITY_RANGE[0], VELOCITY_RANGE[1]);
            for (int i = 0; i < nBallTrail; i++) {
                velocities[j][i][0] = VEL_X;               //setting velocities
                velocities[j][i][1] = VEL_Y;               //
                positions[j][i][0] = START_POS[0];         //setting position
                positions[j][i][1] = START_POS[1];         //
                //mapping alpha values to specific balls, from 255 to min because ball 0 goes last
                alphaValues[j][i] = map(i, 1, nBallTrail, 255, MIN_ALPHA);
            }
            int moved = 0;          //amount of balls that moved successfully
            /*this loop prepares the initial setup by moving the balls like one would normally do.
             * because they are all in the center, it moves the first one until that one is the correct distance
             * away from the second one. Then it starts to move both the first and the second one, until all
             * balls have been moved and are the correct distance (one SIZE) away from each other.*/
            while (moved < nBallTrail) {
                //for all balls that have been moved already, plus the one moving now
                for (int i = 0; i <= moved; i++) {
                    //checking if next move would hit wall, if true, reverses velocity
                    velocities[j][i][0] = (positions[j][i][0] + velocities[j][i][0] + RADIUS > width ||
                            positions[j][i][0] + velocities[j][i][0] - RADIUS < 0)
                            ? -velocities[j][i][0] : velocities[j][i][0];
                    //checking if next move would hit wall, if true, reverses velocity
                    velocities[j][i][1] = (positions[j][i][1] + velocities[j][i][1] + RADIUS > height ||
                            positions[j][i][1] + velocities[j][i][1] - RADIUS < 0)
                            ? -velocities[j][i][1] : velocities[j][i][1];
                    positions[j][i][0] += velocities[j][i][0];    //updating positions
                    positions[j][i][1] += velocities[j][i][1];    //
                }
                //if the ball is the correct distance (SIZE) from the start, move on to the next ball
                if (Math.pow(positions[j][moved][0] - START_POS[0] + velocities[j][moved][0], 2) +
                        Math.pow(positions[j][moved][1] - START_POS[1] + velocities[j][moved][1], 2)
                        > Math.pow(SIZE, 2)) {
                    moved++;
                }
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
        PApplet.main("Project02.Project02_05");
    }

}
