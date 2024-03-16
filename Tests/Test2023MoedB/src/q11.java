import java.util.HashMap;
import java.util.HashSet;

//Part A
// צרו מחלקה בשם VisitorUIDCard אשר תייצג כרטיס מגנטי של מבקר בפארק.
class VisitorUIDCard{

    private final int age;
    private final double height;
    private final int UID;

    public VisitorUIDCard(int age, double height, int UID){
        this.age = age;
        this.height = height;
        this.UID = UID;
    }

    public int getAge(){
        return this.age;
    }

    public double getHeight(){
        return this.height;
    }

    public int getUID(){
        return this.UID;
    }
}

class TicketVendor{
    public final static int MAX_PIERCINGS = 10;
    private final static int MAX = 999999;
    private final static int MIN = 0;
    private final HashSet<Integer> uidSet = new HashSet<>();
    private final DataBase database = DataBase.getInstance();

    public VisitorUIDCard createNewUIDCard(int age, double height){
        int UID = generateUID();
        // part B
        database.add(UID, MAX_PIERCINGS);
        return new VisitorUIDCard(age, height, UID);
    }

    private int generateUID(){
        int generatedUID = 0;
        while(uidSet.contains(generatedUID)){ //todo: We could have used a call to a method of DataBase
            // class to check if it contains the UID.
            generatedUID = (int)Math.floor(Math.random() * (MAX - MIN + 1) + MIN);
        }
        uidSet.add(generatedUID); //todo: they told us that only the singleton manages the UIDs. we should
        // have used the inner class of DataBase.
        return generatedUID;
    }
}

// part B
class DataBase{
    private final HashMap<Integer, Integer> visitorPiercing;
    private static DataBase database;

    private DataBase(){
        visitorPiercing = new HashMap<>();
    }

    public static DataBase getInstance(){
        if(database != null) return database;

        database = new DataBase();
        return database;
    }

    public void add(int UID, int piercings){
        visitorPiercing.put(UID, piercings);

    }

    public int getVisitorPiercing(int UID){
        return visitorPiercing.get(UID);
    }

    public void pierce(int UID){
        visitorPiercing.computeIfPresent(UID, (key, val) -> val - 1);
    }
}

// Part C
class MorePeopleThanSeatsException extends Exception{
    public MorePeopleThanSeatsException(String msg){
        super(msg);
    }
}

// צרו מחלקה אבסטרקטית בשם Ride. מחלקה זו תייצג מתקן כללי בפארק השעשועים.
abstract class Ride{
    public static final String MORE_PEOPLE_THAN_SEATS_ERROR = "There are more visitors than seats available for this ride.";

    private final int numOfSeats;
    private final int minAge;
    private final double minHeight;
    private final DataBase database;

    public Ride(int numOfSeats, int minAge, double minHeight){
        this.numOfSeats = numOfSeats;
        this.minAge = minAge;
        this.minHeight = minHeight;
        this.database = DataBase.getInstance();
    }

    protected abstract void activate();

    public void checkThenActivate(VisitorUIDCard[] visitors) throws MorePeopleThanSeatsException{
        HashSet<VisitorUIDCard> filteredVisitors = new HashSet<>();

        for(var visitor: visitors){
            if(visitor.getHeight() >= minHeight && visitor.getAge() >= minAge && database.getVisitorPiercing(visitor.getUID()) > 0){
                filteredVisitors.add(visitor);
            }
        }

        if(filteredVisitors.size() > numOfSeats){
            throw new MorePeopleThanSeatsException(MORE_PEOPLE_THAN_SEATS_ERROR);
        }

        for(var visitor: filteredVisitors){
            database.pierce(visitor.getUID());
        }

        this.activate();
    }
}

//Part D

// מתקן מסתובב יממש את השיטה spin.
interface SpinRide{
    void spin();
}

// מתקן מתנדנד יממש את השיטה tilt.
interface TiltRide{
    void tilt();
}

// מתקן שמשמיע מוזיקה יממש את שתי השיטות startMusic, stopMusic.
interface MusicalRide{
    void startMusic();

    void stopMusic();
}

// מתקן שעולה ויורד יממש שתי שיטות, moveUp, ו-moveDown.
interface MovementRide{
    void moveUp();
    void moveDown();

    default void moveUpAndDown(int X){
        for(int i=0; i<X; i++){
            moveUp();
            moveDown();
        }
    }
}

//Part E
// בסעיף זה ניצור קוד עבור מתקן הקרוסלה בפארק. הקרוסלה שיש בפארק יכולה להסתובב, לעלות ולרדת ולהשמיע מוזיקה. לקרוסלה יש 10 מושבים, מגבלת הגיל של עליה לקרוסלה היא מגיל 3, ואין מגבלת גובה.

class Carrousel extends Ride implements SpinRide, MovementRide, MusicalRide{
    private final static int UP_DOWN_ITERATIONS = 2;
    private final static int SPIN_ITERATIONS = 5;
    private final static int NUM_OF_SEATS = 10;
    private final static int MIN_AGE = 3;
    private final static double MIN_HEIGHT = 0;
    private final static String SPIN_MSG = "spin";
    private final static String MOVEUP_MSG = "move up";
    private final static String MOVEDOWN_MSG = "move down";
    private final static String START_MUSIC_MSG = "start music";
    private final static String END_MUSIC_MSG = "end music";

    public Carrousel(){
        super(NUM_OF_SEATS, MIN_AGE, MIN_HEIGHT);
    }

    //TODO: is it possible at all the make them private? NO
    public void spin(){
        System.out.println(SPIN_MSG);
    }

    public void moveUp(){
        System.out.println(MOVEUP_MSG);
    }

    public void moveDown(){
        System.out.println(MOVEDOWN_MSG);
    }

    public void startMusic(){
        System.out.println(START_MUSIC_MSG);
    }

    public void stopMusic(){
        System.out.println(END_MUSIC_MSG);

    }

    protected void activate(){
        startMusic();
        for(int i=0; i<SPIN_ITERATIONS; i++) spin();
        moveUpAndDown(UP_DOWN_ITERATIONS);
        stopMusic();
    }

}



