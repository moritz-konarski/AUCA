/*This program looks like going to light speed in Star Wars. You have balls flying out from the center. They get larger as
 * they get "closer" and they gain intensity. They are red, green and blue. They also fade in from the center.
 * They have a tail and their speeds differ.*/
package Project02;
import processing.core.PApplet;

public class Project02_03 extends PApplet {

    //constants
    final int N_BALLS = 100;                        //the number of balls or particles
    final int RED = 0xffff0000;                     //the color red
    final int BLUE = 0xff0000ff;                    //the color blue
    final int GREEN = 0xff00ff00;                   //the color green
    final int VELOCITY = 5;                         //the velocity of the balls, in direction of the angle
    final int N_SHADOWS = 20;                       //number of shadows per ball
    final float STEP_SIZE = 3f;                     //the increase in distance from the center for each shadow-circle
    final float DELTA_VELOCITY = 1f;                //the variance the velocity can experience
    final int[] COLORS = {RED, GREEN, BLUE};        //all possible colors
    final int[] SIZE_RANGE = {0, 20};               //the range of possible diameters for the balls
    final int[] ALPHA_RANGE = {100, 255};           //the range of alpha value for the balls
    //variables
    float maxRho;                                   //the largest radius, from center of screen to a corner
    int[] colorIndex = new int[N_BALLS];            //array for the color of a ball, as index of the color array
    float[] rho = new float[N_BALLS];               //the radius (distance from the center) of each ball, polar coordinate
    float[] velocity = new float[N_BALLS];          //the speed along the radius for each ball
    float[][] cosineSine = new float[N_BALLS][2];   //values of sin, cos of angle that a ball travels at, for conversion polar -> cartesian
    float[][] positons = new float[N_BALLS][2];     //position in cartesian coodinates [][0] - x, [][1] - y

    //method that draws all the points
    public void drawPoints() {
        int maxSize, size;                          //initializing variables
        int maxAlpha, alpha;                        //maximum current alpha value and currently used alpha value
        float xStep, yStep;                         //the step in x and y between the circles of the trail
        noStroke();                                 //disable outline
        translate(width / 2, height / 2);      //translate to the center of the screen
        for (int i = 0; i < N_BALLS; i++) {
            //maximum current size at this rho-value
            maxSize = (int) map(rho[i], 0, (maxRho + height) / 2, SIZE_RANGE[0], SIZE_RANGE[1]);
            //maximum current alpha value at this rho-value
            maxAlpha = (int) map(rho[i], 0, (maxRho + height) / 2, ALPHA_RANGE[0], ALPHA_RANGE[1]);
            for (int j = 0; j < N_SHADOWS; j++) {
                alpha = (int) map(j, 0, N_SHADOWS - 1, 0, maxAlpha);    //alpha for one circle from the trail
                size = (int) map(j, 0, N_SHADOWS - 1, 0, maxSize);      //size of one circle from the trail
                xStep = STEP_SIZE * j * cosineSine[i][0];                               //step in x for every new circle of trail
                yStep = STEP_SIZE * j * cosineSine[i][1];                               //step in y for every new circle of trail
                fill(COLORS[colorIndex[i]], alpha);                                      //coloring the circle
                ellipse(positons[i][0] + xStep, positons[i][1] + yStep, size, size);
            }
        }
    }

    //method that moces the points
    public void movePoints() {
        int radius;                                             //radius of the ball
        float angle;                                            //the angle of movement
        for (int i = 0; i < N_BALLS; i++) {
            rho[i] += velocity[i];                              //increasing rho by the corr. velocity
            positons[i][0] = rho[i] * cosineSine[i][0];         //updating the position, here x
            positons[i][1] = rho[i] * cosineSine[i][1];         //updating the position, here y
            //calculating the radius for the current rho-value
            radius = (int) (0.5f * map(rho[i], 0, maxRho, SIZE_RANGE[0], SIZE_RANGE[1]));
            if (positons[i][0] - radius > width / 2 ||          //if the ball leaves the screen
                    positons[i][0] + radius < -width / 2 ||
                    positons[i][1] - radius > height / 2 ||
                    positons[i][1] + radius < -height / 2) {
                rho[i] = 0;                                 //set rho to 0
                angle = random(0, TWO_PI);              //set angle to random
                cosineSine[i][0] = cos(angle);              //calculate new sin(angle)
                cosineSine[i][1] = sin(angle);              //calculate new cos(angle)
            }
        }
    }

    //method that initializes/randomizes arrays
    public void setUpPoints() {
        maxRho = maxRho();                                          //calculating the maximum value for rho
        float angle;                                                //the angle of movement of the ball
        for (int i = 0; i < N_BALLS; i++) {
            rho[i] = random(0, (maxRho + height) / 2);      //setting rho between 0 and the average of maxRho and height
            angle = random(0, TWO_PI);                          //setting random angle
            cosineSine[i][0] = cos(angle);                          //calculate new sin(angle)
            cosineSine[i][1] = sin(angle);                          //calculate new cos(angle)
            //calculating new velocity with variance of DELTA_VELOCITY
            velocity[i] = random(VELOCITY - DELTA_VELOCITY, VELOCITY + DELTA_VELOCITY);
            colorIndex[i] = (int) random(0, COLORS.length);     //selecting a random color from the array
        }
    }

    //method returns the maximum length of rho, its the screen diagonal divided by two
    public float maxRho() {
        return (float) Math.sqrt(Math.pow(width / 2f, 2) + Math.pow(height / 2f, 2));
    }

    public void settings() {
        size(1280, 720);
    }

    public void setup() {
        background(0);
        setUpPoints();          //initialize/randomize arrays
    }

    public void draw() {
        background(0);
        movePoints();           //move points
        drawPoints();           //draw points
    }

    public static void main(String[] args) {
        PApplet.main("Project02.Project02_03");
    }
}
