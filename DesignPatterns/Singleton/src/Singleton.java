public class Singleton {
    private static Singleton singleton;
    private int counter = 0;
    private Singleton(){
        counter ++;
    }

    public static Singleton getInstance(){
        if(singleton != null) return singleton;
        singleton = new Singleton();
        return singleton;
    }

    public int getCounter(){
        return counter;
    }

    public void updateCounter(){
        counter++;
    }
}
