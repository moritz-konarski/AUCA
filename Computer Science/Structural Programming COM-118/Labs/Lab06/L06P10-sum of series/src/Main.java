public class Main {

    public static double series(int i){
        double seriesSum = 0;
        for (int j = 1; j <= i; j++){
            seriesSum += (double) j / (j + 1);
        }
        return seriesSum;
    }

    public static void main(String[] args){
        int testNumber = 20;
        System.out.printf("i%15s%n", "series(i)");
        for (int i = 1; i <= testNumber; i++){
            System.out.printf("%d\t%10.4f%n", i, series(i));
        }
    }
}
