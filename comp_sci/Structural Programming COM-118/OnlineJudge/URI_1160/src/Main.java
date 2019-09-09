import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int NUMBER = scanner.nextInt();
        for (int i = 0; i < NUMBER; i++){
            int PA = scanner.nextInt();
            int PB = scanner.nextInt();
            int PPA = PA;
            int PPB = PB;
            double GA = scanner.nextDouble() / 100;
            double GB = scanner.nextDouble() / 100;
//            double time = Math.log((double)PA / PB) / Math.log((1 + GB) / (1 + GA));
            int time = 0;
            while (true) {
                PPA = (int)(PPA * (1 + GA));
                PPB = (int)(PPB * (1 + GB));
                time++;
                if (PPA > PPB || time > 100){break;}
            }
            if (time > 100){
                System.out.println("Mais de 1 seculo.");
            }
            else{
                System.out.printf("%d anos.%n", time);
            }
        }

    }

}
