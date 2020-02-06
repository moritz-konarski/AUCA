//a program that takes user input (a name) and then greets the user with it
package com.company;
import java.util.Scanner;                                         //importing the utility that provides the scanner
public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);		        //creating a new scanner for system input

        System.out.print("What is your name? ");	        //printing the question

        String userName = scan.nextLine();			        //scanning the input and saving the result to a string

        System.out.println("Hello, " + userName + "!");	    //printing the answer with a greeting
    }
}
