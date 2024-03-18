package Callback;

@FunctionalInterface
interface Functional{
    boolean isDigit(int n);
}

class Callback {
    private final Functional func;

    public Callback(Functional func){
        this.func = func;
    }

    public void someMethod(){
        if(func.isDigit(8)) {
            System.out.println("8 is a digit");
        }else{
            System.out.println("not a digit");
        }

    }
}

class Main{
    public static void main(String[] args) {
        Functional func = (n) -> true;
        Callback call = new Callback(func);
        call.someMethod();
    }
}


