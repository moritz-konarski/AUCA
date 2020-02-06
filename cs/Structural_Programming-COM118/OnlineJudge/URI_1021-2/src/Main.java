import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double value = scanner.nextDouble();
        int valueInt = (int)(value * 100);
        int[][] array = new int[][]{
                {10000,0},
                {5000,0},
                {2000,0},
                {1000,0},
                {500,0},
                {200,0},
                {100,0},
                {50,0},
                {25,0},
                {10,0},
                {5,0},
                {1,0},};
        System.out.println("NOTAS:");
        for (int i = 0; i <= array.length; i++)
        {
            array[i][1] = valueInt / array[i][0];
            valueInt -= array[i][1] * array[1][0];
            if (array[i][0] < 200) {break;}
        }
        for (int i = 0; i <= array.length; i++)
        {
            array[i][1] = valueInt / array[i][0];
            valueInt -= array[i][1] * array[1][0];
            if (array[i][0] < 200) {break;}
        }
/*
        int rial = (int)value;
        int rialCent = (int)((value - rial)*100);

System.out.printf("%d nota(s) de R$ %d,00\n", array[i][1], array[i][0]/100);
            else if (array[i][0] == 100){
                System.out.printf("%d nota(s) de R$ %d,00\n", array[i][1], array[i][0]/100);}
            }



        int n_100 = rial / 100;
        rial = rial - n_100 *100;
        int n_50 = rial / 50;
        rial = rial - n_50 *50;
        int n_20 = rial / 20;
        rial = rial - n_20 *20;
        int n_10 = rial / 10;
        rial = rial - n_10 *10;
        int n_5 = rial / 5;
        rial = rial - n_5 *5;
        int n_2 = rial / 2;
        rial = rial - n_2 *2;
        int n_1 = rial;

        int n_050 = rialCent / 50;
        rialCent = rialCent - n_050 *50;
        int n_025 = rialCent / 25;
        rialCent = rialCent - n_025 *25;
        int n_010 = rialCent / 10;
        rialCent = rialCent - n_010 *10;
        int n_005 = rialCent / 5;
        rialCent = rialCent - n_005 *5;
        int n_001 = rialCent;


        System.out.println("NOTAS:");
        System.out.printf("%d nota(s) de R$ 100,00\n", n_100);
        System.out.printf("%d nota(s) de R$ 50,00\n", n_50);
        System.out.printf("%d nota(s) de R$ 20,00\n", n_20);
        System.out.printf("%d nota(s) de R$ 10,00\n", n_10);
        System.out.printf("%d nota(s) de R$ 5,00\n", n_5);
        System.out.printf("%d nota(s) de R$ 2,00\n", n_2);
        System.out.println("MOEDAS:");
        System.out.printf("%d moeda(s) de R$ 1,00\n", n_1);
        System.out.printf("%d moeda(s) de R$ 0,50\n", n_050);
        System.out.printf("%d moeda(s) de R$ 0,25\n", n_025);
        System.out.printf("%d moeda(s) de R$ 0,10\n", n_010);
        System.out.printf("%d moeda(s) de R$ 0,05\n", n_005);
        System.out.printf("%d moeda(s) de R$ 0,01\n", n_001);*/
    }
}
//a program that shows the number of bank notes and coins that make up a sum of money