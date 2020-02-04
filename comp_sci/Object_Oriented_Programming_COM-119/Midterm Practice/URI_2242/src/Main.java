import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next(), output = "S";
        input = input.replaceAll("[^aeiou]", "");
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)){
                output = "N";
                break;
            }
        }
        System.out.println(output);
    }
}
