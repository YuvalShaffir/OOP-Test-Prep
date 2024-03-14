public class Main {
    public static void main(String[] args) {
        MathCalculator calc = new MathCalculator();
        System.out.println("1 + 2 = " + calc.add.operation(1.0,2.0));
        System.out.println("5 * 7 = " + calc.multiply.operation(5.0, 7.0));
        System.out.println("Divide by zero test");

        try
        {
            calc.inverseSquareRoot.operation(0.0);
        }
        catch(ArithmeticException e){
            System.out.println("Caught arithmetic exception");
        }
        System.out.println("Inverse square root of zero test");
        try
        {
            calc.divide.operation(1.0, 0.0);
        }
        catch(ArithmeticException e){
            System.out.println("Caught arithmetic exception");
        }
        System.out.println("100 / 10 = " + calc.divide.operation(100.0, 10.0));
        System.out.println("3^4 = " + calc.power.operation(3.0, 4.0));
        System.out.println("1/sqrt(9) = " + calc.inverseSquareRoot.operation(9.0));
    }
}