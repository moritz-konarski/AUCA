package Tasks;

import processing.core.PApplet;

import javax.swing.*;

public class Task07 extends PApplet{                        //uses the library we just imported

    int x1 =0, y1 = 20;
    int x2 =0, y2 = 670;
    String firstName = "";
    String lastName = "";
    int textWid1;
    int textWid2;
    //this constitutes the settings for the code
    public void settings(){
        size(1280, 720);                                       //sets the program to full screen mode
    }

    //this provides setup, extends settings
    public void setup(){
        background(13);
        fill(255, 0 , 0);
        textAlign(CENTER,CENTER);
        firstName = JOptionPane.showInputDialog("Please enter your first name here");
        textSize(50);
        textWid1 = (int)textWidth(firstName)/2;
        x1 = -textWid1;
        lastName = JOptionPane.showInputDialog("Please enter your last name here");
        textWid2 = (int)textWidth(lastName)/2;
        x2 = width + textWid2;
    }

    //this specifies the drawing
    public void draw(){
        background(13);

        text(firstName, x1, y1);
        text(lastName, x2, y2);

        x1 += 8;
        x2 -= 8;

        if (x1 - textWid1 > 1280){
            x1 = -textWid1;
            y1 += 50;
        }
        if (y1 > 700){
            y1 = 20;
        }
        if (x2 + textWid2 < 0){
            x2 = 1280 + textWid2;
            y2 -= 50;
        }
        if (y2 < 20){
            y2 = 670;
        }
    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]){
        PApplet.main("Tasks.Task07");}
}