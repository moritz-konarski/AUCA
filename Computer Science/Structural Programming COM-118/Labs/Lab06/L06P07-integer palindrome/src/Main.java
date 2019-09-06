import java.util.Scanner;
public class Main {

    public static int reverse(int number){
        int palindrome = 0;
        int length = (int)(Math.log10(number) + 1);
        for (int i = 1; i <= length; i++){
            palindrome += (number % 10) * Math.pow(10, length - i);
            number /= 10;
        }
        return palindrome;
    }

    public static boolean isPalindrome(int number){
        return reverse(number) == number;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        int number = scanner.nextInt();
        String response = (isPalindrome(number)) ? "is a palindrome" : "is not a palindrome";
        System.out.printf("%d %s", number, response);
    }
}
