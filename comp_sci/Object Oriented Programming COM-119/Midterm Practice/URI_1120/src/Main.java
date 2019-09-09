import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String a, b;
        while (!((a = scanner.next()) + (b = scanner.next())).equals("00")){
            b = b.replace(a, "");
            b = b.replaceFirst("^0+", "");
            System.out.println((b.length() != 0) ? b : "0");
        }
    }
}
