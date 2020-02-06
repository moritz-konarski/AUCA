import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt(), students, nSessions, nAbsences;
        String[] studentNames, attendences;
        String attendanceRecord, output;
        for (int i = 0; i < iterations; i++) {
            students = scanner.nextInt();
            output = "";
            studentNames = new String[students];
            for (int j = 0; j < students; j++) {
                studentNames[j] = scanner.next();
            }
            for (int k = 0; k < students; k++) {
                nAbsences = 0;
                attendanceRecord = scanner.next();
                nSessions = attendanceRecord.length();
                attendences = attendanceRecord.split("");
                for (String session : attendences) {
                    if (session.equals("A"))
                        nAbsences++;
                    else if (session.equals("M"))
                        nSessions--;
                }
                if (4 * nAbsences > nSessions) {
                    output = output.concat(" " + studentNames[k]);
                }
            }
                System.out.println(output.trim());
        }
    }
}