public class MutableClass {
    public static final MutableClass SINGLETON = new MutableClass(); // no duplicates between different
    // objects of the MutableClass
    private int counter = 0;

    public int getCounter(){
        return counter;
    }

    public void updateCounter(){
        counter ++;
    }
}
