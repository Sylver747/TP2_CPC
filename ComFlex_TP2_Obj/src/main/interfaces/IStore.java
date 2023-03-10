package main.interfaces;

import main.exceptions.UnknownItemException;

public interface IStore {
    double getPrice(Object item) throws UnknownItemException;

    boolean isAvailable(Object item, int qty)
            throws UnknownItemException;

    String toString();
}
