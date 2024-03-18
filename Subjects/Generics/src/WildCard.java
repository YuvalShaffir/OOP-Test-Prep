import java.util.ArrayList;
import java.util.List;

public class WildCard {

    static void printList(List<? extends Object> list){
        for(Object obj: list){
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        printList(list);
    }

}

