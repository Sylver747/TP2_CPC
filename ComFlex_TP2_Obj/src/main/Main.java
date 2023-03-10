package main;

import main.Impl.Bank;
import main.Impl.Client;
import main.Impl.Provider;
import main.Impl.Store;

public class Main {
    public static void main(String[] args) {
        Provider prov = new Provider();
        Bank bank = new Bank();
        bank.init();

        Store store = new Store();
        store.init(prov, bank);

        Client cl = new Client();
        cl.init(store, store);

        cl.run();
    }
}
