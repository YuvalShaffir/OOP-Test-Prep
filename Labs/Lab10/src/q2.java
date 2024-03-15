import java.util.function.Supplier;

public class q2 {

    public static void main(String[] args) {
        Supplier<Double> supplier = () -> Math.random() * 10;
        activateSupplier(supplier);
    }

    public static void activateSupplier(Supplier<?> supplier){
        System.out.println(supplier.get());
    }

}