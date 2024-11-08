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
        Item item = Database.INSTANCE.getDatabaseItemByBarcode("R8YZ7CLKZ4");
        depositMachine.insertItem(new Can(((FrontSide) item.getSides()[0]).getLabel().getInscription(), ((BackSide) item.getSides()[2]).getBarcode(), item.getRecyclingType(), item.getMaterialType(), item.getDepositAmount()), 270);
        depositMachine.insertItem(new Can("Blabla", "8YZ7CLKZ4f", RecyclingType.REUSABLE, MaterialType.GLASS, 4.50), 270);
        bin.throwItemIntoBin(depositMachine.removeItem());
        item = Database.INSTANCE.getDatabaseItemByBarcode("XVJIX0XAUE");
        depositMachine.insertItem(new Bottle(((FrontSide) item.getSides()[0]).getLabel().getInscription(), ((BackSide) item.getSides()[2]).getBarcode(), item.getRecyclingType(), item.getMaterialType(), item.getDepositAmount()), 270);
        depositMachine.pressButton1();
        depositMachine.pressButton1();
    }
}
