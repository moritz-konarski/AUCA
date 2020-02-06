import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

// ONLY WORKS IN JAVA 8

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        scanner.nextLine();
        boolean cheater;
        String breakfast, lunch;
        String[] elements;
        for (int i = 0; i < iterations; i++) {
            cheater = false;
            ArrayList<String> diet = new ArrayList<>(Arrays.asList(scanner.nextLine().split("")));
            Collections.sort(diet);
            breakfast = scanner.nextLine().trim();
            lunch = scanner.nextLine().trim();
            elements = (breakfast + lunch).split("");
            if (elements[0].matches("\\w+")) {
                for (String element : elements) {
                    if (diet.contains(element))
                        diet.remove(element);
                    else {
                        System.out.println("CHEATER");
                        cheater = true;
                        break;
                    }
                }
                if (!cheater) {
                    diet.forEach(System.out::print);
                    System.out.println();
                }
            } else{
                diet.forEach(System.out::print);
                System.out.println();
            }
        }
    }
}
