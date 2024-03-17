import java.util.Arrays;
import java.util.HashSet;

public class Main {
    // Question 5
    // not using HashSet:
    public static int distinctElements(int[] arr){
        Arrays.sort(arr);
        int currNum = arr[0];
        int counter = 1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] != currNum){
                counter++;
                currNum = arr[i];
            }
        }
        return counter;
    }

    // using Hashset
    public static int distinctElementsHashSet(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(var item: arr){
            set.add(item);
        }
        return set.size();
    }


    public static void main(String[] args) {
        // O(nlog(n)) because of the sorting
        System.out.println(distinctElements(new int[]{1,1,2,3,3,4,5}));
        // checking containment in an Hash set is O(1) and we iterate over all the array so O(n)
        System.out.println(distinctElementsHashSet(new int[]{1,1,2,3,3,4,5}));
    }
}