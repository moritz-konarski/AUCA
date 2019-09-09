/*
Something that looks like a mirrored sine wave that is made up of 9 squished ellipses, going from left to right.
They have a red border and they change saturation based on their value/height.
 */
package Project01;
import processing.core.PApplet;

public class Project01_03 extends PApplet {
    
    //constants
    final int NUMBER_OF_ELLIPSES = 9;       //the number of ellipses
    final int RED = 0xffff0000;             //the color red
    final int MIN_INTENSITY = 130;          //minimal alpha of the fill of the ellipse
    final float FREQUENCY = -0.08f;         //speed of the wave; negative: left->right, positive: right->left
    //variables
    float[] angle = {0};                    //a variable for the angle

    public void drawEllipses(int numberOfEllipses, float frequency, float[] angle, int color) {
        translate(0, height / 2);                              //set the 0 of y to the middle of the screen
        //constants
        final int E_WIDTH = width / (numberOfEllipses + 2);         //width for ellipses, one ellipse of space to each side
        final int MIN_HEIGHT = E_WIDTH / 2;                         //minimum height
        final int MAX_HEIGHT = height / 2;                          //max factor for height
        final float DELTA_ANGLE = (TWO_PI) / numberOfEllipses;      //splitting 2 pi between the ellipses to represent one period
        //variables
        float yHeight = 0;                                          //the specific height of the ellipse
        float alpha = 0;                                            //the alpha value based on the height
        //drawing
        stroke(color);                                              //the color ot the ellipses' outline
        for (int i = 0; i < numberOfEllipses; i++) {
            //the height of the ellipse for the given angle, based on a cosine wave
            yHeight = map(cos(angle[0] + i * DELTA_ANGLE), -1, 1, MIN_HEIGHT, MAX_HEIGHT);
            //the alpha of the ellipse, corresponding to height, relative to max height
            alpha = map(yHeight, MIN_HEIGHT, MAX_HEIGHT, MIN_INTENSITY, 255);
            fill(color, alpha);                                               //coloring the ellipse
            //offsetting the ellipse to put them next to each other and drawing them
            ellipse(1.5f * E_WIDTH + i * E_WIDTH, 0, E_WIDTH, yHeight);
        }
        //reset the angle if it completes the full period, otherwise increment it
        angle[0] = (Math.abs(angle[0]) > (2 * PI)) ? 0 : angle[0] + frequency;
    }
    
    public void settings() {
        size(1280, 720);
    }
    
    public void setup() {
        background(0);
    }
    
    public void draw() {
        background(0);                                            //resetting the background
        drawEllipses(NUMBER_OF_ELLIPSES, FREQUENCY, angle, RED);      //drawing the section of ellipses
    }
    
    public static void main(String args[]) {
        PApplet.main("Project01.Project01_03");
    }
}