/*
 * A bunch of circles in rgb that pop up at random places on the screen. The circles opacity out from the center to the
 * perimeter. They should opacity out over some time.
 * */
package Project01;
import processing.core.PApplet;
import java.util.Random;

public class Project01_05 extends PApplet {

    //constants
    final int N_CIRLCES = 20;                           //the number of concurrent circles 25
    final int N_CONCENTRIC_CIRCLES = 25;                //the number of concentric circles per circle 20
    final int SIZE = 200;                               //the max diameter of the circles 200
    final int RED = 0xffff0000;                         //the color red
    final int GREEN = 0xff00ff00;                       //the color green
    final int BLUE = 0xff0000ff;                        //the color blue
    final int YELLOW = 0xffffff00;                      //the color yellow
    final int CYAN = 0xff00ffff;                        //the color cyan
    final int GRAY = 0xffe0e0e0;                        //the color gray
    final int PINK = 0xffff66ff;                        //the color pink
    final int[] COLORS = {RED, GREEN, BLUE, YELLOW, CYAN, GRAY, PINK}; //an array containing all useable colors
    final float FADE_LIMIT = 0f;                        //the minimum value for the opacity-variable
    final float DELTA_ALPHA = 130f / N_CIRLCES;         //the alpha difference between each circle-iteration
    final float[] SPEED_RANGE = {0.1f, 0.7f};           //range of fade speeds
    //variables
    int[] whichColor = new int[N_CIRLCES];              //saves selected color of circle, [#circle], value == (index) of color array
    int[][] position = new int[N_CIRLCES][2];           //the array for the position of the circle, [#circle][position(0==x, 1==y)]
    float[] opacity = new float[N_CIRLCES];             //the actual opacity value, for each of the circles, [0...1]
    float[] fadeSpeed = new float[N_CIRLCES];           //speed for the fading in and out of the circles

    /*A method to draw nCircles concurrent circles that fade in and out on based on semi random values.
     * If a circle fades out, it changes color and position and gets new semi random opacity values.*/
    public void drawCircles(int nCircles, int nConcentricCircles, int diameter, int[] colors) {
        noStroke();                                                 //disabling the outline of the circles
        final int DELTA_SIZE = diameter / nConcentricCircles;       //the size increase for each circle-iteration
        //drawing the circles
        for (int k = 0; k < nCircles; k++) {
            for (int j = nConcentricCircles; j > 0; j--) {          //for each of the concentric circles
                float currentDiameter = j * DELTA_SIZE;             //circle size decreases over the course of the loop
                //alpha increases as the circles get smaller, modified by circle opacity
                fill(colors[whichColor[k]], (nConcentricCircles - j) * DELTA_ALPHA * opacity[k]);
                ellipse(position[k][0], position[k][1], currentDiameter, currentDiameter);      //drawing the circle
            }
        }
    }

    //this method updates the parameters of the circle
    public void updateCircles(int nCircles, int diameter, int[] colors){
        Random random = new Random();
        //constants
        final int MIN_X_Y = diameter / 2;                       //minimal distance from the window to not clip
        final int MAX_X = width - 2 * MIN_X_Y;                  //maximal x value for random number
        final int MAX_Y = height - 2 * MIN_X_Y;                 //maximal y value for random number
        //updating the position, opacity and fade speed of the circles
        for (int m = 0; m < nCircles; m++) {
            opacity[m] += fadeSpeed[m];                             //adjust the opacity value by the fade speed
            if (opacity[m] <= FADE_LIMIT) {                         //if the circle faded out
                //setting a fadespeed in SPEED_OFFSET +- SPEED_RANGE
                fadeSpeed[m] = random(SPEED_RANGE[0], SPEED_RANGE[1]);
                position[m][0] = (int) random(MIN_X_Y, MAX_X);      //random x position
                position[m][1] = (int) random(MIN_X_Y, MAX_Y);      //random y position
                whichColor[m] = random.nextInt(COLORS.length);      //random color
            } else if (opacity[m] > 1) {
                fadeSpeed[m] = -fadeSpeed[m];    //if the circle reaches full saturation, reverse the opacity speed
            }
        }
    }

    //this method initializes position and fadeSpeed for all the circles, somewhat randomly
    public void circleSetup() {
        Random random = new Random();                           //importing random function
        final int MIN_X_Y = SIZE / 2;                           //minimal distance from the window to not clip
        final int MAX_X = width - 2 * MIN_X_Y;                  //maximal x value for random number
        final int MAX_Y = height - 2 * MIN_X_Y;                 //maximal y value for random number
        for (int i = 0; i < fadeSpeed.length; i++) {
            //setting a fadespeed in SPEED_OFFSET +- SPEED_RANGE
            fadeSpeed[i] = random(SPEED_RANGE[0], SPEED_RANGE[1]);
            position[i][0] = (int) random(MIN_X_Y, MAX_X);      //random x position
            position[i][1] = (int) random(MIN_X_Y, MAX_Y);      //random y position
            whichColor[i] = random.nextInt(COLORS.length);      //random color
        }
    }

    public void settings() {
        size(1280, 720);
    }

    public void setup() {
        background(0);
        circleSetup();
    }

    public void draw() {
        background(0);                                              //resetting the background
        updateCircles(N_CIRLCES, SIZE, COLORS);                         //updating the parameters of each circle
        drawCircles(N_CIRLCES, N_CONCENTRIC_CIRCLES, SIZE, COLORS);     //drawing circles
    }

    public static void main(String[] args) {
        PApplet.main("Project01.Project01_05");
    }
}