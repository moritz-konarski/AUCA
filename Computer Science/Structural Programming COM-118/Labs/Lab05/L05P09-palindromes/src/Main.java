import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a word to be checked: ");
        String word = scanner.next();
        String palindrome = "";
        for (int i = word.length() - 1; i >= 0; i--){
            palindrome = palindrome + word.charAt(i);       //just iterating charAt from both ends would be more efficient
        }
        if (word.equalsIgnoreCase(palindrome)){
            System.out.printf("%s is a palindrome", word);
        }
        else {
            System.out.printf("%s is not a palindrome", word);
        }
    }
}
