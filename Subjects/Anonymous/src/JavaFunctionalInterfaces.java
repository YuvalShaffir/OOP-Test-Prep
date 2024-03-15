import java.util.function.*;

public class JavaFunctionalInterfaces {
    // A functional interface that gets a <T> and returns a boolean.
    // Assert true / false about the given input.
    Predicate<Integer> predicate = (a) -> a == 1;

    // We also have a direct class that does the same thing for an Integer or Double
    IntPredicate intPredicate = (a) -> a==2;
    DoublePredicate doublePredicate = (a) -> a == 0.5;

    // Consumer gets a <T> and returns void.
    // Way to remember: A consumer takes a product and uses it until it is totally consumed (gone).
    Consumer<Integer> consumer = (a) -> {};

    // Supplier gets nothing, and returns an instance of the given type <T>
    // Way to remember: A supplier supplies us with products
    Supplier<Integer> supplier = () -> 1;

    // Function get a <T, R>, T is the input type and R is the return type.
    Function<Integer, String> func = (a) -> "This number is turned into string " + a.toString();

    // BiFunction get two input types and a return type <T, U, R>
    BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a + b;

    // Runnable is a function that doesn't get any argument and returns void. <-- Used for callbacks
    Runnable method = () -> System.out.println("Runnable");

    int res = biFunction.apply(1, 2);

}
