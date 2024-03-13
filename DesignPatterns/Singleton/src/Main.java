public class Main {
    public static void main(String[] args) {
//        Singleton singleton = new Singleton() // 'Singleton()' has private access in 'Singleton'
        Singleton singleton1 = Singleton.getInstance();
        System.out.println("counter after first use of getInstance: "+singleton1.getCounter());
        Singleton singleton2 = Singleton.getInstance();
        System.out.println("counter after second use of getInstance: "+singleton1.getCounter());

        System.out.println(singleton1 == singleton2); // they are the same object with the same address
        System.out.println("They are the same objects with the same address");
        System.out.println(singleton1);
        System.out.println(singleton2);

        singleton1.updateCounter();
        System.out.println("counter is updated in the singleton1 obj, counter = "+singleton1.getCounter());

        System.out.println("will be the same in singleton2 obj, counter = " + singleton2.getCounter());

        MutableClass mutable = MutableClass.SINGLETON;
        System.out.println("this is the first mutable singleton object: " +mutable.getCounter() +
                "\n now lets update the counter of the first object by 1.");
        mutable.updateCounter();

        MutableClass mutable2 = MutableClass.SINGLETON;
        System.out.println("this is the second mutable singleton object: "+mutable2.getCounter());
        // It works because the class is initializing in a final static object
    }
}