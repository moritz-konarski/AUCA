/*
This program draws 5 stars that change their size. Each of the stars has 4 points.
There is one star in the center of the screen and the other four in the center of the quadrants of the screen
 */

package Project01;
import processing.core.PApplet;
public class Project01_01 extends PApplet {

    //constants
    final int POINTS_OF_STAR = 4;       //points of the star
    final int SUBTRACT_RADIUS = 250;    //value the radius is subtracted from to have alternating pulsing for the outer stars
    final int RED = 0xffff0000;         //the color red
    final int MAGENTA = 0xffff00ff;     //the color magenta
    final int[] RADIUS_RANGE = {100, 200}; //range of value the radii can have
    //variables
    int radius = 200;                   //radius of the circles
    int change = 1;                     //the rate of change of the radius per draw-loop


    public void drawStar(float posX, float posY, float outerRadius, int numberOfPoints, int colorOfStar) {
        //setup - most of this could technically be in draw, but that would make the function way less reusable
        strokeWeight(4);                                //line thickness
        strokeCap(ROUND);                               //shape of the end of a line
        stroke(colorOfStar);                            //color of the lines
        strokeJoin(ROUND);                              //type of joint between connecting lines
        translate(posX, posY);                          //bring star to the desired position
        //variables
        final float INNER_RADIUS = outerRadius / 3f;    //ratio of outer radius to inner radius
        final float ANGLE = (TWO_PI) / numberOfPoints;  //angle between the points of the star
        float x1, y1, x2, y2, x3, y3;                   //initializing variables

        x1 = 0;                                         //x and y coordinates of the first point on the outer radius,
        y1 = -outerRadius;                              //which is a line straight upwards
        //drawing the star
        for (int i = 0; i < numberOfPoints; i++) {
            x2 = INNER_RADIUS * sin(i * ANGLE + .5f * ANGLE);       //x and y coordinates of the point on the inner radius
            y2 = -INNER_RADIUS * cos(i * ANGLE + .5f * ANGLE);      //
            x3 = outerRadius * sin(i * ANGLE + ANGLE);              //x and y coordinates of the next point on the outer radius
            y3 = -outerRadius * cos(i * ANGLE + ANGLE);             //
            line(0, 0, x1, y1);      //long line from center to point on outer radius
            line(0, 0, x2, y2);      //short line from center to base of point on inner radius
            line(x1, y1, x2, y2);          //line connecting the outer points of the previous two lines
            line(x2, y2, x3, y3);          //line from point on inner radius to next point of star to complete the section
            x1 = x3;                       //passing x3 and y3 on to be used in the next iteration of the loop,
            y1 = y3;                       //because they are already calculated, so it is more efficient to use them
        }
        translate(-posX, -posY);           //reset the coordinate system back to the way it was before the function
    }

    //this constitutes the settings for the code
    public void settings() {
        size(1280, 720);
    }

    //this provides setup, extends settings
    public void setup() {

    }

    //this specifies the drawing
    public void draw() {
        //setup
        final int UNIT_X = width / 4;                    //the width divided by four as a unit of measurement
        final int UNIT_Y = height / 4;                   //the height divided by four as a unit of measurement
        translate(2 * UNIT_X, 2 * UNIT_Y);          //setting (0; 0) to the middle of the screen
        background(0);                               //setting a black background to allow animations / clearing the screen
        //drawing the stars
        drawStar(0, 0, radius, POINTS_OF_STAR, RED);                                      //center, red
        drawStar(UNIT_X, UNIT_Y, SUBTRACT_RADIUS - radius, POINTS_OF_STAR, MAGENTA);       //bottom right, magenta
        drawStar(-UNIT_X, UNIT_Y, SUBTRACT_RADIUS - radius, POINTS_OF_STAR, MAGENTA);      //bottom left, magenta
        drawStar(-UNIT_X, -UNIT_Y, SUBTRACT_RADIUS - radius, POINTS_OF_STAR, MAGENTA);     //top left, magenta
        drawStar(UNIT_X, -UNIT_Y, SUBTRACT_RADIUS - radius, POINTS_OF_STAR, MAGENTA);      //top right, magenta
        //changing the radius
        radius -= change;       //incrementing the radius
        //changing change-variable if the stars get too small/large
        change = (radius > RADIUS_RANGE[1] || radius < RADIUS_RANGE[0]) ? -change : change;
    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]) {
        PApplet.main("Project01.Project01_01");
    }
}