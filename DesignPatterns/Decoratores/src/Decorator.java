public class Decorator implements SomeInterfaceDecorator{
    private final SomeInterface interfaceInstance;

    public Decorator(SomeInterface interfaceInstance) {
        this.interfaceInstance = interfaceInstance;
    }

    @Override
    public void basicFunction() {
        // Decorator stuff before basic function
        System.out.println("We are now calling the basic function from the decorator.");
        interfaceInstance.basicFunction();
        // Decorator stuff after the basic function
        System.out.println("We finished calling the basic function from the decorator.");
    }
}
