import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input;
        int totalWordLenght, numberOfWords, averageLenght, difficulty;
        while(scanner.hasNext()){
            numberOfWords = totalWordLenght = 0;
            input = scanner.nextLine().trim().split(" ");
            for (String symbol:input){
                if (symbol.matches("[a-zA-Z]+")){
                    numberOfWords++;
                    totalWordLenght += symbol.length();
                } else if (symbol.matches("[a-zA-Z]+\\.")){
                    numberOfWords++;
                    totalWordLenght += symbol.length() - 1;
                }
            }
            if (numberOfWords == 0)
                difficulty = 250;
            else {
                averageLenght = totalWordLenght / numberOfWords;
                if (averageLenght <= 3)
                    difficulty = 250;
                else if (averageLenght <= 5)
                    difficulty = 500;
                else
                    difficulty = 1000;
            }
            System.out.println(difficulty);
        }
    }
}
