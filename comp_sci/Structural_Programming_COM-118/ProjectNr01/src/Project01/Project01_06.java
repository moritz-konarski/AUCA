/*This is a program that draws a flower shape by centering ellipses around a center and stretching them so they look like flower petals
 * They have a width of inner radius and a height of outer radius. There are x of them and they are spinning around. They are slightly translucent, so that the center
 * is opaque and the outer most petals are nearly translucent*/
package Project01;
import processing.core.PApplet;

public class Project01_06 extends PApplet {

    //constants
    final int N_PETALS = 60;                    //number of flower petals
    final int DIAMETER = 500;                   //diameter of the flower
    final int N_ELLIPSES = N_PETALS / 2;        //number of ellipses to make n flower petals    
    final int RED = 0xffff0000;                 //the color red
    final int ALPHA = 50;                       //the opacity of the ellipses
    final int[] POSITION = {0, 0};              //the position of the flower, relative to the center of the screen
    final float RATIO = 6f;                     //the ration between the outer diameter and the inner diameter
    final float PETAL_ANGLE = TWO_PI / N_ELLIPSES; //the angle between each consecutive ellipse
    final float ANGULAR_VELOCITY = .03f;        //the speed of rotation
    //variables
    float[] angle = {0};                        //the angle of rotation of the flower
    
    //a method that draws a flower which spins
    public void drawFlower(int numberOfEllipses, int[] POSITION, int diameter, float ratio, int color) {
        translate(width / 2 + POSITION[0], height / 2 + POSITION[1]);//translating to the position
        float smallDiameter = diameter / ratio;             //calculating the central diameter of the ellipses
        noStroke();                                         //disabling the outline
        fill(color, ALPHA);                                 //filling the ellipses with color, some translucency
        rotate(angle[0]);                                   //rotating the whole flower by its rotational angle
        for (int i = 0; i < numberOfEllipses; i++) {
            rotate(PETAL_ANGLE);                            //rotating each flower petal
            ellipse(0, 0, smallDiameter, diameter);    //drawing an ellipse
        }
        //incrementing the angle or resetting it to zero after one rotation
        angle[0] = (angle[0] < TWO_PI) ? angle[0] + ANGULAR_VELOCITY : 0;
    }

    public void settings() {
        size(1280, 720);
    }

    public void setup() {

    }

    public void draw() {
        background(0);
        drawFlower(N_ELLIPSES, POSITION, DIAMETER, RATIO, RED);
    }

    public static void main(String[] args) {
        PApplet.main("Project01.Project01_06");
    }

}
