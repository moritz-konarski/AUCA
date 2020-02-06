package Tasks;

import processing.core.PApplet;

public class Task12 extends PApplet {

    public void drawStar(float x, float y, float radius, int color) {
        //the color should be entered as a hex number in rgb format with the first two places being alpha values
        strokeWeight(4);
        strokeCap(ROUND);
        stroke(color);
        strokeJoin(ROUND);
        noFill();
        float ratio = radius / 4;   //the ratio or radii of the outer corner to the inner corner of the start, pointiness
        //one might also do this using lines to do this, this might be faster for scaling it, also to be able to add more points to the star
        //triangles are numbered clockwise starting from 12:00
        triangle(x, y, ratio + x, -ratio + y, x, y - radius);       //1
        triangle(x, y, ratio + x, ratio + y, x + radius, y);        //2
        triangle(x, y, ratio + x, -ratio + y, x + radius, y);       //3
        triangle(x, y, ratio + x, ratio + y, x, y + radius);        //4
        triangle(x, y, -ratio + x, ratio + y, x, y + radius);       //5
        triangle(x, y, -ratio + x, ratio + y, x - radius, y);       //6
        triangle(x, y, -ratio + x, -ratio + y, x - radius, y);      //7
        triangle(x, y, -ratio + x, -ratio + y, x, y - radius);      //8
    }

    //this constitutes the settings for the code
    public void settings() {
        size(1280, 720);
    }

    //this provides setup, extends settings
    public void setup() {

    }

    float radius = 140;
    float change = .5f;
    final int WHITE = 0xffffffff;
    final int RED = 0xffff0000;

    //this specifies the drawing
    public void draw() {
        background(0);
        float widthUnit = width / 4f;
        float heightUnit = height / 4f;
        drawStar(2 * widthUnit, 2 * heightUnit, 2 * radius, RED); //center, color: red
        drawStar(3 * widthUnit, 1 * heightUnit, radius, WHITE); //top right, color: white
        drawStar(3 * widthUnit, 3 * heightUnit, radius, WHITE); //bottom right, color: white
        drawStar(1 * widthUnit, 3 * heightUnit, radius, WHITE); //bottom left, color: white
        drawStar(1 * widthUnit, 1 * heightUnit, radius, WHITE); //top left, color: white
        change = (radius < 40 || radius > 140) ? -change : change;
        radius -= change;
    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]) {
        PApplet.main("Tasks.Task12");
    }
}