import java.time.LocalTime;
import java.time.LocalDateTime;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.time.LocalDate;

class Commands {

    public static String execute(CommandLine cmdLine) {
        switch (cmdLine.getCommandName()) {
            case "date":
                return LocalDate.now().toString();
            case "time":
                return LocalTime.now().toString();
            case "datetime":
                return LocalDateTime.now().toString();
            case "useraccount":
                return System.getProperty("user.name");
            case "userhome":
                return System.getProperty("user.home");
            case "os":
                return System.getProperty("os.name") +" "+ "("+ System.getProperty("os.version")+")" ;
            case "printenv":
                return printEnv(cmdLine);
            case "echo":
            case "print":
                return cmdLine.hasArgument() ? cmdLine.getCommandArgument() : "";
            case "ls":
                return listDirectory(cmdLine);
            case "cat":
                return catFile(cmdLine);
            default:
                return "Command '" + cmdLine.getCommandName() + "' not found.";
        }
    }

    private static String printEnv(CommandLine cmdLine) {
        if (cmdLine.hasArgument()) {   
            String envValue = System.getenv(cmdLine.getCommandArgument()); 
            return envValue != null ? envValue : ""; 
        } else { 
            StringBuilder sb = new StringBuilder();
            
            for (String env : System.getenv().keySet()) {
             sb.append(env).append("=").append(System.getenv(env)).append(System.lineSeparator());
             
            } 
            return sb.toString();                   
        }
    }

    private static String listDirectory(CommandLine cmdLine) {
        if (cmdLine.hasArgument()) {
                File dir = new File(cmdLine.getCommandArgument());
            
            if (dir.isDirectory()) {
               StringBuilder ds = new StringBuilder();
    
                for (File file : dir.listFiles()) {
                    ds.append(file.getName()).append(System.lineSeparator());
                    
                }
                return ds.toString();
            } 
        }
        
        return "Not a directory";
    }

 private static String catFile(CommandLine cmdLine) {
         if (!cmdLine.hasArgument()) {
             return "Please specify a path to a text file to read";
         } else {
             try {
                 List<String> lines = Files.readAllLines(Paths.get(cmdLine.getCommandArgument()));
                 StringBuilder sb = new StringBuilder();
                 int lineNumber = 1;

                 for (String line : lines) {
                     sb.append(lineNumber++).append(". ").append(line).append(System.lineSeparator());
                 }

                 return sb.toString();
             } catch (Exception e) {
                 return "Error reading file";
             }
         }
     }
}
