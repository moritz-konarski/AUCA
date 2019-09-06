public class Main {
    
    public static double series(int n, int m){
        //the first element is n, the last is m
        //the series starts at i = 1, not i = 0
        double sum = 0;
        for (int i = n; i <= m; i++){
            sum += (1 + 2 * (i - 1))/(Math.pow(2, i - 1));
        }
        return sum;
    }
    
    public static void main(String[] args){
        System.out.printf("%.2f%n", series(1, 20));
    }
}
