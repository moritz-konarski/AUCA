package Tasks;

import processing.core.PApplet;

public class Task11 extends PApplet{

    float angle = 0;
    float eAngle = 0.01f;
    float mAngle = 12 * eAngle;
    final float angularVelocity = 0.01f;
    final int S_DIAMETER = 250;
    final int S_COLOR = 0xffffff00; //yellow
    final int E_ORBIT = 250;
    final int E_DIAMETER = 80;
    final int E_COLOR = 0xff0000ff; //blue
    final int M_ORBIT = 65;
    final int M_DIAMETER = 25;
    final int M_COLOR = 0xff666666; //gray


    //this constitutes the settings for the code
    public void settings(){
        size(1280, 720);
    }

    //this provides setup, extends settings
    public void setup(){

    }

    //this specifies the drawing
    public void draw(){
        //preparation
        translate(width/2,height/2);
        background(0);
        noStroke();
        mAngle = 12 * eAngle;

        //sun
        fill(S_COLOR);
        ellipse(0, 0, S_DIAMETER, S_DIAMETER);

        //earth
        translate(-E_ORBIT * sin(eAngle), E_ORBIT * cos(eAngle));
        fill(E_COLOR);
        ellipse(0, 0, E_DIAMETER, E_DIAMETER);

        //moon
        translate(M_ORBIT * sin(mAngle), M_ORBIT * cos(mAngle));
        fill(M_COLOR);
        ellipse(0, 0, M_DIAMETER, M_DIAMETER);

        eAngle += angularVelocity;
        //the movement can also be done with rotate() instead of sin() and cos()
    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]){
        PApplet.main("Tasks.Task11");}
}