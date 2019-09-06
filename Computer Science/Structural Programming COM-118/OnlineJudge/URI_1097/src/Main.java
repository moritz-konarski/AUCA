public class Main {
    public static void main(String[] args) {
        int I;
        int J;
        int n = 0;

        for (I = 1; I < 10; I += 2){
            for (J = 7 + n; J > 4 + n; J--){
                System.out.printf("I=%d J=%d\n", I , J);
            }
            n += 2;
        }

    }
}
