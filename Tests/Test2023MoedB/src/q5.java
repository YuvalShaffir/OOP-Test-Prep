class MyClass{

    private static final MyClass myFinalClass = new MyClass();
    private int x;

    public static void main(String[] args) {
        foo(myFinalClass); //1
        System.out.println(myFinalClass.x);
        OtherClass other = new OtherClass(3);
    }

    public static void foo(MyClass myFinalClass){
        myFinalClass.x = 5; //2  (the field that the original object points to will be updated)
        myFinalClass = new MyClass(); //3 (now this is erasing the give object pointer).
    }

}

class OtherClass{
    private int x;

    public OtherClass(int x){
        this.x = x;
        method(this.x);
    }

    public void method(int x){
        x++;
        System.out.println(x); // output: x = 4 (local variable changes locally and doesn't affect the
                                                // field x of the object).
        System.out.println(this.x); // output x = 3 (the field stays the same).
    }
}