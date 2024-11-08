package main;

import core.Database;
import hardware.Bin;
import item.*;
import processing.ItemProcessor;

public class Application {
    public static void main(String[] args) {
        Bin bin = new Bin();
        ItemProcessor disposableCanProcessor = new ItemProcessor();
        ItemProcessor disposableBottleProcessor = new ItemProcessor();
        ItemProcessor reusableBottleProcessor = new ItemProcessor();
        DepositMachine depositMachine = new DepositMachine(disposableCanProcessor, disposableBottleProcessor, reusableBottleProcessor);
        depositMachine.readCard("AAA");
        depositMachine.insertItem(new Can("R8YZ7CLKZ4"), 270);
        depositMachine.insertItem(new Can("8YZ7CLKZ4f"), 270);
        bin.throwItemIntoBin(depositMachine.removeItem());
        depositMachine.insertItem(new Bottle("XVJIX0XAUE"), 270);
        depositMachine.pressButton1();
        depositMachine.pressButton1();
    }
}
