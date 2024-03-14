public class Main {
    public static void main(String[] args) {
        Item secondHandIphone = new RefurbishedPhone("Iphone14",  1400,2022,50);
        Item screenProtector = new Accessory("Screen protector",10 ,"Iphone14");

        Cart myShoppingCart = new Cart();
        myShoppingCart.addItem(secondHandIphone);
        myShoppingCart.addItem(screenProtector);

        System.out.println("The items in the cart:");
        for (Item item : myShoppingCart.getItems()) {
            System.out.println("*Item :" + item.getDescription() + " cost: " + item.getCost());
        }

        System.out.println("Total cost of cart including shipping fee is: " + ((float)myShoppingCart.getCost()+(float) myShoppingCart.getShippingFee()));
    }
}