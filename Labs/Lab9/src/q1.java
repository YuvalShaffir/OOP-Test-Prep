import java.util.*;

class GenericCounter<T> {
    // create a Mapping from a generic object to int
    private HashMap<T, Integer> map;

    public GenericCounter() {
        // init the mapping
        this.map = new HashMap<>();
    }

    public void addToMappings(Iterable<T> iterable) {
        // for each item in the iterable, add 1 to the mapping count
        for(var key: iterable){
            if(map.containsKey(key)){
                map.compute(key, (T k, Integer val) -> val + 1); // cannot do val++ because it will return the
                // val
                // before the increment
            }else{
                map.put(key, 1);
            }
        }
    }

    public void printMappings() {
        // for each item and value in the mapping, print it as
        // T has x occurrences
        for(var entry: map.entrySet()){
            System.out.printf("%s has %d occurrences\n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        GenericCounter<Character> gC = new GenericCounter<>();
        gC.addToMappings(Arrays.asList('C', 'o', 'u', 'n', 't', ' '));
        gC.addToMappings(Arrays.asList('T', 'h', 'e', ' '));
        gC.addToMappings(Arrays.asList('L', 'e', 't', 't', 'e', 'r', 's'));
        gC.printMappings();
        GenericCounter<Integer> piCounter = new GenericCounter<>();
        piCounter.addToMappings(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3, 8, 4));
        piCounter.printMappings();
    }

}
