import java.util.List;

// We can add to the list dog and all its subclasses that inherit from it.
public class LowerBound {
    public static void addDogToList(List<? super Dog> list, Dog element){
        list.add(element);
    }
}
