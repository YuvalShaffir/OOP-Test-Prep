//package StaticClass;
//
//interface One{
//    static void method2();
//}
//
//class Father{
//    static void method3(){
//        System.out.println("this is the father");
//    }
//}
//
//public class StaticClass extends Father implements One{
//    static void method1(){
//        System.out.println("this is a static method");
//    }
//
//    @Override
//    public static void method2() {
//        System.out.println("Can implement an interface");
//    }
//
//    @Override
//    public static void method3(){
//
//    }
//}
//
//class Second{
//    public static void main(String[] args) {
//        StaticClass stat = new StaticClass();
//        stat.method2();
//        stat.method3();
//    }
//}
