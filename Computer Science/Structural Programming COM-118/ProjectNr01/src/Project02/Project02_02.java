//a program that makes n stars fall from the sky, only they are while square stars

package Project02;

import processing.core.PApplet;

import javax.swing.*;
import java.util.Random;

public class Project02_02 extends PApplet {

    //constants
    final int N_POINTS = 8;                         //number of points of the snowflake
    final int WHITE = 0xffffffff;                   //the color white
    final float JITTER = 1f;                        //the random movement in the x direction
    final float DIAMETER_RATIO = 10f;               //the ratio between outer and inner diameter of the flake
    final float ANGULAR_VELOCITY = .02f;            //the maximum rotational speed of the flakes
    final int[] DIAMETER_RANGE = {5, 35};           //the min and max diameter the flakes can have
    final float[] GRAVITY_RANGE = {1.25f, 2.5f};    //the range of value gravity can have

    //variables
    int nSnowflakes;            //number of snowflakes
    int[] diameter;             //diameter of the circles
    float[] angle;              //the angle of each snowflake
    float[] gravity;            //the different gravities that affect the flakes
    float[] angularVelocity;    //the velocity with which te flakes rotate
    float[][] position;         //position of snowflakes

    //set up the flakes and arrays initially
    public void prepareFlakes() {
        Random random = new Random();                   //creating new random function
        //getting input for the number of flakes
        nSnowflakes = Integer.parseInt(JOptionPane.showInputDialog("Number of Snowflakes:"));
        //initializing all arrays
        diameter = new int[nSnowflakes];                //diameter of the circles
        position = new float[nSnowflakes][2];           //position of snowflakes
        gravity = new float[nSnowflakes];               //the different gravities that affect the flakes
        angle = new float[nSnowflakes];                 //angle of the snowflakes
        angularVelocity = new float[nSnowflakes];       //rotation speed of the flakes
        //filling the arrays with random numbers
        for (int i = 0; i < nSnowflakes; i++) {
            angle[i] = TWO_PI * random.nextFloat();     //random angle
            //diameter in a certain range
            diameter[i] = (int) random(DIAMETER_RANGE[0], DIAMETER_RANGE[1]);
            position[i][1] = random.nextInt(height);    //random y position
            //x position such that the flake does not leave the screen
            position[i][0] = random(diameter[i], width - 2 * diameter[i]);
            //setting a gravity in a certain range
            gravity[i] = random(GRAVITY_RANGE[0], GRAVITY_RANGE[1]);
            //setting a random angular velocity with a maximum
            angularVelocity[i] = random(-ANGULAR_VELOCITY, ANGULAR_VELOCITY);
        }
    }

    //updates the flakes each loop to move and reset them
    public void updateFlakes(int nSnowflakes) {
        Random random = new Random();                                               //creating new random function
        for (int k = 0; k < nSnowflakes; k++) {
            position[k][0] += JITTER * random(-1, 1);                      //applying some jitter to the position
            position[k][1] += gravity[k];                                           //increasing y by gravity, to make them fall
            //increasing angle or setting to 0
            angle[k] = (angle[k] > TWO_PI || angle[k] < 0) ? 0 : angle[k] + angularVelocity[k];
            if (position[k][1] > height + diameter[k]) {                            //if a flake reaches the bottom
                angle[k] = TWO_PI * random.nextFloat();     //random angle
                //diameter in a certain range
                diameter[k] = (int) random(DIAMETER_RANGE[0], DIAMETER_RANGE[1]);
                position[k][1] = -diameter[k];    //random y position
                //x position such that the flake does not leave the screen
                position[k][0] = random(diameter[k], width - 2 * diameter[k]);
                //setting a gravity in a certain range
                gravity[k] = random(GRAVITY_RANGE[0], GRAVITY_RANGE[1]);
                //setting a random angular velocity with a maximum
                angularVelocity[k] = random(-ANGULAR_VELOCITY, ANGULAR_VELOCITY);
            }
        }
    }

    //drawing each of the snowflakes
    public void drawSnowflakes(int numberOfSnowflakes, int points, int[] diameterRange) {
        //variables
        float innerRadius;                              //the inner diameter
        final float ANGLE = (2 * PI) / points;          //angle between the points of the star
        float x1, y1, x2, y2, x3, y3;                   //initializing variables for points
        float diagonal;                                 //the long diagonal of the flake
        float usedDiameter;                             //the diameter used to draw
        float alpha;                                    //alpha value of the flakes
        //drawing setup
        strokeWeight(2.5f);                             //line thickness
        strokeCap(ROUND);                               //shape of the end of a line
        strokeJoin(ROUND);                              //type of joint between connecting lines
        for (int k = 0; k < numberOfSnowflakes; k++) {
            innerRadius = diameter[k] / DIAMETER_RATIO;                 //the inner diameter
            diagonal = (float) Math.sqrt(2 * Math.pow(diameter[k], 2)); //the length of the diagonal of a square with side radius
            x1 = 0;                                                     //x and y coordinates of the first point on the outer diameter,
            y1 = -diameter[k];                                          //  which is a line straight upwards
            translate(position[k][0], position[k][1]);                  //bring star to the desired position
            rotate(angle[k]);                                           //rotating the whole snowflake
            //mapping the ratio between actual and maximal radius to an alpha value
            alpha = map(diameter[k], diameterRange[0], diameterRange[1], 40, 200);
            stroke(WHITE, alpha);                                       //color of the lines and saturation
            for (int i = 0; i < points; i++) {
                usedDiameter = (i % 2 == 0) ? diagonal : diameter[k];   //alternating between diameter and diagonal
                x2 = innerRadius * sin(i * ANGLE + .5f * ANGLE);   //x and y coordinates of the point on the inner diameter
                y2 = -innerRadius * cos(i * ANGLE + .5f * ANGLE);  //
                x3 = usedDiameter * sin(i * ANGLE + ANGLE);        //x and y coordinates of the next point on the outer diameter
                y3 = -usedDiameter * cos(i * ANGLE + ANGLE);       //
                line(0, 0, x1, y1);      //long line from center to point on outer diameter
                line(0, 0, x2, y2);      //short line from center to base of point on inner diameter
                line(x1, y1, x2, y2);           //line connecting the outer nPoints of the previous two lines
                line(x2, y2, x3, y3);           //line from point on inner diameter to next point of star to complete the section
                x1 = x3;                        //passing x3 and y3 on to be used in the next iteration of the loop,
                y1 = y3;                        //because they are already calculated, so it is more efficient to use them
            }
            rotate(-angle[k]);                                  //rotate back to no angle
            translate(-position[k][0], -position[k][1]);        //translating back to the position before the loop
        }
    }

    public void settings() {
        size(1280, 720);    //setting screen size
        prepareFlakes();                //preparing the snowflakes
    }

    public void setup() {
        background(0);
    }

    public void draw() {
        background(0);
        updateFlakes(nSnowflakes);      //updating the snowflake (making them fall)
        drawSnowflakes(nSnowflakes, N_POINTS, DIAMETER_RANGE); //calling the method
    }

    public static void main(String[] args) {
        PApplet.main("Project02.Project02_02");
    }
}