package Shadowing;

class A{
    public int myInt=  1;

    public static void staticFoo(){
        System.out.println("A");
    }
}

class B extends A{
    public int myInt = 2;

    public static void staticFoo(){
        System.out.println("B");
    }
}

class C{
    public int myInt=  3;

    public void staticFoo(){
        System.out.println("C");
    }
}

class D extends C{
    public int myInt = 4;

    public void staticFoo(){
        System.out.println("D");
    }
}


class ShadowingClass{
    public static void main(String[] args) {
        // TODO: Shadowing only happens with public fields and public static methods.
        A a = new B();
        System.out.println(a.myInt); // shadowing
        a.staticFoo(); // shadowing

        // only public field, a non-static method
        C c = new D();
        System.out.println(c.myInt); // this is shadowing
        c.staticFoo(); // this is Overriding
    }
}