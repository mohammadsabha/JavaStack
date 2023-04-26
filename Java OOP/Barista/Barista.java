import java.util.ArrayList;

public class Barista {
    private String name;
    private double price;
    private boolean ready;
    private ArrayList<Item> items;

    /* public Barista(String name, double price, boolean ready, ArrayList<Item> items) {
        this.name = name;
        this.price = price;
        this.ready = ready;
        this.items = items;
    } */
    /* public void setPropertyName(PropertyType propertyValue) {
        this.propertyName = propertyValue;
    }     */
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public void setName(String name) {
        this.name = name;
    }   
    public String getName() {
        return name;
    } 
    public double getOrderTotal() {
        double totalPrice = 0.0;
            for (Item item : items) {
            totalPrice += item.getPrice();
            }
        return totalPrice;
    }
    public void setReady(boolean ready) {
        this.ready = ready;
    }    
    public String isReady() {
        if (ready) {
            return "Your order is ready.";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }
    public void setItem(ArrayList<Item> items) {
        this.items = items;
    }
    public ArrayList<Item> getItems() {

        return items;
    }
    /* public double getOrderTotal(ArrayList<Barista> baristas) {
        double totalPrice = 0;
        for (Barista barista : baristas) {
            for (Item item : barista.getItems()) {
                totalPrice += item.getPrice();
            }
        }
        return totalPrice;
    } */
    
    

}
