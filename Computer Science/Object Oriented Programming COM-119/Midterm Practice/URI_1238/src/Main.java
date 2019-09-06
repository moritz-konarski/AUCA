import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iteration = scanner.nextInt();
        String a, b;
        char[] result;
        for (int i = 0; i < iteration; i++) {
            a = scanner.next();
            b = scanner.next();
            result = new char[a.length() + b.length()];
            for (int ca = 0, cb = 0; ca + cb < a.length() + b.length(); ) {
                if (ca < a.length()) {
                    result[ca + cb] = a.charAt(ca);
                    ca++;
                }
                if (cb < b.length()) {
                    result[ca + cb] = b.charAt(cb);
                    cb++;
                }
            }
            System.out.println(new String(result));
        }
    }
}
