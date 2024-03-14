import java.util.List;

/** Part 1: Create UnaryCalculator and BinaryCalculator
 * the generic functional interfaces below this comment **/
@FunctionalInterface
interface UnaryCalculator<T>{
    T operation(T x);
}

interface BinaryCalculator<T>{
    T operation(T x, T y);

    default T chainOperation(List<T> arr){
        T total = arr.get(0);
        if(arr.size() == 1) return total;

        for(int i=1; i<arr.size(); i++){
            total = operation(total, arr.get(i));
        }
        return total;
    }
}






/** Part 2: Implement MathCalculator **/

public class MathCalculator {
    public BinaryCalculator<Double> add = (x, y) -> {return x+y;};
    public BinaryCalculator<Double> multiply = (x, y) -> { return x*y;};
    public BinaryCalculator<Double> divide = (x, y) -> {
        if(y == 0){
            System.out.println("divided by zero");
            throw new ArithmeticException();
        }
        return x/y;
    };
    public BinaryCalculator<Double> power = (x, y) -> {return Math.pow(x, y);};
    public UnaryCalculator<Double> inverseSquareRoot = (x) -> {
        if(x == 0){
            System.out.println("divided by zero");
            throw new ArithmeticException();
        }
        return 1/Math.sqrt(x);
    };

}

/** Part 3: Implement StringCalculator **/

class StringCalculator {
    UnaryCalculator<Character> toUpperCase = (c) -> {return Character.toUpperCase(c);};
    BinaryCalculator<String> adder = (s1, s2) -> {return s1 + s2;};
}

