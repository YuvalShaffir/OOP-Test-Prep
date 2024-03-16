import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

abstract class Player{
    protected static final int MAX_VALUE = 10;
    private final int skill;
    private final int study;

    public Player(){
        this.skill = pickRandomPlayerVal();
        this.study = pickRandomPlayerVal();
    }

    protected int pickRandomPlayerVal(){
        return new Random().nextInt(MAX_VALUE);
    }

    public int getSkill(){return skill;}

    public int getStudy(){return study;}

    public abstract int getStrength();
}

class Student extends Player{
    private final int fatigue;

    public Student(){
        super();
        this.fatigue = pickRandomPlayerVal();
    }

    public int getStrength(){
        Random rand = new Random();
        return rand.nextInt(getStudy()*getSkill()) - rand.nextInt(fatigue);
    }
}

class Tutor extends Player{
    private final int xp;

    public Tutor(){
        super();
        this.xp = pickRandomPlayerVal();
    }

    public int getStrength(){
        return new Random().nextInt(getStudy()*getSkill())*xp;
    }
}

class Lecturer extends Player{
    private static final int SKILL_FACTOR = 7;
    private final int xp;
    private final int prestige;

    public Lecturer(){
        super();
        this.xp = pickRandomPlayerVal();
        this.prestige = pickRandomPlayerVal();
    }

    public int getStrength(){
        return new Random().nextInt(getStudy() + SKILL_FACTOR *getSkill()) + xp + prestige;
    }
}

class Constants{
    public static final String STUDENT = "Student";
    public static final String TUTOR = "Tutor";
    public static final String LECTURER = "Lecturer";

}

class PlayerFactory{



    public static Player select(String input){
        switch (input){
            case Constants.STUDENT:
                return new Student();
            case Constants.TUTOR:
                return new Tutor();
            case Constants.LECTURER:
                return new Lecturer();
            default:
                return null;
        }
    }
}

class Game{

    private ArrayList<Player> players;

    public Game(String[] input){
        this.players = getPlayers(input);
    }

    private ArrayList<Player> getPlayers(String[] input){
        ArrayList<Player> players = new ArrayList<>(input.length);

        for(int i=0; i<input.length; i++){
            players.add(PlayerFactory.select(input[i]));
        }
        return players;
    }

    // removes the loser of the match from the players list
    private Player Match(Player p1, Player p2){
        if(p1.getStrength() > p2.getStrength()) return p1;
        else return p2;
    }

    // returns the winning player out of all the players
    public Player run(){
        ArrayList<Player> temp = players;
        int size = temp.size();
        while(size > 1){
            ArrayList<Player> winners = new ArrayList<>();
            for(int i = 0; i<size - 1; i +=2){
                winners.add(Match(temp.get(i), temp.get(i + 1)));
            }
            temp = winners;
            size = temp.size();
        }
        return temp.get(0);
    }

}


public class HerosMMXVIII {

    public static void main(String[] args) {
        // args: list of players
        if(args.length < 2){
            System.out.println("Not enough Players in list");
        }else{
            Game game = new Game(args);
            System.out.println(game.run());
        }

    }
}
