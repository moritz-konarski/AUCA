package Tasks;

import processing.core.PApplet;

import javax.swing.*;

public class Task06 extends PApplet{                        //uses the library we just imported

    int x =0, y=20;
    String name = "";
    int textWid;
    //this constitutes the settings for the code
    public void settings(){
        size(1280, 720);                                       //sets the program to full screen mode
    }

    //this provides setup, extends settings
    public void setup(){
        background(13);
        fill(255, 0 , 0);
        textAlign(CENTER,CENTER);
        name = JOptionPane.showInputDialog("Please enter your name here");
        textSize(50);
        textWid = (int)textWidth(name)/2;
        x = -textWid;
    }

    //this specifies the drawing
    public void draw(){
        background(13);
        text(name, x, y);
        x += 8;
        if (x - textWid > 1280){
            x = -textWid;
            y += 50;
        }
        if (y > 700){
            y = 20;
        }
    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]){
        PApplet.main("Tasks.Task06");}
}