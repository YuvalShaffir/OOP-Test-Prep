package NestedClass;

class OuterClass {
    static int staticField;
    public int nonStaticField;
    StaticNestedClass nested = new StaticNestedClass();


    void outerMethod() {
        System.out.println("Outer method");
    }

    static void outerStaticMethod(){
        System.out.println("Static outer method");
    }

    private static class StaticNestedClass {
        void method() {
            // Can access outer-class staticField directly
            int x = staticField;

            // Cannot access nonStaticField outer-class directly
            // int y = nonStaticField; // Error

            new OuterClass().outerMethod(); // can access outclass methods
            OuterClass.outerStaticMethod(); // can access outerclass static method without creating an
            // instance of the class
        }
    }

    public class InnerClass {
        // Can access both staticField and nonStaticField directly
        void method() {
            int x = staticField;
            int y = nonStaticField;
        }
    }
}


class Test{
    public void method(){
        // TODO: Inner class is a non-static inner class!!!
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
    }
}