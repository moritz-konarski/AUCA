/*A solar system in which two planets rotate around a sun. One of the planets has a moon, which rotates around it.*/

package Project01;
import processing.core.PApplet;
import java.util.Random;
public class Project01_08 extends PApplet {

    //constants
    final int N_OBJECTS = 5;                //number of objects (including the sun) max 11
    final int BORDER = 40;                  //minimum amount of space between planets
    final int YELLOW = 0xffffff00;          //the color yellow (only sun)
    final int GRAY = 0xff888888;            //the color gray (only moons)
    final int CYAN = 0xff00ffff;            //the color cyan
    final int VIOLET = 0xff8a2be2;          //the color violet
    final int RED = 0xffff0000;             //the color red
    final int BLUE = 0xff0000ff;            //the color blue
    final int GREEN = 0xff00ff00;           //the color green
    final int WHITE = 0xffffffff;           //the color white
    final int[] COLORS = {RED, BLUE, GREEN, CYAN, VIOLET}; // and array of the colors the planets can have
    //factor for the speed of all planets and moons, can be used to set animation speed
    final float VELOCITY_FACTOR = 0.4f;
    //variables
    int[] color = new int[N_OBJECTS];                   //the color of each planet (index of COLORS)
    float[] angle = new float[N_OBJECTS];               //angle of each planet has, relative to (0,0)
    float[] angularVelocity = new float[N_OBJECTS];     //angular velocity of planet-orbit
    float[] orbits = new float[N_OBJECTS];              //radius (orbit) of the planets
    float[] diameter = new float[N_OBJECTS];            //diameter of the planets
    float[] moonAngle = new float[N_OBJECTS];           //angle of the moon, relative to its planet
    float[] moonAngularVelocity = new float[N_OBJECTS]; //angular velocity of the moon
    float[] moonOrbits = new float[N_OBJECTS];          //the radius of the moons orbit
    float[] moonDiameter = new float[N_OBJECTS];        //the diameter of the moon
    float[][] positions = new float[N_OBJECTS][2];      //the positions of the planets
    float[][] moonPositions = new float[N_OBJECTS][2];  //the position of the moon relative to its planet
    boolean[] hasMoon = new boolean[N_OBJECTS];         //whether or not a planet has a moon

    /*This method draws the. The parameters for this were determined
    in the planetSetup function.*/
    public void drawPlanets(int N_OBJECTS) {
        translate(width / 2, height / 2);                         //translating to the middle of the screen
        for (int i = 0; i < N_OBJECTS; i++) {
            stroke(WHITE);                                              //setting line color to white
            strokeWeight(0.5f);                                         //line thickness to 0.5
            noFill();                                                   //disabling color fill
            ellipse(0, 0, 2 * orbits[i], 2 * orbits[i]);      //drawing a circle corresponding to the orbit of the planet
            noStroke();                                                 //disabling the line/circumference again

            if (i == 0) {                                               //if the planet is the sun
                fill(YELLOW);                                           //fill it with yellow
            } else {
                fill(COLORS[color[i]]);                                 //if not, fill it with a chosen random color
            }

            ellipse(positions[i][0], positions[i][1], diameter[i], diameter[i]);    //draw the actual planet

            if (hasMoon[i]) {                                                       //if the planet has a moon
                translate(positions[i][0], positions[i][1]);                        //translate to the position of the planet
                stroke(WHITE);                                                      //setting the line color to white
                strokeWeight(0.5f);                                                 //line thickness to .5
                noFill();                                                           //disabling color fill mode
                ellipse(0, 0, 2 * moonOrbits[i], 2 * moonOrbits[i]);     //drawing the orbit of the moon
                noStroke();                                                         //disabling line drawing
                fill(GRAY);                                                         //fill color = gray
                ellipse(moonPositions[i][0], moonPositions[i][1], moonDiameter[i], moonDiameter[i]);    //drawing the moon
                translate(-positions[i][0], -positions[i][1]);                      //translating to center again
            }
        }
    }

