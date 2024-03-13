
// facade class that is making the API easier to use.
public class Flight {
    private final Pilot pilot;
    private final FlyingObject flyingObj;

    public Flight(){
        this.pilot = new Pilot();
        this.flyingObj = new Airplane();
    }

    public void startFlight(){
        if(flyingObj.choosePilot(pilot)){
            System.out.println("starting the flight");
        }else{
            System.out.println("flight canceled");
        }
    }



}
