class CommandLine {
    private String commandName;
    private String commandArgument;

    public CommandLine(String commandLine) {
        String[] parts = commandLine.split(" ", 2);
        this.commandName = parts[0];
        this.commandArgument = (parts.length > 1) ? parts[1] : null;
    }

    public String getCommandName() {
        return this.commandName;
    }

    public String getCommandArgument() {
        return this.commandArgument;
    }

    public boolean hasArgument() {
        return this.commandArgument != null;
    }
}
