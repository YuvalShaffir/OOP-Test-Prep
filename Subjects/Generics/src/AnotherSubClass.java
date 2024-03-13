
// we can extend a generic class with a specific give type
// the extended class can be generic like this one or not generic
public class AnotherSubClass<T> extends GenericClass<String>{

    public AnotherSubClass(T input) {
        super("id");
    }

    @Override
    public String getId() {
        return super.getId();
    }
}
