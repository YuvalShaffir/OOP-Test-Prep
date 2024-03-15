import java.util.function.*;


interface CounterInterface{
    int updateCounter();
}

public class References {
    static Supplier<Integer>   incOneSupplier;
    static Function<String, Integer>   getStringLength;
    static Function<Integer, String>   intToStrFunc;
    static BinaryOperator<Integer>     getMax;
    static BiPredicate<Integer, Integer> isModZero;
    static UnaryOperator<String>       getFirstThreeLetters;

    public static void main(String[] args) {
        //EASY:
        //a function that receives an integer and returns its string representation.
        //it's possible to use a method reference here.
        intToStrFunc = Object::toString;
        //EASY:
        //a function that receives two integers and returns true if and only if
        //the first divides by the second without a remainder.
        isModZero = (n1, n2) -> n1 % n2 == 0;
        //EASY:
        //a function that receives two integers and returns the bigger one.
        //it's possible to use a method reference here.
        getMax = (n1, n2) -> (n1 > n2)? n1 : n2;
        //EASY:
        //a function that receives a string and returns its length.
        //it's possible to use a method reference here.
        getStringLength = String::length;
        //MEDIUM:
        //a function that gets a string and returns a string comprised of
        //the first three letters of the input. if the input is shorter
        //than three, THE STRING IS RETURNED AS-IS. See String.substring.
        getFirstThreeLetters =  (s) -> (s.length() >= 3) ? s.substring(0,3) : s;
        //HARD:
        //function that receives no parameters and returns an int. Each
        //time it's called it returns an int bigger by one than the previous,
        //starting with 1. This one's tricky, consider an anonymous class...
        CounterInterface anonymous = new CounterInterface() {
            int counter = 1;

            @Override
            public int updateCounter() {
                return counter++;
            }
        };
        incOneSupplier = anonymous::updateCounter;

        //test
        System.out.println(getStringLength.apply("Harry Potter"));

        for(int i=0; i<10; i++){
            System.out.println(incOneSupplier.get());
        }
    }

}

