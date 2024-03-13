public class GameObject {
    private final String type;
    private final String name;

    public GameObject(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
