public class CollisionStrategyFactory {
    public static CollisionStrategy select(String input){
        switch (input){
            case "first":
                return new FirstStrategy();
            case "second":
                return new SecondStrategy();
            default:
                return null;
        }
    }
}
