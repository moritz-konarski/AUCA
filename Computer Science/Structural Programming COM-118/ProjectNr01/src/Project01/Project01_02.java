/*
This program replicates something like an old screensaver. There are three balls, red green and blue, that bounce around the screen.
They travel in a line and bounce of off the sides of the screen in a 90 degree angle.
 */
package Project01;

import processing.core.PApplet;

public class Project01_02 extends PApplet {

    //constants
    final int DIAMETER = 40;                //size of the balls
    final int RED = 0xffff0000;             //the color red
    final int BLUE = 0xff0000ff;            //the color blue
    final int GREEN = 0xff00ff00;           //the color green
    final int[] COLOR = {RED, GREEN, BLUE}; //the colors in an array
    //variables
    int[][] ballVelocities = {
            {10, 7},            //the velocities for the balls, in {x, y}
            {10, 7},
            {10, 7}};
    int[][] ballPositions = {
            {-100, -70},        //the positions of the balls, {x, y}, relative to (0, 0)
            {0, 0},
            {100, 70}};


    public void drawBalls(int[][] position, int[] color, int diameter) {
        translate(width / 2, height / 2);                              //translating to the center of the screen
        for (int i = 0; i < position.length; i++) {
            fill(color[i % color.length]);                                  //coloring the ball
            ellipse(position[i][0], position[i][1], diameter, diameter);    //drawing the ball
        }
    }

    public void moveBalls(int[][] position, int[][] velocities, int diameter) {
        int radius = diameter / 2;
        for (int i = 0; i < position.length; i++) {
            position[i][0] += velocities[i][0];                     //updating the position based
            position[i][1] += velocities[i][1];                     //      on the velocity
            //checking if pos X and Y are in bounds, if not reversing the velocities
            velocities[i][0] = (Math.abs(position[i][0]) + radius > (width / 2)) ? -velocities[i][0] : velocities[i][0];
            velocities[i][1] = (Math.abs(position[i][1]) + radius > (height / 2)) ? -velocities[i][1] : velocities[i][1];
        }
    }

    //this constitutes the settings for the code
    public void settings() {
        size(1280, 720);
    }

    //this provides setup, extends settings
    public void setup() {
        background(0);
        frameRate(30);
    }

    //this specifies the drawing
    public void draw() {
        background(0);                                  //resetting the background
        moveBalls(ballPositions, ballVelocities, DIAMETER); //moving the balls
        drawBalls(ballPositions, COLOR, DIAMETER);          //drawing the balls
    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]) {
        PApplet.main("Project01.Project01_02");
    }
}