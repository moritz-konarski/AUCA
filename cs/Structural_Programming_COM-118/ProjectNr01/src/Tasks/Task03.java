package Tasks;

import processing.core.PApplet;

public class Task03 extends PApplet{                        //uses the library we just imported
    final int SIZE = 100;
    int radius = SIZE/2;
    int x, y = 0;
    int deltaX = 10;
    int deltaY = 8;

    //this constitutes the settings for the code
    public void settings(){
        size(1280, 720);                                       //sets the program to full screen mode
    }

    //this provides setup, extends settings
    public void setup(){
        y = height/2;
        x = width/2;
    }

    //this specifies the drawing
    public void draw(){
        background(1);

        x += deltaX;
        if (x > width - radius){
            deltaX = -deltaX;
            x = width - radius;
        }
        else if (x < radius) {
            deltaX = -deltaX;
            x = radius;
        }

        y += deltaY;
        if (y > height - radius){
            deltaY = -deltaY;
            y = height - radius;
        }
        else if (y < radius) {
            deltaY = -deltaY;
            y = radius;
        }

        ellipse(x, y, SIZE, SIZE);

    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]){
        PApplet.main("Tasks.Task03");}
}