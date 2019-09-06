import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Month: ");
        int month = scanner.nextInt();
        int days = 29;

        if (year % 4 != 0 || (year % 4 == 0 && year % 100 == 0 && year % 400 != 0)) {
            days = 28;
        }

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
        }

        if (month < 1 || month > 12) {
            System.err.println("Invalid Month Number.");
        }
        else{
            System.out.println("Number of days: " + days);
        }
    }
}
