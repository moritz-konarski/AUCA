import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Year: ");
        int year = scanner.nextInt();

        if (year % 4 != 0 || (year % 4 == 0 && year % 100 == 0 && year % 400 != 0)) {//according to the algorithm on wikipedia
            System.out.println("This is not a leap year.");
        }
        else {
            System.out.println("This is a leap year.");
        }
    }
}
