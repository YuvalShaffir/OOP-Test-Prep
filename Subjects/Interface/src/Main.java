public class Main {
    public static void main(String[] args) {
        System.out.println(InterfacePossiblities.statMethod2()); // a static interface method can be
        // used outside the interface
        System.out.println(InterfacePossiblities.STATIC_FIELD); // static fields can be accessed from
        // outside the interface.

        InterfacePossiblities obj = new ImplementsInterface();
        obj.method();
    }
}