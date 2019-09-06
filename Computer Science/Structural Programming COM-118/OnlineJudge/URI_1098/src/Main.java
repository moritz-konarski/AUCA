public class Main {
    public static void main(String args[]){
        double J, I = 0;
        for (double n = 0; n < 2; n += .2){
            for (int m = 1; m < 4; m++){
                J = m + n;
                I = n;
                if ((10 * I) % 10 == 0 || (10 * J) % 10 == 0){
                    System.out.printf("I=%d J=%d\n", Math.round(I), Math.round(J));
                }
                else {
                    System.out.printf("I=%.1f J=%.1f\n", I, J);
                }
            }
        }
    }
}
//recreating a pattern given in uri