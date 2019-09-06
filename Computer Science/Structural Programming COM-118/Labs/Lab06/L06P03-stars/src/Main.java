import processing.core.PApplet;

public class Main extends PApplet{

    public void drawStar(float x, float y, float radius, int color){
        //the color should be entered as a hex number in rgb format with the first two places being alpha values
        strokeWeight(4);
        strokeCap(ROUND);
        stroke(color);
        strokeJoin(ROUND);
        noFill();
        float ratio = radius / 4;   //the ratio or radii of the outer corner to the inner corner of the start, pointiness
        //triangles are numbered clockwise starting from 12:00
        triangle(x ,y, ratio + x, -ratio + y, x, y - radius);       //1
        triangle(x ,y, ratio + x, ratio + y, x + radius, y);        //2
        triangle(x ,y, ratio + x, -ratio + y, x + radius, y);       //3
        triangle(x ,y, ratio + x, ratio + y, x, y + radius);        //4
        triangle(x ,y, -ratio + x, ratio + y, x, y + radius);       //5
        triangle(x ,y, -ratio + x, ratio + y, x - radius, y);       //6
        triangle(x ,y, -ratio + x, -ratio + y, x - radius, y);      //7
        triangle(x ,y, -ratio + x, -ratio + y, x, y - radius);      //8
    }

    //this constitutes the settings for the code
    public void settings(){
        size(1280, 720);
    }

    //this provides setup, extends settings
    public void setup(){
        background(0);
        float widthUnit = width / 4f;
        float heightUnit = height / 4f;
        int radius = 120;
        drawStar(2 * widthUnit,2 * heightUnit,2 * radius,0xffff0000); //center, color: red
        drawStar(3 * widthUnit,1 * heightUnit,radius,0xffffffff); //top right, color: white
        drawStar(3 * widthUnit,3 * heightUnit,radius,0xffffffff); //bottom right, color: white
        drawStar(1 * widthUnit,3 * heightUnit,radius,0xffffffff); //bottom left, color: white
        drawStar(1 * widthUnit,1 * heightUnit,radius,0xffffffff); //top left, color: white
    }

    //this specifies the drawing
    public void draw(){

    }

    //the main part of the program, that actually runs the code
    public static void main(String args[]){
        PApplet.main("Main");}
}