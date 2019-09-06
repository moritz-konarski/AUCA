package Tasks;

import processing.core.PApplet;

public class Task01 extends PApplet{                      //uses the library we just imported

    //this constitutes the settings for the code
    public void settings(){
        fullScreen();                                   //sets the program to full screen mode
    }

    //this specifies the drawing
    public void draw(){
        fill(0,0,0,10);
        rect(0,0,width,height);
        fill(255, 0, 0);                                //specifiung the fill color of the next objects
        ellipse(mouseX, mouseY, 100, 100);        //you are given the current position of the mouse cursor
    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]){
        PApplet.main("Tasks.Task01");}
}
