import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("1st number ");
        int number1 = scanner.nextInt();
        System.out.print("2nd number ");
        int number2 = scanner.nextInt();
        if (number1 > number2) {
            System.out.printf("The first number (%d) is greater than the second one (%d).", number1, number2);
        }
        else {
            System.out.printf("The second number (%d) is greater than or equal to the first one (%d).", number2, number1);
        }
    }
}
