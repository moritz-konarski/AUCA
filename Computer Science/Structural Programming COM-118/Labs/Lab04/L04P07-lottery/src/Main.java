import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int winningNumber = random.nextInt(1000);
        int[] winningNumberDigits = {winningNumber/100, (winningNumber%100)/10, winningNumber%10};
        System.out.print("Enter your lottery number (3 digits): ");
        int userNumber = scanner.nextInt();
        userNumber = userNumber % 1000;
        int[] userNumberDigits = {userNumber/100, (userNumber%100)/10, userNumber%10};
        int correctDigits = 0;
        if (winningNumber == userNumber){
            System.out.println("Congratulations! Your number is correct. You win $10,000.");
        }
        else {
            for (int i = 0; i < winningNumberDigits.length; i++) {
                for (int j = 0; j < winningNumberDigits.length; j++){
                    if (winningNumberDigits[i] == userNumberDigits[j]) {
                        correctDigits++;
                    }
                }
            }
            if (correctDigits == 3){
                System.out.println("Congratulations! The digits of your number match the digits of the winning number. You win $3,000.");
            }
            else if (correctDigits == 1 || correctDigits == 2){
                System.out.println("Congratulations! One digit of your number matches one digit of the winning number. You win $1,000.");
            }
            else{
                System.out.println("Sorry, you did not win. Try again.");
            }
        }
    }
}
