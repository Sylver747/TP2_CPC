package main.datatypes;

import main.interfaces.IProvider;

public class ItemInStock {

    /**
     * The total number of ItemInStock instances created.
     */
    private static int numItems;

    /**
     * The index of this item.
     */
    private final int num;

    public Object item;
    public int quantity;
    public double price;
    public IProvider provider;

    private ItemInStock() {
        num = numItems++;
    }

    public ItemInStock(Object item, int quantity, double price,
                       IProvider provider) {
        this();
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.provider = provider;
    }

    public String toString() {
        return "Item #" + num;
    }

}
