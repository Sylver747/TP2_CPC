package main.interfaces;

import main.exceptions.InsufficientBalanceException;

public interface IAccount {
    void credit(double amount);

    void withdraw(double amount) throws InsufficientBalanceException;

    void setOwner(String estore);

    void setAmount(double i);

    double getAmount();
}
