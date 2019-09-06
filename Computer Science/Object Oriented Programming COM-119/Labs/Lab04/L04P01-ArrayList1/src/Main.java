import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> intList = new ArrayList<>();
        while (scanner.hasNext()){
            intList.add(scanner.nextInt());
        }
        System.out.println("Before reversing:");
        intList.forEach((n) -> System.out.print(n + " "));
        System.out.println();
        //Collections.reverse(intList);
        reverse(intList);
        System.out.println("After reversing:");
        intList.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }

    private static void reverse(ArrayList<Integer> list) {
        int temp, size = list.size();
        for (int i = 0; i < size / 2; i++) {
            temp = list.get(i);
            list.set(i, list.get(size - 1 - i));
            list.set(size - 1 - i, temp);
        }
    }
}
