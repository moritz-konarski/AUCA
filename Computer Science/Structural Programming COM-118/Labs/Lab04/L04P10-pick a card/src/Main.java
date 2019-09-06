import java.util.Random;
public class Main {
    public static void main(String[] args){
        Random rand = new Random();
        String[] colorArray = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] rankArray = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int color = rand.nextInt(4);
        int number = rand.nextInt(13);
        System.out.printf("You picked the %s of %s\n", rankArray[number], colorArray[color]);
    }
}
