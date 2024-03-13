public class Main {
    public static void main(String[] args) {
//        absClass abs = new absClass() // absClass is abstract; cannot be instantiated
        absClass abs = new SubClass(1); // that is ok
        SubClass abs2 = new SubClass(2);

    }
}