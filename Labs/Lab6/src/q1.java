class Logger{
    private String[] logs;
    private int size = 0;
    private static Logger logger;

    private Logger(){
        this.logs = new String[100];
    }

    public static Logger getInstance(){
        if(logger == null) return new Logger();
        return logger;
    }

    public void addLogLine(String logLine){
        // adds a line to the log array
        if(size + 1< 100) logs[size++] = logLine;
    }
    public void readLog(){
        // prints the log line by line
        for(var line: logs){
            if(line != null) System.out.println("LOGGER: "+ line);
        }
    }
}