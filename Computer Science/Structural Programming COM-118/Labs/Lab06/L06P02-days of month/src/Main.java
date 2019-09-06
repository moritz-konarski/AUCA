import java.util.Scanner;
public class Main {

    public static boolean isLeapYear(int year){   //this method return the absolute value of the argument
        return !(year % 4 != 0 || (year % 4 == 0 && year % 100 == 0 && year % 400 != 0));  //according to the algorithm on wikipedia
    }

    public static int getDaysOfMonth(int year, int month){//return the number of days for each month, return -1 of error
        int days = 0;
        switch (month){
            case 2: days = isLeapYear(year) ? 29 : 28; break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: days = 31; break;
            case 4:
            case 6:
            case 9:
            case 11: days = 30; break;
            default: days = -1;             // in case of error is returns -1
        }
        return days;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the year: ");
        int year = scanner.nextInt();
                   System.out.print("Please enter the month: ");
        int month = scanner.nextInt();

        if (getDaysOfMonth(year, month) > 0){
            System.out.printf("The month number %d has %d days.", month, getDaysOfMonth(year, month));
        }
        else {
            System.err.println("The month number is not correct. Please enter a correct number.");
            System.exit(-1);
        }

    }
}
