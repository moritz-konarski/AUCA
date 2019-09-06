package Tasks;

import processing.core.PApplet;

import javax.swing.*;

public class Task05 extends PApplet{                        //uses the library we just imported

    //this constitutes the settings for the code
    public void settings(){
        size(1280, 720);                                       //sets the program to full screen mode
    }

    //this provides setup, extends settings
    public void setup(){
        int number1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the first integer"));
        int number2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the second integer"));
        int result = number1 + number2;
        fill(255, 0 , 0);
        textAlign(CENTER,CENTER);
        textSize(50);
        String resultString = number1 + " + " + number2 + " = " + result;
        // String resultString = String.format("%d + %d = %d", number1, number2, result);
        text(resultString, width/2, height/2);

    }

    //this specifies the drawing
    public void draw(){

    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]){
        PApplet.main("Tasks.Task05");}
}