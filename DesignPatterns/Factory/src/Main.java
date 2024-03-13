public class Main {
    public static void main(String[] args) {
//        PlayerFactory factory = new PlayerFactory();
        Player p1 = PlayerFactory.selectPlayer("human");
        if(p1 != null){
            p1.printPlayerMsg();
        }
    }
}