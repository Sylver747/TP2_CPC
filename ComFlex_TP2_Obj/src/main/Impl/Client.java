package main.Impl;

import main.datatypes.Cart;
import main.datatypes.Order;
import main.exceptions.InsufficientBalanceException;
import main.exceptions.InvalidCartException;
import main.exceptions.UnknownAccountException;
import main.exceptions.UnknownItemException;
import main.interfaces.IFastLane;
import main.interfaces.ILane;

public class Client implements Runnable {

    private IFastLane fastLaneImpl;
    private ILane laneImpl;

    public Client() {
    }

    public void init(IFastLane fastLane, ILane lane) {
        this.fastLaneImpl = fastLane;
        this.laneImpl = lane;
    }
    // -----------------------------------------------------
    // Implementation of the Runnable interface
    // -----------------------------------------------------

    public void run() {

        // Scenario 1
        // Direct ordering of an item
        // The scenario is run twice
        System.out.println("Scenario 1");
        scenario1("CD", 2, "Lille", "Bob");
        scenario1("CD", 1, "Lille", "Anne");
        System.out.println();

        // Scenario 2
        // Ordering of several items by using a cart
        System.out.println("Scenario 2");
        scenario2(new String[]{"DVD", "CD"}, new int[]{2, 1}, "Lille", "Bob");
        System.out.println();
    }

    private void scenario1(
            String item, int qty, String address, String account) {

        try {
            _scenario1(item, qty, address, account);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void _scenario1(
            String item, int qty, String address, String account)
            throws
            UnknownItemException,
            InsufficientBalanceException, UnknownAccountException {

        System.out.println("Ordering " + qty + " " + item + " for " + account + "...");
        Order order = fastLaneImpl.oneShotOrder(this, item, qty, address, account);
        System.out.println(order);
    }

    private void scenario2(
            String[] items, int[] qties, String address, String account) {

        try {
            _scenario2(items, qties, address, account);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void _scenario2(
            String[] items, int[] qties, String address, String account)
            throws
            InsufficientBalanceException, UnknownAccountException,
            UnknownItemException, InvalidCartException {

        System.out.println("Ordering for " + account + "...");
        Cart cart = null;
        for (int i = 0; i < items.length; i++) {
            System.out.println("Item: " + items[i] + ", quantity: " + qties[i]);
            cart = laneImpl.addItemToCart(cart, this, items[i], qties[i]);
        }
        Order order = laneImpl.pay(cart, address, account);
        System.out.println(order);
    }

}
