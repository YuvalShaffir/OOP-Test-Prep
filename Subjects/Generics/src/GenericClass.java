public class GenericClass<T> {
    private T id;

    public GenericClass(T id){
        this.id = id;
    }

    public T getId(){
        return id;
    }

}
