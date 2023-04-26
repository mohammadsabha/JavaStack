import java.util.ArrayList;

public class BaristaTest {
    public static void main(String[] args) {
        ArrayList<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item("coffee", 2.0));
        itemList.add(new Item("mocha", 2.5));
        /* Barista barista = new Barista("Jimmy", 1.50, true, itemList);
        System.out.println("Barista name: " + barista.getName());
        System.out.println("Barista price: " + barista.getPrice());
        System.out.println("Barista ready: " + barista.isReady());
        System.out.println("Barista items: " + barista.getItems());
         */
        Barista myObject = new Barista();

        myObject.setName("Mohammad");
        //myObject.setPrice(42);
        myObject.setItem(itemList);
        myObject.setReady(true);

        System.out.println("Customer Name: " + myObject.getName());
        System.out.println("Total: " + myObject.getOrderTotal());
        System.out.println("Orders: " + myObject.getItems());
        System.out.println(myObject.isReady());

    }
}
