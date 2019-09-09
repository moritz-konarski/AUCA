import java.util.Scanner;
public class Main {

    public static double[][] getDistances(double[][] points) {
        double[][] distances = new double[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                distances[i][j] = Math.sqrt(Math.pow(points[j][0] - points[i][0],2) +
                                            Math.pow(points[j][1] - points[i][1] ,2));
            }
        }
        return distances;
    }

    public static int[] getMinDistance(double[][] distances){
        double minDist = distances[0][1];
        int[] minIndex = {0, 0};
        for (int k = 0; k < distances.length; k++) {
            for (int j = k + 1; j < distances.length; j++) {
                if (distances[k][j] < minDist){
                    minDist = distances[k][j];
                    minIndex[0] = k;
                    minIndex[1] = j;
                }
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of points: ");
        int nPoints = scanner.nextInt();
        double[][] points = new double[nPoints][nPoints];
        System.out.printf("Please enter %d points: ", nPoints);

        for (int i = 0; i < points.length; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }

        double[][] distances = getDistances(points);

        int[] minIndex = getMinDistance(distances);

        System.out.printf("The closest two points are (%.1f, %.1f) and (%.1f, %.1f)%nThe distance is %.2f%n"
                , points[minIndex[0]][0], points[minIndex[0]][1], points[minIndex[1]][0], points[minIndex[1]][1], distances[minIndex[0]][minIndex[1]]);
    }
}
