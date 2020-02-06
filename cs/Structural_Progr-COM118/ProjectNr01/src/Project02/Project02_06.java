/*This program looks like an old Windows screen saver*/
package Project02;
import processing.core.PApplet;
import javax.swing.*;
import java.util.Random;

public class Project02_06 extends PApplet {

    //constants
    final int COLOR = 0xffff0000;       //color of the lines
    final int DISTANCE = 16;            //the distance between angles of the same order
    final int VELOCITY_RANGE = 5;       //possible velocities, from - V_R to +V_R
    //variables
    int nAngles;                        //number of angles per sequence
    int nSequences;                     //number of sequences
    int[] displacement;                 //distance between the angles of different sequences
    float[][][] positions;              //positions of the angles (points)
    float[][][] velocities;             //velocities of the angles (points)

    public void drawSequence(){
        stroke(COLOR);                              //setting line color
        strokeWeight(2);                            //setting line thickness
        for (int i = 0; i < nSequences; i++){
            for (int j = 0; j < nAngles - 1; j++){
                //connecting each angle with the next one
                line(positions[i][j][0], positions[i][j][1], positions[i][j + 1][0], positions[i][j + 1][1]);
            }
            //connecting the last and the first angle, to form closed shape
            line(positions[i][0][0], positions[i][0][1], positions[i][nAngles - 1][0], positions[i][nAngles - 1][1]);
        }
    }

    public void moveSequence(){
        for (int j = 0; j < nAngles; j++){
            for (int i = 0; i < nSequences; i++){
                positions[i][j][0] += velocities[i][j][0];                  //incrementing x position
                positions[i][j][1] += velocities[i][j][1];                  //incrementing y position
                //checking if pattern hits x bounds
                if (positions[i][j][0] < 0) {                               //if it hits left
                    positions[i][j][0] += -2 * positions[i][j][0];          //simulate bounce-off
                    velocities[i][j][0] = -velocities[i][j][0];             //reverse velocity
                } else if (positions[i][j][0] > width) {                    //if hits right
                    positions[i][j][0] -= 2 * (positions[i][j][0] - width); //simulate bounce-off
                    velocities[i][j][0] = -velocities[i][j][0];             //reverse velocity
                }
                //checking if pattern hits y bounds
                if (positions[i][j][1] < 0) {                               //if hits top
                    positions[i][j][1] += -2 * positions[i][j][1];          //simulate bounce-off
                    velocities[i][j][1] = -velocities[i][j][1];             //reverse velocity
                } else if (positions[i][j][1] > height) {                   //if hits bottom
                    positions[i][j][1] -= 2 * (positions[i][j][1] - height);//simulate bounce-off
                    velocities[i][j][1] = -velocities[i][j][1];             //reverse velocity
                }
            }
        }
    }

    public void sequenceSetup(){
        Random random = new Random();
        //get user input
        nAngles = Integer.parseInt(JOptionPane.showInputDialog("Number of Angles: "));
        nSequences = Integer.parseInt(JOptionPane.showInputDialog("Number of Sequences: "));
        //initialize arrays
        positions = new float[nSequences][nAngles][2];
        velocities = new float[nSequences][nAngles][2];
        displacement = new int[2];
        for (int j = 0; j < nAngles; j++){
            displacement[0] = random.nextInt(DISTANCE + 1);       //getting a random displacement in x direction
            displacement[1] = DISTANCE - displacement[0];               //getting displ. in y as difference
            //getting random position for angles
            positions[0][j][0] = random((nSequences + 1) * displacement[0], //x
                    width - (nSequences + 1) * displacement[0]);
            positions[0][j][1] = random((nSequences + 1) * displacement[1], //y
                    height - (nSequences + 1) * displacement[1]);
            //getting random velocities for angles
            velocities[0][j][0] = 1 + random(-VELOCITY_RANGE, VELOCITY_RANGE);  //x
            velocities[0][j][1] = 1 + random(-VELOCITY_RANGE, VELOCITY_RANGE);  //y
            for (int i = 1; i < nSequences; i++) {
                //passing positons to all angles in the same set, plus offset
                positions[i][j][0] = positions[i - 1][j][0] + displacement[0];  //x
                positions[i][j][1] = positions[i - 1][j][1] + displacement[1];  //y
                //passing velocities to all angles that are in the same set
                velocities[i][j][0] = velocities[0][j][0];  //x
                velocities[i][j][1] = velocities[0][j][1];  //y
            }
        }
    }

    public void settings(){
        size(1280,720);
        sequenceSetup();                //setting up the arrays
    }

    public void setup(){
        background(0);
    }

    public void draw(){
        background(0);
        moveSequence();     //moving the angles, thus the sequences
        drawSequence();     //drawing the sequences
    }

    public static void main(String[] args){
        PApplet.main("Project02.Project02_06");
    }

}