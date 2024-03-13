import java.util.List;

// T can use all the methods and functionalities of the Object class
public class UpperBound<T extends Object> {
    private final T input;

    public UpperBound(T input) {
        this.input = input;
    }

    public T getInput() {
        return input;
    }

    // WILDCARDS
//    public void count(List<? extends Human> lst){ //CLASH WITH THE NEXT CLASS - both have the same Erasure
//        int num = 0;
//        for(Object o: lst){
//            num++;
//        }
//        System.out.printf("List has %d items", num);
//    }

    // WILDCARD with extension
    public void count(List<? extends Animal> lst){
        int num = 0;
        for(Animal o: lst){
            num++;
        }
        System.out.printf("List has %d items", num);
    }
}
