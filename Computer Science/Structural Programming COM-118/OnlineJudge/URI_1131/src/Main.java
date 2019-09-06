import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int goalsInter = 0;
        int goalsGrenal = 0;
        int grenais = 0;
        int winsInter = 0;
        int winsGrenal = 0;
        boolean run = true;
        int X = 0;

        while (run) {
            goalsGrenal = goalsInter = 0;
            grenais++;
            goalsInter = scanner.nextInt();
            goalsGrenal = scanner.nextInt();

            if (goalsInter > goalsGrenal){
                winsInter++;
            }
            else if (goalsInter < goalsGrenal){
                winsGrenal++;
            }

            while (true){
                System.out.println("Novo grenal (1-sim 2-nao)");
                X = scanner.nextInt();
                if (X == 1){
                    break;
                }
                else if (X == 2){
                    run = false;
                    break;
                }
            }
        }
        System.out.printf("%d grenais%nInter:%d%nGremio:%d%nEmpates:%d%n", grenais, winsInter, winsGrenal, grenais - (winsGrenal + winsInter));
        if (winsGrenal > winsInter){
            System.out.println("Grenal venceu mais");
        }
        else if (winsGrenal < winsInter){
            System.out.println("Inter venceu mais");
        }
        else {
            System.out.println("Não houve vencedor");
        }
    }
}
