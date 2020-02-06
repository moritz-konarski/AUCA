package Tasks;/*
Snowflakes that fall from the sky to the bottom. They have different numbers of points and sizes.
 */

import processing.core.PApplet;

import java.util.Random;

public class Task13 extends PApplet {

    //constants
    final int N_SNOWFLAKES = 30;            //number of snowflakes
    final int GRAVITY = 2;                  //the speed at which the snowflakes fall
    final int WHITE = 0xffffffff;           //the color white
    final float DIAMETER_RATIO = 1.6f;      //the ratio between outer and inner diameter
    final float DELTA_GRAVITY = 5f / 8 * GRAVITY;   //the variance in gravity
    final int[] POINTS_RANGE = {6, 10};     //the min and max number of nPoints the flakes can have, need to be even for even point numbers
    final int[] DIAMETER_RANGE = {5, 60};  //the min and max diameter the flakes can have

    //variables
    int[] diameter = new int[N_SNOWFLAKES];             //diameter of the circles
    int[] nPoints = new int[N_SNOWFLAKES];              //number of nPoints of the snowflakes
    float[][] position = new float[N_SNOWFLAKES][2];    //position of snowflakes
    float[] gravity = new float[N_SNOWFLAKES];          //the different gravities that affect the flakes


    public void drawSnowflakes(int numberOfSnowflakes, int[] pointsRange, int[] diameterRange, int GRAVITY) {
        Random random = new Random();                   //creating a new random function
        strokeWeight(3);                                //line thickness
        strokeCap(ROUND);                               //shape of the end of a line
        strokeJoin(ROUND);                              //type of joint between connecting lines
        for (int k = 0; k < numberOfSnowflakes; k++) {
            position[k][1] += gravity[k];                       //increasing y by gravity, to make them fall
            if (position[k][1] > height + diameter[k]) {        //if a flake reaches the bottom
                diameter[k] = random.nextInt(diameterRange[1] - diameterRange[0]) + diameterRange[0];   //give it a new diameter
                nPoints[k] = 2 * random.nextInt(pointsRange[1] / 2 - pointsRange[0] / 2) + pointsRange[0];//give it a new number of points
                position[k][1] = -diameter[k];                                                                 //set it to the top (y)
                position[k][0] = random.nextInt((width - 2 * diameter[k])) + diameter[k];           //put it  between 0 and width
                gravity[k] = GRAVITY + DELTA_GRAVITY * (random.nextFloat() - random.nextFloat());              //give it a new gravity
            }
            final float INNER_RADIUS = diameter[k] / DIAMETER_RATIO;    //the inner diameter
            final float ANGLE = (2 * PI) / nPoints[k];                  //angle between the points of the star
            float x1, y1, x2, y2, x3, y3;                               //initializing variables
            x1 = 0;                                                     //x and y coordinates of the first point on the outer diameter,
            y1 = -diameter[k];                                          //  which is a line straight upwards
            translate(position[k][0], position[k][1]);                  //bring star to the desired position
            stroke(WHITE, 255f * diameter[k] / diameterRange[1] + 20); //color of the lines and saturation
            for (int i = 0; i < nPoints[k]; i++) {
                x2 = INNER_RADIUS * sin(i * ANGLE + .5f * ANGLE);       //x and y coordinates of the point on the inner diameter
                y2 = -INNER_RADIUS * cos(i * ANGLE + .5f * ANGLE);      //
                x3 = diameter[k] * sin(i * ANGLE + ANGLE);              //x and y coordinates of the next point on the outer diameter
                y3 = -diameter[k] * cos(i * ANGLE + ANGLE);             //
                line(0, 0, x1, y1);      //long line from center to point on outer diameter
                line(0, 0, x2, y2);      //short line from center to base of point on inner diameter
                line(x1, y1, x2, y2);           //line connecting the outer nPoints of the previous two lines
                line(x2, y2, x3, y3);           //line from point on inner diameter to next point of star to complete the section
                x1 = x3;                        //passing x3 and y3 on to be used in the next iteration of the loop,
                y1 = y3;                        //because they are already calculated, so it is more efficient to use them
            }
            translate(-position[k][0], -position[k][1]);        //translating back to the position before the loop
        }
    }

    public void prepareFlakes(int outerRadius) {
        Random random = new Random();               //creating new random function
        for (int i = 0; i < N_SNOWFLAKES; i++) {
            position[i][1] = random.nextInt(height);                                    //random y position
            diameter[i] = random.nextInt(DIAMETER_RANGE[1] - DIAMETER_RANGE[0]) + DIAMETER_RANGE[0];    //random diameter
            position[i][0] = random.nextInt((width - 2 * diameter[i])) + diameter[i];
            nPoints[i] = 2 * random.nextInt(POINTS_RANGE[1] / 2 - POINTS_RANGE[0] / 2) + POINTS_RANGE[0];//random number of points
            gravity[i] = GRAVITY + DELTA_GRAVITY * (random.nextFloat() - random.nextFloat());                  //random gravity
        }
    }

    //this constitutes the settings for the code
    public void settings() {
        size(1280, 720);
    }

    //this provides setup, extends settings
    public void setup() {
        prepareFlakes(DIAMETER_RANGE[1]);
    }

    //this specifies the drawing
    public void draw() {
        background(0);
        drawSnowflakes(N_SNOWFLAKES, POINTS_RANGE, DIAMETER_RANGE, GRAVITY); //calling the method
    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]) {
        PApplet.main("Tasks.Task13");
    }
}