    //Moves the planetary bodies
    public void moveBodies(){
        for (int i = 0; i < N_OBJECTS; i++) {
            angle[i] = (angle[i] < TWO_PI) ? angle[i] + angularVelocity[i] : 0; //incrementing angle or resetting it
            positions[i][0] = orbits[i] * cos(angle[i]);                        //calculating x positon of the planet
            positions[i][1] = orbits[i] * sin(angle[i]);                        //calculating y position of the planets

            if (hasMoon[i]) {                                                   //if the planet has a moon
                moonAngle[i] = (moonAngle[i] < TWO_PI) ? moonAngle[i] + moonAngularVelocity[i] : 0; //increment the angle of the moon
                moonPositions[i][0] = moonOrbits[i] * cos(moonAngle[i]);        //calculate the x position
                moonPositions[i][1] = moonOrbits[i] * sin(moonAngle[i]);        //calculate the y position
            }
        }
    }

    /*This function initializes all the planets and gives them semi-random values for all of their attributes.*/
    public void planetSetup() {
        Random random = new Random();           //new random function
        diameter[0] = height / 8f;              //setting sun diameter to one eighth of the screen height
        orbits[0] = 0;                          //setting its orbit to 0
        float sumDiameters = 0;                 //initializing the sum of the planets diameters
        //calculating the space each planet can maximally have, if there is BORDER space between them
        final float SPACE_PER_PLANET = (((height - diameter[0]) / 2) - (N_OBJECTS * BORDER)) / (N_OBJECTS - 1);
        //calculating all initial orbits
        for (int i = 1; i < N_OBJECTS; i++) {
            diameter[i] = random(3f /13 * SPACE_PER_PLANET, SPACE_PER_PLANET); //calculating the diameter of the planets
            //if the diameter is larger than that of the sun, set it to 90%of that
            diameter[i] = (diameter[i] >= diameter[0]) ? diameter[0] * .90f : diameter[1];
            if (i == 1) {
                //for the first planet, calculate the orbit, because only this one depends on half of the sun's diameter
                orbits[i] = orbits[i - 1] + (diameter[i] + diameter[i - 1] / 2) / 2;
            } else {
                // calculate the other orbits, such that the planets touch
                orbits[i] = orbits[i - 1] + (diameter[i] + diameter[i - 1]) / 2;
            }
            sumDiameters += diameter[i];        //sum all of the orbits up
        }
        //calculate the additional radius that each orbit can receive
        float additionalOrbit = (height / 2f - diameter[0] / 2f - sumDiameters) / (N_OBJECTS - 1);
        //calculating all other parameters for all planets and moons
        for (int j = 1; j < N_OBJECTS; j++) {
            //add [.6 to one] additional orbit to each orbit
            orbits[j] += j * BORDER + random(0.6f, 1) * additionalOrbit;
            color[j] = random.nextInt(COLORS.length);               //set a random color
            hasMoon[j] = (random.nextInt(2) == 1);            //set randomly if planet has a moon
            angularVelocity[j] = VELOCITY_FACTOR * random(0.03f, 0.07f); //choose a semi random angular velocity
            angle[j] = TWO_PI * random.nextFloat();                 //set a random angle
            positions[j][0] = orbits[j] * cos(angle[j]);            //set a position x based on this angle
            positions[j][1] = orbits[j] * sin(angle[j]);            //set a position y based on this angle

            if (hasMoon[j]) {
                moonDiameter[j] = diameter[j] / 3f;                     //set moon diameter to one third of planet diameter
                moonOrbits[j] = diameter[j] / 2f + moonDiameter[j];     //set orbit to one moon diameter from planet
                //set angular velocity in the same range as the planets, only three time faster
                moonAngularVelocity[j] = 3 * VELOCITY_FACTOR * (0.03f + 0.04f * random.nextFloat());
                moonAngle[j] = TWO_PI * random.nextFloat();             //set a random angle
                moonPositions[j][0] = moonOrbits[j] * cos(angle[j]);    //set a x position for that angle
                moonPositions[j][1] = moonOrbits[j] * sin(angle[j]);    //set a y position for that angle
            }
        }
    }

    public void settings() {
        fullScreen();   //setting program to full screen
    }

    public void setup() {
        background(0);
        planetSetup();      //calling planetSetup
    }

    public void draw() {
        background(0);  //clearing the screen
        moveBodies();
        drawPlanets(N_OBJECTS);      //drawing the planets
    }

    public static void main(String[] args) {
        PApplet.main("Project01.Project01_08");
    }

}