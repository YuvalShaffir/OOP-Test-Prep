import java.util.ArrayList;

class TimeUtils{
    public static String now(){
        return "2024-03-18 13:31";
    }
}

interface WriteAble{
    void write(String str);
}

class BlackBox implements WriteAble{

    public static BlackBox getBlackBox(){
        return new BlackBox();
    }

    public void write(String str){
        System.out.println("BlockBox output: " + str);
    }
}

class PilotMonitor implements WriteAble{

    public static PilotMonitor getPilotMonitor(){
        return new PilotMonitor();
    }

    public void write(String str){
        System.out.println("Pilot Monitor output: " + str);
    }
}

enum LogLevel{
    DEBUG(0), INFO(1), WARNING(2), ERROR(3);

    private final int levelNum;

    LogLevel(int levelNum){
        this.levelNum = levelNum;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public boolean isHigherOrEqual(LogLevel other){
        return this.levelNum <= other.levelNum;
    }
}

class Handler{
    private final WriteAble writeAble;
    private LogLevel logLevel;

    public Handler(LogLevel logLevel, WriteAble writeAble){
        this.logLevel = logLevel;
        this.writeAble = writeAble;
    }

    public void catchLog(String msg){
        writeAble.write(msg);
    }

    public boolean isOverLogLevel(LogLevel level){
        return logLevel.isHigherOrEqual(level);
    }
}


class Logger{

    private ArrayList<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler){
        this.handlers.add(handler);
    }

    public void log(LogLevel level, String msg){
        for(Handler handler: handlers){
            if(handler.isOverLogLevel(level)){
                handler.catchLog(TimeUtils.now() + " " + level + ": " + msg);
            }
        }
    }
}

public class PartBq1{
    public static void main(String[] args) {
        Logger logger = new Logger();
        Handler blackBoxHandler = new Handler(LogLevel.DEBUG, BlackBox.getBlackBox());
        Handler pilotMonitorHandler = new Handler(LogLevel.INFO, PilotMonitor.getPilotMonitor());
        logger.addHandler(blackBoxHandler);
        logger.addHandler(pilotMonitorHandler);

        logger.log(LogLevel.DEBUG, "my debug msg");
        logger.log(LogLevel.INFO, "my info msg");
        logger.log(LogLevel.WARNING, "my warning msg");
        logger.log(LogLevel.ERROR, "my error msg");

    }
}