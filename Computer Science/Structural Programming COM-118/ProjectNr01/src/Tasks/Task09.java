package Tasks;

import processing.core.PApplet;                             //this imports the libraries
import javax.swing.*;

public class Task09 extends PApplet{                        //uses the library we just imported

    //this constitutes the settings for the code
    public void settings(){
        size(1280, 720);                                       //sets the program to full screen mode
    }

    //this provides setup, extends settings
    public void setup(){
        background(10);
        final int DIAMETER = Math.min(width, height);
        int x, eDimension;
        int posY = height/2, posX = width/2;
        int limit = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of circles"));
        int stepOver = DIAMETER / limit;
//        stroke(100,50);
        noStroke();
        for (int i = 0; i < limit; i++){
            x = i * 80 / limit;
            eDimension = (limit - i) * stepOver;
            fill(255, 0,0 , x);
            ellipse(posX,posY, eDimension, eDimension);
        }
    }

    //this specifies the drawing
    public void draw(){

    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]){
        PApplet.main("Tasks.Task09");}
}