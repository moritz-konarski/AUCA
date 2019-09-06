import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        int sum = 0;
        StringBuilder output = new StringBuilder();
        String part = "";

        while (true){
            m = scanner.nextInt();
            n = scanner.nextInt();
            if (m < 1 || n < 1){break;}
            output = new StringBuilder("");
            sum = 0;
            if (n < m){
                int temp = m;
                m = n;
                n = temp;
            }
            for (int i = m; i <= n; i++){
                part = i + " ";
                output.append(part);
                sum += i;
            }
            part = "Sum=" + sum;
            output.append(part);
            System.out.println(output);
        }

    }
}
