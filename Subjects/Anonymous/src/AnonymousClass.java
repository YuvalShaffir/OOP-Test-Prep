import java.util.ArrayList;
import java.util.List;

interface SomeInterface {
    void method();
}

class Outerclass {

    // Implementation of interface
    SomeInterface anonymous = new SomeInterface() {
        @Override
        public void method() {
            // implementation
        }
    };

    SomeInterface lambda = () -> System.out.println("Lambda here");

    // Inheritance of ArrayList
    List<Integer> list = new ArrayList<>(){
        /**
         * Returns the number of elements in this list.
         *
         * @return the number of elements in this list
         */
        @Override
        public int size() {
            return 0;
        }
    };
}
