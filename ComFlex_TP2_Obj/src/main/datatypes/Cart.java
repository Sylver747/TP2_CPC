package main.datatypes;


import java.util.HashMap;
import java.util.Map;

public class Cart {

    /**
     * The client owning the cart.
     */
    public Runnable client;

    /**
     * The items currently added to the cart. key=item, value=quantity.
     */
    private final Map items = new HashMap();


    public Cart(Runnable client) {
        this.client = client;
    }

    public void addItem(Object item, int qty) {
        int oldQty = 0;
        if (items.containsKey(item)) {
            // The item has already been put in the cart
            // Increase the number
            oldQty = ((Integer) items.get(item)).intValue();
        }
        items.put(item, new Integer(qty + oldQty));
    }

    public Map getItems() {
        return items;
    }
}
