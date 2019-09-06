//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(isr);
//        int iterations = Integer.parseInt(br.readLine());
//        for (int i = 0; i < iterations; ++i) {
//            String input = br.readLine();
//            String[] nums = input.split(" ");
//            if (nums[0].endsWith(nums[1])) {
//                System.out.println("encaixa");
//            } else {
//                System.out.println("nao encaixa");
//            }
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int input = Integer.parseInt(br.readLine());
        for (int i = 0; i < input; ++i) {
            String num1 = br.readLine();
            String num2 = br.readLine();
            if (num2.length() > num1.length()) {
                String temp = num1;
                num1 = num2;
                num2 = temp;
            }
            String[] strings = num1.split(num2);
            for (String elements : strings) {
                if (elements.length() < num1.length()) {
                    System.out.println("encaixa");
                } else {
                    System.out.println("nao encaixa");
                }
            }
        }
    }
}