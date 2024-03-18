import java.util.ArrayList;
import java.util.HashMap;

public class q5 {
    public static boolean subStringInList(String s, String[] arr){
        // counts the number of times an ascii char is in the string
        ArrayList<HashMap<Integer, Integer>> Counters = new ArrayList<>();
        for(String str: arr){
            Counters.add(getCharCounter(str));
        }
        HashMap<Integer, Integer> givenStrCounter = getCharCounter(s);

        for(var word: Counters){
            int countMatches = 0;
            int countCounterMatches = 0;
            if(word.keySet().size() == s.length()) {
                for (var c : givenStrCounter.keySet()) {
                    if (!word.containsKey(c)) break; //go to the next word
                    else {
                        countMatches++;
                        if (word.get(c) != givenStrCounter.get(c)) {
                            break; // go to the next word
                        } else {
                            countCounterMatches++;
                        }
                    }
                }
            }
            if(countMatches == s.length() && countCounterMatches == s.length()) return true;
        }
        return false;

    }

    private static HashMap<Integer, Integer> getCharCounter(String str){
        HashMap<Integer, Integer> charCounter = new HashMap<>();
        for(int c: str.toCharArray()){
            if(charCounter.containsKey(c)){
                charCounter.compute(c, (k,v)->v+1);
            }else{
                charCounter.put(c, 1);
            }
        }
        return charCounter;
    }

    public static void main(String[] args) {
        System.out.println(subStringInList("Oops", new String[]{"sOop", "a word"})); //returns true
        System.out.println(subStringInList("Oops", new String[]{"soop", "a word"})); // return false
        System.out.println(subStringInList("Oops", new String[]{"sOop", "psOo"})); // return true
        System.out.println(subStringInList("word", new String[]{"this is a word", "a word"})); // returns
        // false
        System.out.println(subStringInList("word", new String[]{"this is a word", "dwor"})); // returns true
    }
}
