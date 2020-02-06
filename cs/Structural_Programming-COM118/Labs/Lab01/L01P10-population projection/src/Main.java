//a program that computes the approximate population of the US based on original pop; and birth, death and immigration per second
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

        //printing the header of the table
        System.out.println("\nA projection of the US population for the next five years:");     //introductory sentence
        System.out.println("YEAR | POPULATION  | TOTAL GROWTH");                      //header of the table

        //using a loop to print each of the five years of the projection
        for ( int year = 0; year < 6; year++)
        {
            //calculating the difference vs the first year, simply the product of year and change per year
            double deltaPop = deltaPopPerYear * year;
            //adding the change per year to the population to increase it by the correct amount
            population += deltaPopPerYear;
            /*the double values for population are converted to integers before being displayed because x.7 humans do not exist
            * this acts as a floor function because the conversion from double to int 'deletes' the decimal places*/
            System.out.println(year + "    | " + String.format("%,d", (int)population) + " | " + String.format("%,d", (int)deltaPop));
        }
    }
}
