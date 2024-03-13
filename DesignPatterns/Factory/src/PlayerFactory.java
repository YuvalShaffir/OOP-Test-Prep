public class PlayerFactory {
    public static Player selectPlayer(String name) {
        switch(name){
            case "human":
                return new HumanPlayer();
            case "crazy":
                return new CrazyPlayer();
            default:
                return null;
        }
    }
}
