import java.util.Scanner;

public class Cli {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        System.out.print("> "); 

        while (true) { 
            String command = scanner.nextLine(); 
            CommandLine cmdLine = new CommandLine(command);
            
            if (cmdLine.getCommandName().equals("exit")  || cmdLine.getCommandName().equals("logout")) {
                break; 
            } else {
                String output = Commands.execute(cmdLine);
                System.out.println(output); 
                System.out.print("> "); 
            }
        }
        scanner.close();
        System.out.println("Bye!");
    }
}

 

