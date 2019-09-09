import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nAttendees, doubleTickets, ticket;
        ArrayList<Integer> tickets, doneTickets;
        while (scanner.nextInt() != 0 && (nAttendees = scanner.nextInt()) != 0) {
            doubleTickets = 0;
            tickets = new ArrayList<>();
            doneTickets = new ArrayList<>();
            for (int i = 0; i < nAttendees; i++) {
                ticket = scanner.nextInt();
                if (tickets.contains(ticket) && !doneTickets.contains(ticket)) {
                    doubleTickets++;
                    doneTickets.add(ticket);
                } else {
                    tickets.add(ticket);
                }
            }
            System.out.println(doubleTickets);
        }
    }
}
