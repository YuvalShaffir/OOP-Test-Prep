import java.util.Arrays;

/*DO NOT CHANGE THIS CLASS*/
class Item {
    private String description;
    private float cost;

    public Item(String description, float cost) {
        this.description = description;
        this.cost = cost;
    }

    public float getCost(){
        return cost;
    }
    public String getDescription(){
        return description;
    }
}

/*ADD YOUR CODE HERE*/
/** represents a phone for sale in the shop. It has all the properties and 
 methods of an Item and in addition: */
class Phone extends Item {
    private final int manufactureYear;

    public Phone(String description, float cost, int manufactureYear){
        super(description, cost);
        this.manufactureYear = manufactureYear;
    }

    @Override
    public float getCost(){
        return super.getCost();
    }

    @Override
    public String getDescription(){
        return super.getDescription();
    }

    public int getManufactureYear(){
        return manufactureYear;
    }
}

/** represents a phone that has been refurbished. In addition to the regular
 phone properties and methods, each refurbished phone has: */
class RefurbishedPhone extends Phone {
    private final int discountPercent;

    public RefurbishedPhone(String description, float cost, int manufactureYear, int discountPercent){
        super(description, cost, manufactureYear);
        this.discountPercent = discountPercent;
    }

    @Override
    public String getDescription(){
        return "Refurbished " + super.getDescription();
    }

    @Override
    public int getManufactureYear(){
        return super.getManufactureYear();
    }

    @Override
    public float getCost(){
        return (1- (float)discountPercent/100) * super.getCost();
    }
}

/** represents an accessory for sale in the shop.It has all the properties and
 methods of an Item and in addition: */
class Accessory extends Item {
    private final String model;

    public Accessory(String description, float cost, String model){
        super(description, cost);
        this.model = model;
    }

    public String getModel(){
        return model;
    }

    @Override
    public String getDescription(){
        return model + " " + super.getDescription();
    }
}

/** represents a shopping cart that holds an array of items. */
class Cart {
    private final Item[] items;
    private int size;

    public Cart(){
        this.items = new Item[100];
        this.size = 0;
    }

    public float getCost(){
        float total = 0;
        for(Item i: items){
            if(i != null) total += i.getCost();
        }
        return total;
    }

    public float getShippingFee(){
        if(getCost() + size > 1000){
            return 0;
        }

        return (float)size;
    }

    public void addItem(Item item){
        items[size++] = item;
    }

    public Item[] getItems(){
        // copy only the items that are not null
        return Arrays.copyOfRange(items, 0, size);
    }
}