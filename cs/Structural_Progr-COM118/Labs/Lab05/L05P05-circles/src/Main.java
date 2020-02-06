import processing.core.PApplet;                             //this imports the libraries
import javax.swing.*;

public class Main extends PApplet{                        //uses the library we just imported

    int limit = 0;
    int x, eDimension;

    //this constitutes the settings for the code
    public void settings(){
        size(1280, 720);                                       //sets the program to full screen mode
    }

    //this provides setup, extends settings
    public void setup(){
        background(10);
        limit = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of circles"));
        stroke(100,50);
        for (int i = 0; i < limit; i++){
            x = i * 255 / limit;
            eDimension = (limit - i) * height / limit;
            fill(255, 0,0 , x);
            ellipse(width/2,height/2,eDimension,eDimension);
        }
    }

    //this specifies the drawing
    public void draw(){

    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]){
        PApplet.main("Main");}
}