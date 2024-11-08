package main;

import core.DepositItem;
import hardware.Bin;
import item.Bottle;
import item.Can;
import processing.ItemProcessor;

public class Application {
    public static void main(String[] args) {
        Bin bin = new Bin();
        ItemProcessor disposableCanProcessor = new ItemProcessor();
        ItemProcessor disposableBottleProcessor = new ItemProcessor();
        ItemProcessor reusableBottleProcessor = new ItemProcessor();
        DepositMachine depositMachine = new DepositMachine(disposableCanProcessor, disposableBottleProcessor, reusableBottleProcessor);
        depositMachine.readCard("AAA");
        depositMachine.insertItem(new Can(DepositItem.R8YZ7CLKZ4.getLabel(), DepositItem.R8YZ7CLKZ4.getBarcode()), 270);
        depositMachine.insertItem(new Can(DepositItem.R8YZ7CLKZ4.getLabel(), "8YZ7CLKZ4f"), 270);
        bin.throwItemIntoBin(depositMachine.removeItem());
        depositMachine.pressButton1();
        depositMachine.pressButton1();
    }
}
