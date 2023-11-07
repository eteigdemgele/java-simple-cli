import java.util.Scanner;

public class Cli {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        System.out.print("> "); 

        while (true) { 
            String command = scanner.nextLine(); 
            CommandLine cmdLine = new CommandLine(command);
            String output = "";
            String cmdName = cmdLine.getCommandName();

            if (cmdName.equals("exit")  || cmdName.equals("logout")) {
                break; 
            } else if (cmdName.equals("date")) {
                output = Commands.date();
            } else if (cmdName.equals("time")) {
                output = Commands.time();
            } else if (cmdName.equals("datetime")) {
                output = Commands.datetime();
            } else if (cmdName.equals("useraccount")) {
                output = Commands.useraccount();
            } else if (cmdName.equals("userhome")) {
                output = Commands.userhome();
            } else if (cmdName.equals("os")) {
                output = Commands.os();
            } else if (cmdName.equals("printenv")) {
                output = Commands.printenv(cmdLine);
            } else if (cmdName.equals("echo") || cmdName.equals("print")) {
                output = Commands.echo(cmdLine);
            } else if (cmdName.equals("ls")) {
                output = Commands.ls(cmdLine);
            } else if (cmdName.equals("cat")) {
                output = Commands.cat(cmdLine);
            } else {
                output = "Command '" + cmdName + "' not found.";
            }

            System.out.println(output); 
			            
            System.out.print("> "); 
        }
        scanner.close();
        System.out.println("Bye!");
    }
}