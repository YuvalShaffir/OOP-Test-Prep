import java.util.Arrays;
import java.util.List;

class Solution{
    public static double sum(List<? extends Number> numbers) {
        double sum = 0;
        for(var num: numbers){
            sum += num.doubleValue();
        }
        return sum;
    }
}

class Main{
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double sum = Solution.sum(numbers);
        System.out.println(sum);

        List<Double> numbers2 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        double sum2= Solution.sum(numbers2);
        System.out.println(sum2);
    }
}