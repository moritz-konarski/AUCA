import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numberMax = 0;
        System.out.print("1st number ");
        int number1 = scanner.nextInt();
        System.out.print("2nd number ");
        int number2 = scanner.nextInt();
        System.out.print("3rd number ");
        int number3 = scanner.nextInt();
        numberMax = number1;
        if (number2 > numberMax) {
            numberMax = number2;
        }
        if (number3 > numberMax) {
            numberMax = number3;
        }
        System.out.printf("The value %d is the greatest one.", numberMax);
    }
}
