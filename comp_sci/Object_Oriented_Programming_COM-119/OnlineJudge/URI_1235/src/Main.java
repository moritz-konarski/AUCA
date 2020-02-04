import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        String correctedStr, part1, part2;
        char[] corrected, input;
        for (int i = 0; i < iterations; i++){
            input = scanner.nextLine().toCharArray();
            if (input.length == 0)
                input = scanner.nextLine().toCharArray();
            corrected = new char[input.length];
            for (int j = 0; j < input.length; j++){
                corrected[j] = input[input.length - 1 - j];
            }
            correctedStr = new String(corrected);
            part2 = correctedStr.substring(0, correctedStr.length() / 2);
            part1 = correctedStr.substring(correctedStr.length() / 2);
            System.out.println(part1 + part2);
        }
    }
}
