import processing.core.PApplet;                             //this imports the libraries
import javax.swing.*;
import java.util.Random;

public class Main extends PApplet{                        //uses the library we just imported

    int limit = 0;
    int x, y, eDimension;
    Random random = new Random();
    //this constitutes the settings for the code
    public void settings(){
        size(1280, 720);                                       //sets the program to full screen mode
    }

    //this provides setup, extends settings
    public void setup(){
        background(10);
        limit = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of circles"));
        noStroke();
        for (int i = 0; i < limit; i++){
            x = random.nextInt(width);
            y = random.nextInt(height);
            eDimension = random.nextInt(100);
            fill(random.nextInt(255),random.nextInt(255),random.nextInt(255));
            ellipse(x, y, eDimension, eDimension);
        }
    }

    //this specifies the drawing
    public void draw(){

    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]){
        PApplet.main("Main");}
}