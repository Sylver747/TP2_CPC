package main.datatypes;

import main.exceptions.UnknownItemException;

import java.util.*;

public class Order {

    /**
     * The total number of orders emitted so far.
     */
    private static int numOrders;

    /**
     * The index of this order.
     */
    private final int num;

    private Runnable client;
    private Object item;
    private String address;
    private String bankAccountRef;

    /**
     * The date at which the ordered is issued.
     */
    public Date date;

    /**
     * The delay for delivering the items in the order.
     */
    private int delay;

    /**
     * The items currently in the order.
     */
    private final Set items = new HashSet();

    /**
     * The quantities of each item ordered. key=item, value=quantity.
     */
    private final Map itemQuantities = new HashMap();

    /**
     * The individual prices of each item ordered. key=item, value=price.
     */
    private final Map itemPrices = new HashMap();


    private Order() {
        num = numOrders++;
        date = new Date();
    }

    public Order(Runnable client, String address, String bankAccountRef) {
        this();
        this.client = client;
        this.address = address;
        this.bankAccountRef = bankAccountRef;
    }

    /**
     * Add an item to the order.
     *
     * @param item
     * @param qty
     * @param price
     * @throws UnknownItemException
     */
    public void addItem(Object item, int qty, double price)
            throws UnknownItemException {

        if (itemPrices.containsKey(item)) {
            double oldPrice = ((Double) itemPrices.get(item)).doubleValue();
            if (oldPrice != price)
                throw new UnknownItemException(
                        "Item " + item + " price (" + price +
                                ") added to cart is different from the price (" +
                                oldPrice + ") of the same item already in the cart");
        }

        items.add(item);
        itemPrices.put(item, new Double(price));

        int newQty = qty;
        if (itemQuantities.containsKey(item)) {
            newQty += ((Integer) itemQuantities.get(item)).intValue();
        }
        itemQuantities.put(item, new Integer(newQty));
    }

    /**
     * Compute the total amount of the order
     */
    public double computeAmount() {

        double amount = 0;

        for (Iterator iter = items.iterator(); iter.hasNext(); ) {
            Object item = iter.next();
            int qty = ((Integer) itemQuantities.get(item)).intValue();
            double price = ((Double) itemPrices.get(item)).doubleValue();

            amount += qty * price;
        }

        return amount;
    }

    /**
     * @return Returns the delay for delivering this order.
     */
    public int getDelay() {
        return delay;
    }

    /**
     * Set the delay for this order.
     * The delay is the highest delay for delivering all the items of an order.
     */
    public void setDelay(int delay) {
        if (delay > this.delay)
            this.delay = delay;
    }

    public int getKey() {
        return num;
    }

    public String toString() {
        String msg = "Order #" + num + " ";
        msg += "amount: " + computeAmount() + " ";
        msg += "delay: " + getDelay() + "h ";
        msg += "issued on: " + date;
        return msg;
    }
}
