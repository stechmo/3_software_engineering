package main;

import core.DepositItem;
import core.InMemoryDatabase;

public class DepositMachine {
    InMemoryDatabase inMemoryDatabase;

    public DepositMachine() {
        this.inMemoryDatabase = new InMemoryDatabase();
    }
}
