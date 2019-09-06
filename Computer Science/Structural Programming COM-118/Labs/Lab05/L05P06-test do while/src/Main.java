import java.util.Scanner;
//a program that sums up integers until zero is entered and uses a do-while loop
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int input = 0;
        do {
            System.out.print("Enter an integer (0 to stop the program): ");
            input = scanner.nextInt();
            sum += input;
        }while (input != 0);
        System.out.println("The sum is " + sum);
    }
}
