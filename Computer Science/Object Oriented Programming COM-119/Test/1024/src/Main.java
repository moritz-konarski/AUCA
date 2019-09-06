import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfTests = sc.nextInt(), condition, shift, offset;
        String input;
        char[] encodedText, plainText;
        for (int j = 0; j < numOfTests; j++) {
            if ((input = sc.nextLine()).equals(""))
                input = sc.nextLine();
            plainText = input.toCharArray();
            encodedText = new char[input.length()];
            condition = (int) Math.ceil(input.length() / 2.0);  //is-half-reached condition
            offset = input.length() - 1;                        //the index-offset as a variable
            for (int i = 0; i < offset + 1; i++) {
                shift = (i < condition) ? 2 : 3;                //the inner if-statement
                shift = (Character.isLetter(plainText[i])) ? shift : shift - 3;  //the outer if-statement
                encodedText[offset - i] = (char) ((int) plainText[i] + shift);
            }
            System.out.println(new String(encodedText));        //shorter version to print char[]
        }
    }
}