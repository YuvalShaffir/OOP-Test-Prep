public class Main {
    public static void main(String[] args) {
        // Raw use of the class is possible but it is bad practice
        GenericClass g1 = new GenericClass(11232);
        System.out.println(g1.getId());

        // good practice
        GenericClass<Integer> g2 = new GenericClass<>(1234);
        System.out.println(g2.getId());

        GenericClass<String>[] list = new GenericClass[]{new GenericClass<>("324"),
                new GenericClass<>("2323")};
    }
}