package NestedClass;

class OuterClass {
    static int staticField;
    int nonStaticField;

    void outerMethod() {
        System.out.println("Outer method");
    }

    static void outerStaticMethod(){
        System.out.println("Static outer method");
    }

    private static class StaticNestedClass {
        // Can access staticField directly
        void method() {
            int x = staticField;
            // Cannot access nonStaticField directly
            // int y = nonStaticField; // Error

            new OuterClass().outerMethod(); // can access outclass methods
            OuterClass.outerStaticMethod(); // can access outerclass static method without creating an
            // instance of the class
        }
    }

    private class InnerClass {
        // Can access both staticField and nonStaticField directly
        void method() {
            int x = staticField;
            int y = nonStaticField;
        }
    }
}


class Main{
    public static void main(String[] args) {

    }
}