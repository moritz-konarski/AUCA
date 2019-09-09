public class Main {

    public static double m(int i){
        double piEstimate = 0;
        for (int j = 1; j <= i; j++){
            piEstimate += Math.pow(-1, j + 1) / (2 * j - 1);
        }
        piEstimate *= 4;
        return piEstimate;
    }

    public static void main(String[] args){
        int testNumber = 1;
        System.out.printf("i%11s%n", "m(i)");
        for (int i = testNumber; i < 1000 * testNumber; i += 100){
            System.out.printf("%d\t%10.4f%n", i, m(i));
        }
    }
}
