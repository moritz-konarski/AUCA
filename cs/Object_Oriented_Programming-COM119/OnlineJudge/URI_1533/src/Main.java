import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int suspects, suspicion;
        ArrayList<Integer> suspicionLevels;
        HashMap<Integer, Integer> suspectMap;
        while((suspects = scanner.nextInt()) > 0) {
            suspicionLevels = new ArrayList<>();
            suspectMap = new HashMap<>();
            for (int i = 1; i <= suspects; i++){
                suspicion = scanner.nextInt();
                suspicionLevels.add(suspicion);
                suspectMap.put(suspicion, i);
            }
            Collections.sort(suspicionLevels);
            Collections.reverse(suspicionLevels);
            System.out.println(suspectMap.get(suspicionLevels.get(1)));
        }
    }
}
