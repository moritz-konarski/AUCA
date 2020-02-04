import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static boolean isLeapYear(int year){             //this method return the absolute value of the argument
        return !(year % 4 != 0 || (year % 4 == 0 && year % 100 == 0 && year % 400 != 0));  //according to the algorithm on wikipedia
    }

    public static int getDaysOfMonth(int year, int month){  //return the number of days for each month, return -1 of error
        //                   Ja  Fe  Ma  Ap  Ma  Jn  Jl  Au  Se  Oc  No  De
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        daysInMonth[1] = (isLeapYear(year)) ? 29 : 28;
        if (month > 12 || month < 1){
            throw new IllegalArgumentException("Index out of range");
        }
        else {
            return daysInMonth[month - 1];
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int year = 0;
        int month = 0;

        while (true) {
            try {
                System.out.print("Month: ");
                if (!scanner.hasNextInt()){
                    break;
                }
                month = scanner.nextInt();

                System.out.print("Year: ");
                if (!scanner.hasNextInt()){
                    break;
                }
                year = scanner.nextInt();

                System.out.printf("Days: %d%n", getDaysOfMonth(year, month));
            }
            catch (InputMismatchException e){
                System.err.println("Incorrect Inputs, must be Integers");
                break;
            }
            catch (IllegalArgumentException e){
                System.err.println("Incorrect Month Number, must be between 1 and 12");
                break;
            }
        }
    }
}