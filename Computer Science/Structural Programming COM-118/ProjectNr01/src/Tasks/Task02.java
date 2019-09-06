package Tasks;

import processing.core.PApplet;

public class Task02 extends PApplet{                        //uses the library we just imported
    int shade = 0;
    boolean backgourndBool = true;
    int shadeDelta = 4;

    //this constitutes the settings for the code
    public void settings(){
        size(1280, 720);                                       //sets the program to full screen mode
    }

    //this provides setup, extends settings
    public void setup(){

    }

    //this specifies the drawing
    public void draw(){
        background(shade);              //[0...255]

        if (backgourndBool && shade < (256-shadeDelta)){
            shade += shadeDelta;}    //keeping it in the range that the function  background accepts
        else if (backgourndBool && shade >= (256-shadeDelta)) {// && x >= 255
            backgourndBool = false;
        }

        if (!backgourndBool && shade > shadeDelta){
            shade -= shadeDelta;
        }
        else if (!backgourndBool && shade <= shadeDelta){// && x <= 0
            backgourndBool = true;
        }
    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]){
        PApplet.main("Tasks.Task02");}
}