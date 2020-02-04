/*This program creates n stars that bounce around the screen and bounce off the edges. The are of different
 * sizes and colors and alpha values. They have the same number of points though. They also spin around.*/

package Project02;
import processing.core.PApplet;
import javax.swing.*;
import java.util.Random;

public class Project02_01 extends PApplet {

    //constants
    final int NUMBER_OF_POINTS = 10;                    //number of points per star
    final int MIN_RADIUS = 15;                          //minimum radius of star
    final int MAX_RADIUS = 35;                          //maximum radius of star
    final int MIN_ALPHA = 40;                           //minimum alpha value of star
    final float MIN_VELOCITY = 1f;                      //minimum velocity
    final float MAX_VELOCITY = 5f;                      //maximal velosity
    final float MIN_ANG_VEL = 0.03f;                    //minimum angular velocity
    final float MAX_ANG_VEL = .1f;                      //maximal angular velocity
    //colors
    final int RED = 0xffff0000;                         //the color red
    final int GREEN = 0xff00ff00;                       //the color green
    final int BLUE = 0xff0000ff;                        //the color blue
    final int YELLOW = 0xffffff00;                      //the color yellow
    final int CYAN = 0xff00ffff;                        //the color cyan
    final int GRAY = 0xffe0e0e0;                        //the color gray
    final int PINK = 0xffff66ff;                        //the color pink
    final int[] COLORS = {RED, GREEN, BLUE, YELLOW, CYAN, GRAY, PINK}; //an array containing all useable colors
    //variables
    int nStars = 0;                 //number of stars
    int[][] colors;                 //COLORS index of each star, alpha value for each star
    float[] radii;                  //radius of each star
    float[] angularVelocities;      //angular velcity of each star
    float[] angle;                  //angle of rotation for each star
    float[][] positions;            //position of each star, [star][x=0, y=1]
    float[][] velocities;           //velocity of each star

    public void drawStars(float[][] position, float[] outerRadius, int numberOfPoints, int[][] colorOfStar) {
        //drawing setup
        strokeWeight(3);                                //line thickness
        strokeCap(ROUND);                               //shape of the end of a line
        strokeJoin(ROUND);                              //type of joint between connecting lines
        final float ANGLE = (TWO_PI) / numberOfPoints;  //angle between the points of the star

        for (int j = 0; j < nStars; j++) {
            stroke(colorOfStar[j][0], colorOfStar[j][1]);       //color of the lines
            translate(position[j][0], position[j][1]);          //bring star to the desired position
            rotate(angle[j]);                                   //rotate star, make it spin
            final float INNER_RADIUS = outerRadius[j] / 6f;     //ratio of outer radius to inner radius
            float x1, y1, x2, y2, x3, y3;                       //initializing variables
            //x and y coordinates of the first point on the outer radius which is a line straight upwards
            x1 = 0;
            y1 = -outerRadius[j];
            //drawing the star
            for (int i = 0; i < numberOfPoints; i++) {
                x2 = INNER_RADIUS * sin(i * ANGLE + .5f * ANGLE);  //x, y coord. of point on inner radius
                y2 = -INNER_RADIUS * cos(i * ANGLE + .5f * ANGLE); //
                x3 = outerRadius[j] * sin(i * ANGLE + ANGLE);      //x, y coord. of next point on outer radius
                y3 = -outerRadius[j] * cos(i * ANGLE + ANGLE);     //
                line(0, 0, x1, y1);      //long line from center to point on outer radius
                line(0, 0, x2, y2);      //short line from center to base of point on inner radius
                line(x1, y1, x2, y2);          //line connecting the outer points of the previous two lines
                line(x2, y2, x3, y3);          //line from point on inner radius to next point of star
                x1 = x3;                       //passing x3 and y3 on to be used in the next iteration of the loop,
                y1 = y3;                       //
            }
            rotate(-angle[j]);                 //rotating back, to have initial conditions again
            //reset the coordinate system back to the way it was before the function
            translate(-position[j][0], -position[j][1]);
        }
    }

    public void moveStars(float[][] position, float[][] velocities) {
        for (int k = 0; k < nStars; k++) {
            //increment angle of set it to zero if one period is completed
            angle[k] = (angle[k] < TWO_PI) ? angle[k] + angularVelocities[k] : 0;
            //update position x
            position[k][0] += velocities[k][0];
            //update position y
            position[k][1] += velocities[k][1];
            //if star leaves screen, invert the velocity so it reflects, for x direction
            velocities[k][0] = (position[k][0] + radii[k] < width && position[k][0] - radii[k] > 0)
                    ? velocities[k][0] : -velocities[k][0];
            //if star leaves screen, invert the velocity so it reflects, for y direction
            velocities[k][1] = (position[k][1] + radii[k] < height && position[k][1] - radii[k] > 0)
                    ? velocities[k][1] : -velocities[k][1];
        }
    }

    public void setupStars(int nStars, int minRadius, int maxRadius, int minAlpha) {
        Random random = new Random();
        //initializing all the arrays
        colors = new int[nStars][2];
        radii = new float[nStars];
        angularVelocities = new float[nStars];
        angle = new float[nStars];
        positions = new float[nStars][2];
        velocities = new float[nStars][2];
        //filing them with data
        for (int i = 0; i < nStars; i++) {
            radii[i] = random.nextInt(maxRadius - minRadius) + minRadius;   //random radius within min and max
            angle[i] = random.nextFloat() * TWO_PI;                               //random angle of rotation
            colors[i][0] = COLORS[random.nextInt(COLORS.length)];                 //random color
            colors[i][1] = random.nextInt(130 - minAlpha) + minAlpha;       //random alpha value
            //random position within the screen, x and y
            positions[i][0] = random.nextInt(width - (int) radii[i] * 2) + radii[i];
            positions[i][1] = random.nextInt(height - (int) radii[i] * 2) + radii[i];
            //random angular velocities within min and max
            angularVelocities[i] = MIN_ANG_VEL + random.nextFloat() * (MAX_ANG_VEL - MIN_ANG_VEL);
            //random magnitude and direction of x velocity
            velocities[i][0] = MIN_VELOCITY + random.nextFloat() * (MAX_VELOCITY - MIN_VELOCITY);
            velocities[i][0] = (random.nextBoolean()) ? -velocities[i][0] : velocities[i][0];
            //random magnitude and direction of y velocity
            velocities[i][1] = MIN_VELOCITY + random.nextFloat() * (MAX_VELOCITY - MIN_VELOCITY);
            velocities[i][1] = (random.nextBoolean()) ? -velocities[i][1] : velocities[i][1];
        }
    }

    public void settings() {
        size(1280, 720);
        nStars = Integer.parseInt(JOptionPane.showInputDialog("Number of Stars"));
    }

    public void setup() {
        background(0);
        setupStars(nStars, MIN_RADIUS, MAX_RADIUS, MIN_ALPHA);
    }

    public void draw() {
        background(0);
        moveStars(positions, velocities);                       //moving the stars
        drawStars(positions, radii, NUMBER_OF_POINTS, colors);  //drawing the stars
    }

    public static void main(String[] args) {
        PApplet.main("Project02.Project02_01");
    }
}