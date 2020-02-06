import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String input = scanner.nextLine();
        input = input.replaceAll("(^(OB[^I]))(OB[^I])(^(OB[^I]))", "$1OBI$3");
        input = input.replaceAll("(^(UR[^I]))(UR[^I])(^(UR[^I]))", "$1URI$3");
        System.out.println(input);
    }
}
