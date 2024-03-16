// part A
abstract class Vehicle{
    private float speed;
    private final String nickname;

    public Vehicle(String nickname){
        this.speed = 0; //todo: we should have declared a constant
        this.nickname = nickname;
    }

    public void setSpeed(float speedToSet){
        this.speed = speedToSet;
    }
}

// part B
class Passenger{
    private final String name;
    private int age;
    private int drivingExperience;

    public Passenger(String name, int age, int drivingExperience){
        this.name = name;
        this.age = age;
        this.drivingExperience = drivingExperience;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getDrivingExperience(){
        return drivingExperience;
    }
}

// part C and D
@FunctionalInterface
interface SpeedStrategy{
    float calculateSpeed();
}

class ChittyChittyBangBang extends Vehicle{
    private final static String DEFAULT_NAME =  "Chitty Chitty Bang Bang";
    private final static Location DEFAULT_LOCATION = Location.GROUND;
    private final Passenger[] passengers; //todo: we could have used a ArrayList
    private SpeedStrategy speedstrategy;
    private Location location;
    private ChittyState state;
    private Passenger driver;

    public ChittyChittyBangBang(Passenger[] passangers){
        super(DEFAULT_NAME);
        this.passengers = passangers;
        this.location = Location.GROUND;
        this.driver = createDriver();
    }

    private Passenger createDriver(){
        if(passengers.length % 2 == 0) return passengers[passengers.length / 2];
        else return passengers[(int)Math.ceil((float)passengers.length / 2)];
    }

    public Passenger getDriver(){
        return driver;
    }

    public Passenger[] getPassangers(){
        return passengers;
    }

    public void setSpeedStrategy(SpeedStrategy speedstrategy){
        this.speedstrategy = speedstrategy;
    }

    public void updateSpeed(){
        setSpeed(speedstrategy.calculateSpeed());
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public void setState(ChittyState state){
        this.state = state;
        this.state.updateChittyState();
    }
}


// part E
enum Location{
    AIR,
    GROUND,
    SEA,
}

// part F
abstract class ChittyState{
    protected final ChittyChittyBangBang chity;

    public ChittyState(ChittyChittyBangBang chity){
        this.chity = chity;
    }
    protected abstract void updateChittyState();
}

// part G

class DrivingState extends ChittyState{

    public static final float FACTOR = 5f;

    public DrivingState(ChittyChittyBangBang chity) {
        super(chity);
    }

    @Override
    protected void updateChittyState(){
        chity.setLocation(Location.GROUND);
        Passenger driver = chity.getDriver();
        chity.setSpeedStrategy(() -> FACTOR *driver.getAge());
        chity.updateSpeed();
    }
}

class SailingState extends ChittyState{

    public static final int DENOMINATOR = 100;

    public SailingState(ChittyChittyBangBang chity) {
        super(chity);
    }

    @Override
    protected void updateChittyState(){
        chity.setLocation(Location.SEA);
        Passenger driver = chity.getDriver();
        chity.setSpeedStrategy(() -> (float)driver.getDrivingExperience() / DENOMINATOR);
        chity.updateSpeed();
    }
}

class FlyingState extends ChittyState{

    public static final float RETURN_VAL = 1000f;

    public FlyingState(ChittyChittyBangBang chity) {
        super(chity);
    }

    @Override
    protected void updateChittyState(){
        chity.setLocation(Location.AIR);
        chity.setSpeedStrategy(() -> RETURN_VAL);
        chity.updateSpeed();
    }
}


