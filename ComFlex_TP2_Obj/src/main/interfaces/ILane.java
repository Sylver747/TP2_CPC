package main.interfaces;

import main.datatypes.Cart;
import main.datatypes.Order;
import main.exceptions.InsufficientBalanceException;
import main.exceptions.InvalidCartException;
import main.exceptions.UnknownAccountException;
import main.exceptions.UnknownItemException;

public interface ILane {
    Cart addItemToCart(
            Cart cart,
            Runnable client,
            Object item,
            int qty)
            throws UnknownItemException, InvalidCartException;

    Order pay(Cart cart, String address, String bankAccountRef)
            throws
            InvalidCartException, UnknownItemException,
            InsufficientBalanceException, UnknownAccountException;
}
