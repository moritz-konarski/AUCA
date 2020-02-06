import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] commands;
        String commandString, lastCommand;
        int cycles, reads, processes;
        while (scanner.hasNext()){
            cycles = reads = 0;
            commandString = scanner.next();
            lastCommand = "";
            processes = scanner.nextInt();
            commands = commandString.split("");
            for (String command:commands){
                if (command.equals("W"))
                    cycles++;
                else if (command.equals("R")){
                    reads++;
                    if (reads >= processes || !lastCommand.equals(command)){
                        cycles++;
                        reads = 0;
                    }
                }
                lastCommand = command;
            }
            System.out.println(cycles);
        }
    }
}
