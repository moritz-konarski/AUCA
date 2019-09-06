import java.util.Scanner;
import java.util.Random;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] hand = new String[]{"scissor", "rock", "paper"};       //creating a string array to make the message for the user comvenient to code
        int computer = random.nextInt(4);                         //generating the random number that the computer will play, it is generated before user input, so there is no cheating ;)
        System.out.print("scissor (0), rock (1), paper (2): ");         //asking the user what he wants to play
        int player = scanner.nextInt();                                 //taking the user input
        if (player > 2 || player < 0){System.err.println("Please enter a correst number."); System.exit(-1);} //if the number the user entered is not correct, the program will stop
        else{                                                                                                       //this is to prevent index out of range errors with the array of 'hands'
            System.out.printf("The computer is %s. You are %s", hand[computer], hand[player]);          //if the number is ok, print the first part of the user message, it is found in all the outputs
        }
        if (computer == player){
            System.out.println(" too. It is a draw.");                  //conditional output in case of a draw
        }
        else if (computer > player || (computer == 0 && player == 2)){  //conditonal output in case of a computer win
            System.out.println(". You lost.");
        }
        else {                                                          //if it is neither a draw nor a loss, the player won
            System.out.println(". You won.");
        }
    }
}
//a program plays rock paper scissors