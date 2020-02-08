public class Main {
    public static void main(String args[]) {
        double a, b, x = 10;
        a = (1 - Math.pow(Math.E, 2*x)) / x;
        System.out.printf("formula: %f\n", a);
        b = 0;
        for (int i = 1; i < 65; ++i) {
            b -= Math.pow(2, i) / factorial(i) * Math.pow(x, i - 1);
            System.out.println(i + "  " + factorial(i));
        }
        System.out.printf("series:  %f\n", b);
    }

    static float factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}

