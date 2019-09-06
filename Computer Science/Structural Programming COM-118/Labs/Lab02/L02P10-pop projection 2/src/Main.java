//a program that computes the approximate population of the US based on original pop, and on birth, death and immigration per second
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        //initializing variables
        double population = 312032486.0;                                                        //pop of the US
        int secsPerYear = 365*24*3600;                                                          //number of seconds in one year
        double deathPerSec = -1.0/13;                                                           //deaths per sec
        double birthPerSec = 1.0/7;                                                             //births per sec
        double immigrantPerSec = 1.0/45;                                                        //immigrants pre sec
        double deltaPopPerYear = secsPerYear * (deathPerSec + birthPerSec + immigrantPerSec);   //change in population per year
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        population += deltaPopPerYear * years;
        System.out.printf("The population in %d years is " + String.format("%,.0f", population) , years);
    }
}
