package main.Impl;

import main.exceptions.InsufficientBalanceException;
import main.exceptions.UnknownAccountException;
import main.interfaces.IAccount;
import main.interfaces.IBank;

public class Bank implements IBank {

    private IAccount estore;
    private IAccount anne, bob;

    public Bank() {
    }

    public void init() {
        estore = new Account();
        anne = new Account();
        bob = new Account();

        estore.setOwner("Estore");
        estore.setAmount(0);
        anne.setOwner("Anne");
        anne.setAmount(30);
        bob.setOwner("Bob");
        bob.setAmount(100);
    }

    @Override
    public void transfert(String from, String to, double amount) throws InsufficientBalanceException, UnknownAccountException {
        IAccount Afrom = null, Ato = null;

        if (from.equals("E-Store")) Afrom = estore;
        if (from.equals("Anne")) Afrom = anne;
        if (from.equals("Bob")) Afrom = bob;

        if (to.equals("E-Store")) Ato = estore;
        if (to.equals("Anne")) Ato = anne;
        if (to.equals("Bob")) Ato = bob;

        // Get the balance of the account to widthdraw
        double fromBalance = Afrom.getAmount();

        // Check whether the account is sufficiently balanced
        if (fromBalance < amount) throw new InsufficientBalanceException(from.toString());

        // Get the balance of the account to credit
        double toBalance = Ato.getAmount();

        // Perform the transfert
        Afrom.setAmount(fromBalance - amount);
        Ato.setAmount(toBalance + amount);
    }

}
