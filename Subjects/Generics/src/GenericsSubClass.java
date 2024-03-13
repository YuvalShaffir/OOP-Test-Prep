public class GenericsSubClass<T> extends GenericClass<T> {
    public GenericsSubClass(T id) {
        super(id);
    }

    @Override
    public T getId() {
        return super.getId();
    }
}
