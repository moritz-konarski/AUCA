//a program that asks for two integers and then adds, subtracts, multiplies, divides and mod() them
package com.company;
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner line_scan = new Scanner(System.in); //creating a new scanner

        System.out.print("Enter integer one: ");     //asking for the first integer

        int int1 = line_scan.nextInt();             //reading the input for int1

        System.out.print("Enter integer two: ");     //asking for the second integer

        int int2 = line_scan.nextInt();             //reading the input for int2

        //addition
        System.out.println(int1 + " + " + int2 + " = " + (int1 + int2));
        //subtraction
        System.out.println(int1 + " - " + int2 + " = " + (int1 - int2));
        //multiplication
        System.out.println(int1 + " * " + int2 + " = " + (int1 * int2));
        //division
        System.out.println(int1 + " / " + int2 + " = " + (int1 / int2));
        //modulo
        System.out.println(int1 + " % " + int2 + " = " + (int1 % int2));
    }
}
