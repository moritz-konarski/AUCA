import java.util.Random;
import java.util.Scanner;
public class Main {

    public static String[] drawCards(int numberOfCards){ //return strings that tells you what cards is drawn
        Random random = new Random();
        String[] cardArray = new String[numberOfCards];
        String[] suitArray = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] rankArray = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        final int NUMBER_OF_CARDS = 52;
        final int CARDS_PER_SUIT = NUMBER_OF_CARDS / 4;
        int card;
        for (int i = 0; i < numberOfCards; i++) {
            card = random.nextInt(NUMBER_OF_CARDS);
            cardArray[i] = String.format("The card %2d is the %s of %s.", card + 1, rankArray[card % CARDS_PER_SUIT], suitArray[card / CARDS_PER_SUIT]);
        }
        return cardArray;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many cards? ");
        final int NUMBER_OF_CARDS = scanner.nextInt();

        String[] cards = drawCards(NUMBER_OF_CARDS);

        for (String card: cards) {
            System.out.println(card);
        }
    }
}