import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> qToCountMap;
        int n, k, count, input;
        while ((n = scanner.nextInt()) != 0 && (k = scanner.nextInt()) != 0) {
            qToCountMap = new HashMap<>();
            count = 0;
            for (int i = 0; i < n; i++) {
                input = scanner.nextInt();
                if (qToCountMap.containsKey(input)) {
                    qToCountMap.replace(input, qToCountMap.get(input) + 1);
                } else {
                    qToCountMap.put(input, 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : qToCountMap.entrySet()) {
                if (entry.getValue() >= k) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
