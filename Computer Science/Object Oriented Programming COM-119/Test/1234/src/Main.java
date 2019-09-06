import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        char currentLetter;
        char[] output;
        int j;
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            output = new char[input.length()];
            j = 0;
            for (int i = 0; i < input.length(); i++) {
                currentLetter = input.charAt(i);
                if (Character.isLetter(currentLetter)) {
                    output[i] = (j % 2 == 0) ? Character.toUpperCase(currentLetter) : Character.toLowerCase(currentLetter);
                } else {
                    output[i] = currentLetter;
                    j++;
                }
                j++;
            }
            System.out.println(new String(output));
        }
    }
}