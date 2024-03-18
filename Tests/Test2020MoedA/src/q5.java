public class q5 {
    public static boolean isBinary(int num){
        String strNum = Integer.toString(num);
        for(char c: strNum.toCharArray()){
            if(c != '1' && c != '0'){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isBinary(101010)); // got true
        System.out.println(isBinary(101023)); // got false

    }
}
