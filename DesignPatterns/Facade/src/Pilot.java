import java.util.Random;

public class Pilot extends Worker{
    private final String name;
    private final int registarationNum;

    public Pilot(){
        this.name = "john";
        Random rand = new Random();
        this.registarationNum = rand.nextInt();
    }

    public int registarPilot(){
        return registarationNum;
    }
}
