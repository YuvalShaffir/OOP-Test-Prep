public class Main {
    public static void main(String[] args) {
        // without the decorator
        InterfaceObj obj = new InterfaceObj();
        obj.basicFunction();
        // now with the decorator
        SomeInterface decoratedObj = new Decorator(obj);
        decoratedObj.basicFunction();
    }
}