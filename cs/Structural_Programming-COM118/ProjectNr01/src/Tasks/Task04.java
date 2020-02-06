package Tasks;

import processing.core.PApplet;

import javax.swing.*;

public class Task04 extends PApplet{                        //uses the library we just imported

    //this constitutes the settings for the code
    public void settings(){
        size(1280, 720);                                       //sets the program to full screen mode
    }

    //this provides setup, extends settings
    public void setup(){
        String name = JOptionPane.showInputDialog("Please enter your name here");
        fill(255, 0 , 0);
        textAlign(CENTER,CENTER);
        textSize(50);
        text(name, width/2, height/2);

    }

    //this specifies the drawing
    public void draw(){

    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]){
        PApplet.main("Tasks.Task04");}
}