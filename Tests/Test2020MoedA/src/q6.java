import java.util.HashMap;

public class q6 {
    public static boolean parOrder(String line){
        HashMap<Character, Integer> counter = new HashMap<>();
        HashMap<Character, Character> paranteses = new HashMap<>();
        paranteses.put('[', ']');
        paranteses.put('{', '}');
        paranteses.put('(',')');
        for(var key: paranteses.keySet()){
            counter.put(key, 0);
        }
        for(var val: paranteses.values()){
            counter.put(val, 0);
        }

        char lastOpenedClosingPar = '1';
        for(char c: line.toCharArray()){

            if(paranteses.containsKey(c)){
                counter.compute(c, (k, v)-> v + 1);
                lastOpenedClosingPar = paranteses.get(c);
            }
            if(paranteses.containsValue(c)){
                if(lastOpenedClosingPar != '1' && c != lastOpenedClosingPar){
                    return false;
                }
                counter.compute(c, (k, v)-> v + 1);
            }
            for(var key: paranteses.keySet()){
                // closing parentheses before opening
                if(counter.get(key) < counter.get(paranteses.get(key))){
                    return false;
                }
            }
        }
        for(var key: paranteses.keySet()){
            if(counter.get(key) != counter.get(paranteses.get(key))){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(parOrder("parentheses no"));
        System.out.println(parOrder("() good parentheses"));
        System.out.println(parOrder("{[]}"));
        System.out.println(parOrder("{([]})"));
        System.out.println(parOrder("())"));

    }
}
