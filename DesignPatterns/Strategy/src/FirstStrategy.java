public class FirstStrategy implements CollisionStrategy{
    @Override
    public void onCollision(GameObject object, GameObject other) {
        System.out.println("This is the first collisionStrategy, it will take the object: "+object.getName()
        + " of type: "+object.getType()+ " with the other object "+other.getName()+ " of type: "+other.getType());
    }
}
