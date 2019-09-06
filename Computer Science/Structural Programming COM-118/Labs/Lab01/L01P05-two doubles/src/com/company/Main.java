//a program that asks for two doubles and performs mathematical operations with them
package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args)
    {
        Scanner lineScan = new Scanner(System.in);          //creating a new scanner

        System.out.print("Enter double one:");        //asking for the first Double

        double double1 = lineScan.nextDouble();             //reading the input for double1

        System.out.print("Enter double two:");        //asking for the second Double

        double double2 = lineScan.nextDouble();             //reading the input for double2

        //addition
        System.out.println(double1 + " + " + double2 + " = " + (double1 + double2));
        //subtraction
        System.out.println(double1 + " - " + double2 + " = " + (double1 - double2));
        //multiplication
        System.out.println(double1 + " * " + double2 + " = " + (double1 * double2));
        //division
        System.out.println(double1 + " / " + double2 + " = " + (double1 / double2));
        //modulo
        System.out.println(double1 + " % " + double2 + " = " + (double1 % double2));
    }
}
