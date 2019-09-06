/*A chess board pattern of red and blue squares that asks the user for the input of the side length.
 *The square is centered and the top left square is red.
 * */
package Project01;
import processing.core.PApplet;

import javax.swing.*;

public class Project01_09 extends PApplet {

    //constants
    final int RED = 0xffff0000;         //the color red
    final int BLUE = 0xff0000ff;        //the color blue
    final int[] COLOR = {RED, BLUE};    //and array containing the colors of the pattern
    //variables
    int squaresPerSide = 0;              //the number of squares per side

    public void drawPattern(int squaresPerSide) {
        //length of side of small square, offset by .5 side length in each direction
        final int SIDE_LENGTH = height / (squaresPerSide + 1);
        final int X_OFFSET = (width - squaresPerSide * SIDE_LENGTH) / 2;  //calculating the x offset for the big square
        noStroke();                                                         //disabling the outline of the squares
        translate(X_OFFSET, SIDE_LENGTH/2);             //translating the top left corner of the square to its position
        for (int i = 0; i < squaresPerSide; i++){
            for (int j = 0; j < squaresPerSide; j++){
                fill(COLOR[(j + i) % COLOR.length]);              //selecting the color of the small square
                rect(j * SIDE_LENGTH, i * SIDE_LENGTH, SIDE_LENGTH, SIDE_LENGTH);   //creating the square
            }
        }
    }

    public void settings() {
        size(1280, 720);                                 //setting window size
        //getting the number of squares per side
        squaresPerSide = Integer.parseInt(JOptionPane.showInputDialog("Squares per Side: "));   
    }

    public void setup() {
        background(0);              //setting the background to black
        drawPattern(squaresPerSide);    //calling the function
    }

    public void draw() {

    }

    public static void main(String[] args) {
        PApplet.main("Project01.Project01_09");
    }
}