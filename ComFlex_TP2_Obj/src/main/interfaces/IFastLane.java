package main.interfaces;

import main.datatypes.Order;
import main.exceptions.InsufficientBalanceException;
import main.exceptions.UnknownAccountException;
import main.exceptions.UnknownItemException;

public interface IFastLane {
    Order oneShotOrder(
            Runnable client,
            Object item,
            int qty,
            String address,
            String bankAccountRef
    )
            throws
            UnknownItemException,
            InsufficientBalanceException, UnknownAccountException;
}
