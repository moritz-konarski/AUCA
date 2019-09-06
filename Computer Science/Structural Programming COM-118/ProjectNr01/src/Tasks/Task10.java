package Tasks;

import processing.core.PApplet;                             //this imports the libraries

public class Task10 extends PApplet{                        //uses the library we just imported

    float i = 0;
    float x = 0;
    //this constitutes the settings for the code
    public void settings(){
        size(1280, 720);                                       //sets the program to full screen mode
    }

    //this provides setup, extends settings
    public void setup(){
        background(0);
        noStroke();
        fill(200);
        translate(500,10);  //this statement moves EVERYTHING that comes after it by the specified amount in the braces
        rotate(PI/3);       //this function rotates EVERYTHING by the specified amount around its own center, mathematically negative
        rectMode(CENTER);         //this makes the coordinates of the rectangle centered around the actual center
        rect(0,0,100,100);
        ellipse(30,30,100,100);
    }

    //this specifies the drawing
    public void draw(){
        background(0);
        noStroke();
        fill(200);
        translate(50,10);  //this statement moves EVERYTHING that comes after it by the specified amount in the braces
        rotate(i);       //this function rotates EVERYTHING by the specified amount around its own center, mathematically negative
        rectMode(CENTER);         //this makes the coordinates of the rectangle centered around the actual center
        rect(0,0,100,100);
        ellipse(30,30,100,100);
        i += .2;
    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]){
        PApplet.main("Tasks.Task10");}
}