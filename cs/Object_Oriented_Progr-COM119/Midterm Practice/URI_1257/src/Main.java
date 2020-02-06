import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), lines, value;
        char[] line;
        for (int i = 0; i < iterations; i++){
            value = 0;
            lines = scanner.nextInt();
            for (int k = 0; k < lines; k++){
                line = scanner.next().toCharArray();
                for (int j = 0; j < line.length; j++){
                    value += (line[j] - 'A') + k + j;
                }
            }
            System.out.println(value);
        }
    }
}
