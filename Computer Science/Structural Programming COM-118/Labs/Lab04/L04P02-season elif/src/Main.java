import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Month: ");
        int month = scanner.nextInt();
        if (month > 12 || month < 1){
            System.err.println("Invalid Month.");
        }
        else if (month == 12 || month <= 2){
            System.out.println("Winter");
        }
        else if (month <= 5){
            System.out.println("Spring");
        }
        else if (month <= 8){
            System.out.println("Summer");
        }
        else {
            System.out.println("Autumn");
        }
    }
}
