import java.util.*;

class Cords{
    private int x;
    private int y;

    Cords(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int cordSum(){
        return x + y;
    }
}

@FunctionalInterface
interface SpecialFunc{
    Player activate(ArrayList<PlayerOriginator.Memento> saves);
}

enum Rarity{
    COMMON, RARE, EPIC
}

class Geni{
    private final int maxWishes = 3;
    private Rarity rarity;
    private int wishes;

    public Geni(Rarity rarity, int wishes){
        this.rarity = rarity;
        this.wishes = wishes;
    }

    public int getMaxWishes() {
        return maxWishes;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getWishes() {
        return wishes;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public void setWishes(int wishes) {
        this.wishes = wishes;
    }

    public void reduceWishes(){ wishes -= 1;}
}

// the caretaker
class Player{
    private final String name;
    private Geni geni;
    private Cords pos;
    private final static int MAX_LEVEL = 10;
    private int level;
    private final PlayerOriginator careTaker = new PlayerOriginator();
    private final ArrayList<PlayerOriginator.Memento> saves;

    public Player(String name, Cords pos, Geni geni){
        this.name = name;
        this.pos = pos;
        this.geni = geni;
        this.level = 1;
        this.saves = new ArrayList<>();
    }

    public void setPos(Cords pos) {
        //save last Player
        saves.add(careTaker.saveToMomento(this));
        this.pos = pos;
    }

    public void setGeni(Geni geni){
        saves.add(careTaker.saveToMomento(this));
        this.geni = geni;
    }

    public Geni getGeni(){ return geni;}

    public Cords getPos(){ return pos;}

    public void restore(SpecialFunc f){
        Player restored = careTaker.restore(f, saves);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

}

class PlayerOriginator {
    private Player player;

    public PlayerOriginator(){
    }

    public Memento saveToMomento(Player player){
        this.player = player;
        return new Memento(player);
    }

    public Player restore(SpecialFunc f, ArrayList<Memento> saves){
        this.player = f.activate(saves);
        return player;
    }

    public Player getPlayer(){return player;}

    public static class Memento{
        private final Player player;

        private Memento(Player player){
            this.player = player;
        }

        public Player getPlayer(){
            return player;
        }

    }
}

class TimeGenie extends Geni{
    SpecialFunc f1 = new SpecialFunc() {
        @Override
        public Player activate(ArrayList<PlayerOriginator.Memento> saves) {
            int maxPlayerVal = 0;
            Player maxPlayer = null;
            for(var m: saves){
                Player currPlayer = m.getPlayer();
                int currPlayerVal =
                        currPlayer.getPos().cordSum() + currPlayer.getLevel() + currPlayer.getGeni().getWishes();
                if(currPlayerVal >= maxPlayerVal){
                    maxPlayerVal = currPlayerVal;
                    maxPlayer = currPlayer;
                }
            }
            return maxPlayer;
        }
    };

    SpecialFunc f2 = new SpecialFunc() {
        @Override
        public Player activate(ArrayList<PlayerOriginator.Memento> saves) {
            switch (getRarity()){
                case COMMON: return saves.get(0).getPlayer();
                case RARE: return saves.get(saves.size() - 1).getPlayer();
                case EPIC: return saves.get(new Random().nextInt(saves.size() - 1)).getPlayer();
                default: return null;
            }
        }
    };

    public TimeGenie(Rarity rarity, int wishes) {
        super(rarity, wishes);
    }



    public void special(Player player, int input){
        switch (input){
            case 1: player.restore(f1);
            case 2: player.restore(f2);
            default:
        }
        reduceWishes();
    }
}