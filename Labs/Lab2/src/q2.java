import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;


public class q2 {

    /*DO NOT CHANGE!!!*/
    public static void main(String[] args) {
        Child[] children = {
                new Child("Edan", "04-02-2018", "Soccer"),
                new Child("Esther", "07-10-2018", "Frisbee"),
                new Child("Ori", "13-12-2018", "Acting"),
                new Child("Noa", "01-01-2018", "Math"),
                new Child("Lior", "07-07-2018", "Soccer"),
                new Child("Erel", "08-08-2018", "Computer Games"),
                new Child("Eldar", "09-09-2018", "Baseball"),
                new Child("Omri", "10-10-2018", "Painting"),
                new Child("Rachel", "11-11-2018", "Lego"),
                new Child("Dan", "12-12-2018", "Dancing"),
                new Child("Roy", "02-02-2018", "Reading"),
        };
        KindergartenTeacher teacher = new KindergartenTeacher(children.length);

        Kindergarten kindergarten=new Kindergarten(children,teacher);

        List<LocalDate> listOfDates = getListOfDates();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for(var date: listOfDates){
            teacher.isItTimeToCelebrate(formatter.format(date));
        }
    }

    private static List<LocalDate> getListOfDates() {
        // Our code is using some built-in java library, can you figure out what it does even without reading the documentation?
        // Food for thought: What kinds of decisions go into naming variables and methods so that they are easy to understand
        LocalDate now = LocalDate.now();
        LocalDate startDate = now.with(firstDayOfYear());
        LocalDate endDate = now.with(lastDayOfYear());
        List<LocalDate> listOfDates = startDate.datesUntil(endDate).collect(Collectors.toList());
        return listOfDates;
    }
}


/*Implement all your classes below this line*/

/**  Child class
 A Child should have information about his birth date.
 A birth date should be a String with the format of “dd-mm-yyyy” - no need to check.
 A Child should have a String for his name.
 A Child should have a String for his favorite activity.
 A Child should have a constructor and getters for all of his fields.
 */

class Child {
    private String birthdate;
    private String name;
    private String favActivity;

    public Child(String name, String birthdate, String favActivity) {
        this.birthdate = birthdate;
        this.name = name;
        this.favActivity = favActivity;
    }

    public String getBirthdate(){
        return birthdate;
    }

    public String getName(){
        return name;
    }

    public String getFavoriteActivity(){
        return favActivity;
    }
}

/** BirthdayEvent Class:
 A BirthdayEvent should have information about:
 a child’s name,
 his birthday date (“dd-MM”) and
 his favorite activity.
 A BirthdayEvent should have a constructor that receives a Child object and extracts
 the needed information for initialization.
 A BirthdayEvent should have getters for all of his fields.
 */

class BirthdayEvent {
    private Child child;

    public BirthdayEvent(Child child) {
        this.child = child;
    }

    public String getChildBirthdate(){
        return child.getBirthdate();
    }

    public String getChildName(){
        return child.getName();
    }

    public String getChildFavoriteActivity(){
        return child.getFavoriteActivity();
    }
}

/** Calendar Class
 A Calendar should have a field that holds the max size of the calendar.
 A Calendar should have a construction that gets the max size of the calendar.
 A Calendar should contain an array of BirthdayEvents of size “max size”.
 A Calendar should have an add method that adds a BirthdayEvent to the array if
 the array is not full.  */

class Calendar {
    private int maxCalSize;
    private BirthdayEvent[] events;
    private int capacity = 0;

    public Calendar(int maxCalSize){
        this.maxCalSize = maxCalSize;
        events = new BirthdayEvent[maxCalSize];
    }

    public void add(BirthdayEvent event){
        if(capacity < maxCalSize){
            events[capacity] = event;
            capacity++;
        }
    }

    public BirthdayEvent isItTimeToCelebrate(String date){
        for(var event : events){
            if(event.getChildBirthdate().substring(0,5).equals(date.substring(0,5))){
                return event;
            }
        }
        return null;
    }
}

/** KindergartenTeacher Class
 A KindergartenTeacher should save the maximum number of children the teacher
 can handle that it receives in its constructor.
 A KindergartenTeacher should have a construction that gets the maximum number
 of children the teacher can handle.
 A KindergartenTeacher should have a Calendar:
 The size of the teacher’s Calendar should be the same size as the maximum
 children they can handle. The teacher takes care of initializing the calendar
 in the constructor.
 The teacher should be able to add a BirthdayEvent to his Calendar.
 The teacher should have a method named isItTimeToCelebrate. The method gets
 a date.
 If the date matches a BirthdayEvent in the calendar we print the
 following format:
 "For <child name>'s Birthday party I need to prepare his favorite activity:
 <child's favorite activity>” */
class KindergartenTeacher {
    private int maxChildren;
    private Calendar cal;

    public KindergartenTeacher(int maxChildren){
        this.maxChildren = maxChildren;
        this.cal = new Calendar(maxChildren);
    }

    public void add(BirthdayEvent event){
        cal.add(event);
    }

    public void isItTimeToCelebrate(String date){
        BirthdayEvent event = cal.isItTimeToCelebrate(date);
        if(event != null){
            System.out.println("For "+ event.getChildName() +"'s Birthday party I need to prepare his favorite activity: "+ event.getChildFavoriteActivity());
        }
    }
}

/** Kindergarten Class
 A Kindergarten should have a KindergartenTeacher and an array of Children that
 it receives in its constructor.
 The Kindergarten should take care of adding a BirthdayEvent to the
 KindergartenTeacher’s Calendar for every one of the children in the array. */

class Kindergarten {
    private KindergartenTeacher teacher;
    private Child[] children;

    public Kindergarten(Child[] children, KindergartenTeacher teacher){
        this.children = children;

        this.teacher = teacher;
        for(var child : children){
            this.teacher.add(new BirthdayEvent(child));
        }
    }
}