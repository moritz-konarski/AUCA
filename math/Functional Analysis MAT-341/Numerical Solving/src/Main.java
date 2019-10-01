public class Main {
    public static void main(String args[]) {
        double result = 2;
        for (int i = 1; i <= 100000; i++) {
            result = Math.tan(result - Math.PI);
        }
        System.out.println(result);
    }
}
