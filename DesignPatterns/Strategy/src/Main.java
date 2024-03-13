public class Main {
    public static void main(String[] args) {
        GameObject ball = new GameObject("ball", "basketball");
        GameObject kite = new GameObject("kite", "flying Object");

        CollisionStrategy strategy = CollisionStrategyFactory.select("first");
        strategy.onCollision(ball, kite);

        CollisionStrategy strategy1 = CollisionStrategyFactory.select("second");
        strategy1.onCollision(kite, ball);
    }
}