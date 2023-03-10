package main.interfaces;

import main.Impl.Store;
import main.exceptions.UnknownItemException;

public interface IProvider {
    double getPrice(Object item) throws UnknownItemException;

    int order(Store store, Object item, int qty)
            throws UnknownItemException;
}
