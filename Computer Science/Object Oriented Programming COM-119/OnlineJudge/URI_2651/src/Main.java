import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next().trim();
        if (name.toLowerCase().matches(".*zelda.*"))
            System.out.println("Link Bolado");
        else
            System.out.println("Link Tranquilo");
    }
}
