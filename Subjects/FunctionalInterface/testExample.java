package FunctionalInterface;

public class testExample {
    public static void main(String[] args) {
        final String name = "Dani";


        example func = new example() {
            @Override
            public void method() {

                // here we can use the default methods of the interface
                method3();
                method4();

                // we can call a final field from the outside scope.
                System.out.println("name is: "+ name);
            }
        };

        // name has to be final so that the functional interface can use it.
//        name = "Moti";
    }
}
