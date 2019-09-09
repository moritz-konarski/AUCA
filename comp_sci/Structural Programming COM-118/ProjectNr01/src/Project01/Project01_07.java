/*This program draws regular star polygons. The user enters N and M in the settings phase. N is the number of points/vertices.
 * M is the number of times the connected lines wrap around the polygon before returning to the initial vertex.
 * Or it is the number of points that lie between the initial vertex and the vertex it is connected to by a line.
 * The number of points does not include the initial vertex, so its basically the number of steps that nees to be
 * taken to get there.*/
package Project01;
import processing.core.PApplet;
import javax.swing.*;

public class Project01_07 extends PApplet {

    //constants
    final int RADIUS = 250;                 //radius of the polygon
    final int COLOR = 0xffff0000;           //color of the lines (red)
    final float ANGULAR_VELOCITY = 0.02f;   //speed of rotation
    //variables
    int m = 0;                              //number of steps between connected points
    int n = 0;                              //number of points/vertices
    float[] angle = {0};                    //angle of rotation

    public void drawPolygon(int n, int m, int radius, int color) {
        translate(width / 2, height / 2);      //translating to the middle of the screen
        final float DELTA_ANGLE = TWO_PI / n;       //the difference in angle from one point to the next
        float x1, y1, x2, y2;                       //the variables
        stroke(color);                              //setting line color
        strokeWeight(4);                            //setting line thickness
        rotate(angle[0]);                           //rotating the star
        //incrementing the angle, or setting it back to 0 after one rotation
        angle[0] = (angle[0] < TWO_PI) ? angle[0] + ANGULAR_VELOCITY : 0;
        for (int i = 0; i < n; i++) {
            x1 = radius * sin(i * DELTA_ANGLE);         //x and y of first point
            y1 = radius * cos(i * DELTA_ANGLE);         //
            x2 = radius * sin((i + m) * DELTA_ANGLE);   //x and y of second point, m points further away
            y2 = radius * cos((i + m) * DELTA_ANGLE);   //
            line(x1, y1, x2, y2);                             //drawing the line between the two points
        }
    }

    public void settings() {
        size(1280, 720);                            //setting screen size
        n = Integer.parseInt(JOptionPane.showInputDialog("N:"));//getting n
        m = Integer.parseInt(JOptionPane.showInputDialog("M:"));//getting m
    }

    public void setup() {
        background(0);      //setting background to black
    }

    public void draw() {
        background(0);                   //setting background to black
        drawPolygon(n, m, RADIUS, COLOR);    //calling the function
    }

    public static void main(String[] args) {
        PApplet.main("Project01.Project01_07");
    }

}
