import java.util.*;

class Histogram {

    public static <T> Map<T, Integer> histogram(List<T> list) {
        /*
         * write your code here
         */
        HashMap<T, Integer> map = new HashMap<>();

        for(T item: list){
            if(map.containsKey(item)){
                map.compute(item, (k, v) -> v + 1);
            }else{
                map.put(item, 1);
            }
        }
        return map;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

