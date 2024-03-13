public class Airplane extends FlyingObject{

    @Override
    public boolean choosePilot(Pilot pilot) {
        if(pilot.registarPilot() > 0){
            return true;
        }
        return false;
    }


}
