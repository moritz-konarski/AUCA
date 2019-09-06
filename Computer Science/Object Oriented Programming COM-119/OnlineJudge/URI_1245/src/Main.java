import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bootPairCount, bootSize, n;
        int[][] sizeAndCount;
        String leftOrRightFoot;
        final String RIGHT = "D";
        final int SHOE_SIZE_OFFSET = 30;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            bootPairCount = 0;
            sizeAndCount = new int[31][2];
            for (int i = 0; i < n; i++) {
                bootSize = scanner.nextInt();
                leftOrRightFoot = scanner.next();
                sizeAndCount[bootSize - SHOE_SIZE_OFFSET][(leftOrRightFoot.equals(RIGHT)) ? 0 : 1]++;
            }
            for (int[] shoes : sizeAndCount) {
                bootPairCount += (shoes[0] > shoes[1]) ? shoes[1] : shoes[0];
            }
            System.out.println(bootPairCount);
        }
    }
}