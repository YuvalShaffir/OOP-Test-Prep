package FunctionalInterface;

@FunctionalInterface
public interface example {
    // abstract method
    void method();

//    int method2(); // cannot have two abstract methods in a functional interface!

    default void method3(){
        System.out.println("This is a default method in an functional interface");
    }

    default void method4(){
        System.out.println("We are allowed as many default methods as we need");
    }
}



