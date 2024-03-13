public interface InterfacePossiblities {
//    private static int STATIC_FIELD = 9; // Modifier 'private' not allowed here
    static final int FINAL_STATIC_FIELD = 9; // Modifier 'final' is redundant for interface fields.
    static String STATIC_FIELD = "this is STATIC FIELD";

    void method(); //will be overrided in the implementing class

    default void defMethod(){
        System.out.println("This method is a default method");
        System.out.println(print()); // calling a private interface method
        System.out.println(statMethod()); // calling a static method from the default method
    }

    private String print(){
        return "This message came from the private method of the interface";
    }

    private static String statMethod(){ // Modifier 'public' is redundant for interface members
        return "This message came from the static method of the interface";
    }


    static String statMethod2(){
        return "this is a static interface method";
    }
}
