import java.time.LocalTime;
import java.time.LocalDateTime;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.time.LocalDate;

class Commands {

    public static String date() {
        return LocalDate.now().toString();
    }

    public static String time() {
        return LocalTime.now().toString();
    }

    public static String datetime() {
        return LocalDateTime.now().toString();
    }

    public static String useraccount() {
        return System.getProperty("user.name");
    }

    public static String userhome() {
        return System.getProperty("user.home");
    }

    public static String os() {
        return System.getProperty("os.name") +" "+ "("+ System.getProperty("os.version")+")" ;
    }

    public static String printenv(CommandLine cmdLine) {
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

    public static String echo(CommandLine cmdLine) {
        return cmdLine.hasArgument() ? cmdLine.getCommandArgument() : "";
    }

    public static String ls(CommandLine cmdLine) {
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

    public static String cat(CommandLine cmdLine) {
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