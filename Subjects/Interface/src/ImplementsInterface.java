public class ImplementsInterface implements InterfacePossiblities{
    @Override
    public void method() {
        System.out.println("This is the normal method implemented by a class");
        System.out.println("I can also call the default method from here which adds new functionality to " +
                "all classes that implement this interface");
        this.defMethod();
    }
}
