import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input;
        while (scanner.hasNext()) {
            input = scanner.nextLine();
            input = input.replaceAll("([^_]*)(_)([^_]*)(_)([^_]*)", "$1<i>$3</i>$5");
            input = input.replaceAll("([^*]*)(\\*)([^*]*)(\\*)([^*]*)", "$1<b>$3</b>$5");
            System.out.println(input);
        }
    }
}
