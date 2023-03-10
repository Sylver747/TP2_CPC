package main.interfaces;

import main.exceptions.InsufficientBalanceException;
import main.exceptions.UnknownAccountException;

public interface IBank {
    void transfert(String from, String to, double amount)
            throws InsufficientBalanceException, UnknownAccountException;
}
