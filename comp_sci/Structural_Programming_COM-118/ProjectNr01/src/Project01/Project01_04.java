/*
Two lines of text bobbing around from left to right, different colors. The text is entered through I/O dialogue
They hit the walls at the same time, but on opposite sides.
 */
package Project01;
import processing.core.PApplet;
import javax.swing.*;

public class Project01_04 extends PApplet {

    //constants
    final int VELOCITY_FACTOR = 4;      //the factor that is applied to all velocities, pretty arbitrary, but 3-5 is good
    final int RED = 0xffff0000;         //the color red
    final int GREEN = 0xff00ff00;       //the color green
    final int[] COLOR = {RED, GREEN};   //an array containing the colors of the strings, two because they alternate
    //variables
    int border;             //the size of the border all around the screen and between the lines of text
    int txtSize;            //the size of the text
    int movementRoom;       //minimum amount of space to one side the text needs to be able to move
    int numberOfStrings;    //the number of individual strings
    float[] xPosArray;      //arrays containing the x coordinates of all texts
    float[] velocityArray;  //array that contains all the velocities of the texts
    String[] stringArray;   //array that contains all strings

    //get the strings that will be displayed, depends on the number of strings
    public String[] getStrings(int numberOfStrings) {
        String[] stringArray = new String[numberOfStrings];
        for (int i = 0; i < numberOfStrings; i++) {                     //looping through all possible elements
            String message = String.format("Enter String %d:", i + 1);  //preparing a message for the user
            stringArray[i] = JOptionPane.showInputDialog(message);      //getting the string
        }
        return stringArray;                                             //returning the array
    }

    //a function containing the setup process for variables and arrays
    public void textSetup(String[] stringArray){
        movementRoom = width / 16;                                 //the amount of necessary room for the text to move
        //size of the border, area around the inside of the the window and between each line
        border = (int)((stringArray.length + 1) / 100f * height);
        txtSize = getTextSize(stringArray, border, movementRoom);  //calculating size optimal size of text
        //calculating velocity for texts to hit border at same time, for synchronization
        velocityArray = getVelocity(stringArray, txtSize, VELOCITY_FACTOR);
        xPosArray = new float[stringArray.length];              //initializing the positions-array for the number of strings
    }

    //find the optimal text size for the given texts, depends on the stringArray, border and movementRoom
    public int getTextSize(String[] stringArray, int border, int movementRoom) {
        //variables
        float[] stringLengthArray = new float[stringArray.length];                  //initializing a stringLength array
        //the largest text size based on screen height, borders, and number of strings
        int txtSize = (height - (stringArray.length + 1) * border) / stringArray.length;
        textSize(txtSize);                                                          //setting the text size
        for (int i = 0; i < stringArray.length; i++) {
            stringLengthArray[i] = textWidth(stringArray[i]);   //calculating the length of the strings, initial txtSize
        }
        for (int j = 0; j < stringArray.length; j++) {
            //as long as the text is too long and doesn't have space to move
            while (stringLengthArray[j] / 2 > width / 2 - (movementRoom + border)) {
                txtSize--;                                                          //decrement text size
                textSize(txtSize);                                                  //set new text size
                stringLengthArray[j] = textWidth(stringArray[j]);                   //calculate length again
            }
        }
        return txtSize;                                                             //return the final text size
    }

    //calculate velocities to hit walls at the same time, depends on stringArray, txtSize and VELOCITY_FACTOR
    public float[] getVelocity(String[] stringArray, int txtSize, int VELOCITY_FACTOR) {
        //veriables
        float[] velocityArray = new float[stringArray.length];      //array for velocities of the texts
        float[] distanceArray = new float[stringArray.length];      //array for distances the texts travel
        textSize(txtSize);                                          //set text size
        for (int i = 0; i < stringArray.length; i++) {
            //calculate the distance to one of the walls for each string/text
            distanceArray[i] = (width - textWidth(stringArray[i])) / 2 - border;
        }
        velocityArray[0] = VELOCITY_FACTOR;                     //setting the first velocity to the initial constant
        float time = distanceArray[0] / velocityArray[0];       //calculating the "time" it takes for the movement
        int k = 0;
        for (int j = 1; j < stringArray.length; j++) {
            k = (j % 2 != 0) ? -1 : 1;                          //alternating sign, to move in opposite directions
            //calculate different velocities based on a common time to hit walls at the same time
            velocityArray[j] = (k * distanceArray[j] / time);
        }
        return velocityArray;                                   //return the velocity array
    }

    //move the text based on the velocities of each text, depends on stringArray, xPosArray, velocityArray, txtSize,
    //border and COLOR
    public void drawMoveText(String[] stringArray, float[] xPosArray, float[] velocityArray, int txtSize, int border, int[] COLOR) {
        //the movement in y direction per line of text
        int yDisplacement = ((height - border * (stringArray.length + 1)) / (stringArray.length));
        textAlign(CENTER, CENTER);                     //x and y refer to the center of the text field
        textSize(txtSize);                             //setting the text size
        int j;                                     //variable used for alternating text colors
        //move the coordinate origin to the top center of the first text
        translate(width / 2, border + yDisplacement / 2);
        for (int i = 0; i < stringArray.length; i++) {
            j = (i % 2 == 0) ? 0 : 1;                   //getting alternating values for j
            fill(COLOR[j]);                             //these are used to color the text in alternating fashion
            text(stringArray[i], xPosArray[i], 0);   //writing the text at the specified place
            xPosArray[i] += velocityArray[i];           //moving the x position by the velocity
            //checking whether the text hits the border, if it does, reverse the velocity
            velocityArray[i] = (Math.abs(xPosArray[i]) + textWidth(stringArray[i]) / 2 > (width / 2 - border))
                                ? -velocityArray[i] : velocityArray[i];
            translate(0, yDisplacement + border);   //translate to the next place where text is, for next loop
        }
    }

    public void settings() {
        size(1280, 720);
        //getting the number of strings
        numberOfStrings = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of Strings:"));
        //getting the strings
        stringArray = getStrings(numberOfStrings);
    }

    public void setup() {
        background(0);              //setting a black background
        textSetup(stringArray);         //setting up variables and arrays
    }

    public void draw() {
        background(0);
        drawMoveText(stringArray, xPosArray, velocityArray, txtSize, border, COLOR);    //moving the text
    }

    public static void main(String args[]) {
        PApplet.main("Project01.Project01_04");
    }
}