package main;

import core.DepositItem;
import core.InMemoryDatabase;
import hardware.LED;
import hardware.RotationUnit;

public class DepositMachine {
    private InMemoryDatabase inMemoryDatabase;
    private LED led;
    private RotationUnit rotationUnit;

    public DepositMachine() {
        this.inMemoryDatabase = new InMemoryDatabase();
        this.led = LED.RED;
        this.rotationUnit = new RotationUnit();
    }
}
