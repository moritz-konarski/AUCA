/*This program draws a bunch of squares similar to number 9, but this time the square rotate and they move
 * around. They bounce off of walls. Also, they have shadows, which come from multiple squares behind each one
 * that spin with a certain offset. It looks like they have traces.*/

package Project01;
import processing.core.PApplet;
import javax.swing.*;

public class Project01_10 extends PApplet {
    //constants
    final int WHITE = 0xffffffff;           //the color red
    final int BLACK = 0xff000000;           //the color black
    final int N_SHADOW_SQUARES = 30;        //number of squares making up the shadow
    final float MOVEMENT = 1f;              //shift in x and y between each square
    final float ROTATION = 6;               //factor (as 1/ROTATION) for the angle between each square
    final float ANGLE_OFFSET = 0.0065f;     //offset of the angle for each row and col of the squares
    final float ANGLE_INCREMENT = 0.09f;    //increment of all angles each draw loop
    final float DIAGONAL_FACTOR = 0.8f;     //how much the diagonal of the square is reduced vs max
    final int[] VELOCITY = {4, 4};          //the velocity of the whole pattern
    //variables
    int diagonal;                           //diagonal of the small squares
    int sideLength;                         //side length of the small squares
    int deltaAlpha;                         //alpha difference between each shadow square and the next
    int squaresPerSide;                     //the number of squares per side of the pattern
    float deltaAngle;                       //the difference in angle between each layer of shadow squares
    int[][] velocity = new int[N_SHADOW_SQUARES][2];    //velocity of each layer of shadow squares
    int[][] position = new int[N_SHADOW_SQUARES][2];    //position of each layer of shadow squares
    float[][] angle = new float[N_SHADOW_SQUARES][N_SHADOW_SQUARES];    //angle of each shadow square

    //method that draws the squares
    public void drawPattern() {
        rectMode(CENTER);                                               //rectangle mode set to center
        noStroke();                                                     //disable outline
        for (int k = 0; k < position.length; k++) {
            translate(position[k][0], position[k][1]);                  //translate to the top left corner, reference point
            translate(diagonal / 2, diagonal / 2);                 //translate to the center of the first square
            for (int i = 0; i < squaresPerSide; i++) {
                for (int j = 0; j < squaresPerSide; j++) {
                    translate(i * diagonal, j * diagonal);         //translate to the appropriate place for square
                    rotate(k * deltaAngle + angle[k][i]);          //rotate by specific angle
                    fill(BLACK);                                         //fill with black
                    rect(0, 0, sideLength, sideLength);            //draw one black square as background
                    fill(WHITE, deltaAlpha * k);                   //fill with white and appropriate alpha
                    rect(0, 0, sideLength, sideLength);            //draw a white square
                    rotate(-k * deltaAngle - angle[k][i]);         //rotate back to original angle (0)
                    translate(-i * diagonal, -j * diagonal);        //translate back to middle of first square
                }
            }
            translate(-diagonal / 2, -diagonal / 2);                //translate back to the top left corner of the screen
            translate(-position[k][0], -position[k][1]);                  // (reference point)
        }
    }

    public void moveSquares() {
        for (int i = 0; i < position.length; i++) {
            position[i][0] += velocity[i][0];                       //incrementing position by velocity
            position[i][1] += velocity[i][1];                       //incrementing position by velocity
            //checking if pattern hits x bounds
            if (position[i][0] < 0) {
                position[i][0] += -2 * position[i][0];              //simulate bounce-off
                velocity[i][0] = -velocity[i][0];                   //reverse velocity
            } else if (position[i][0] > width - squaresPerSide * diagonal) {
                position[i][0] -= 2 * (position[i][0] + squaresPerSide * diagonal - width); //simulate bounce-off
                velocity[i][0] = -velocity[i][0];                   //reverse velocity
            }
            //checking if pattern hits y bounds
            if (position[i][1] < 0) {
                position[i][1] += -2 * position[i][1];              //simulate bounce-off
                velocity[i][1] = -velocity[i][1];                   //reverse velocity
            } else if (position[i][1] > height - squaresPerSide * diagonal) {
                position[i][1] -= 2 * (position[i][1] + squaresPerSide * diagonal - height);    //simulate bounce-off
                velocity[i][1] = -velocity[i][1];                   //reverse velocity
            }
            for (int k = 0; k < N_SHADOW_SQUARES; k++) {
                angle[i][k] += ANGLE_INCREMENT;                     //increment angle by increment
            }
        }
    }

    //method that sets up the pattern
    public void setupSquares() {
        //getting the number of squares per side
        squaresPerSide = Integer.parseInt(JOptionPane.showInputDialog("Square per Side: "));
        diagonal = height / (2 * squaresPerSide);                    //calculating the diagonal of the squares
        sideLength = (int) (DIAGONAL_FACTOR * Math.sqrt(Math.pow(diagonal, 2) / 2));    //calculating the side length from the diagonal
        deltaAlpha = 255 / N_SHADOW_SQUARES;                        //calculating the shift in alpha value for each shadow square
        deltaAngle = TWO_PI / (ROTATION * N_SHADOW_SQUARES);        //calculating the rotation for each shadow square
        for (int j = 0; j < N_SHADOW_SQUARES; j++) {
            velocity[j][0] = VELOCITY[0];                           //setting all velocities to the same values
            velocity[j][1] = VELOCITY[1];                           //
            for (int k = 0; k < N_SHADOW_SQUARES; k++) {
                angle[j][k] = 0.03f + j * k * ANGLE_OFFSET;  //setting the angle; OFFSET to make the angle change over the square
            }
        }
        for (int i = 0; i < N_SHADOW_SQUARES; i++) {                //filling position with default values
            //offsetting each layer of shadow squares by MOVEMENT in the direction of the velocity
            position[i][0] = (int) ((width - squaresPerSide * diagonal) / 2f + i * MOVEMENT * velocity[i][0] / Math.abs(velocity[i][0]));
            position[i][1] = (int) (squaresPerSide * diagonal / 2f + i * MOVEMENT * velocity[i][1] / Math.abs(velocity[i][1]));
        }
    }

    public void settings() {
        size(1280, 720);    //setting window size
        setupSquares();                 //setup the pattern
    }

    public void setup() {
        background(0);
    }

    public void draw() {
        background(0);      //reset the background
        moveSquares();          //move the pattern
        drawPattern();          //draw the pattern
    }

    public static void main(String[] args) {
        PApplet.main("Project01.Project01_10");
    }
}