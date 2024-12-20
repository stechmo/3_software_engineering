package main;

import core.MainUnit;
import hardware.ConveyingSystem;
import hardware.FeedChute;
import processing.ItemProcessor;
import ui.LedElement;
import hardware.Reader;
import item.Item;
import smartphone.Smartphone;
import ui.Display;

public class DepositMachine {
    private LedElement ledElement;
    private Reader reader;
    private Display display;
    private FeedChute feedChute;
    private MainUnit mainUnit;
    private ConveyingSystem conveyingSystem;

    public DepositMachine(ItemProcessor disposableCanProcessor, ItemProcessor disposableBottleProcessor, ItemProcessor reusableBottleProcessor) {
        this.ledElement = new LedElement();
        this.display = new Display();
        this.conveyingSystem = new ConveyingSystem(disposableCanProcessor, disposableBottleProcessor, reusableBottleProcessor);
        this.feedChute = new FeedChute(this.conveyingSystem);
        this.mainUnit = new MainUnit(this.ledElement, this.display, this.feedChute, this.hashCode());
        this.display.setMainUnit(this.mainUnit);
        this.feedChute.setMainUnit(this.mainUnit);
        this.reader = new Reader(this.mainUnit);
    }

    public void readCard(String code) {
        this.reader.readCard(code);
    }

    public void readSmartphone(Smartphone smartphone) {
        this.reader.readSmartphone(smartphone);
    }

    public void insertItem(Item item, int angle) {
        this.feedChute.insertItem(item, angle);
    }

    public Item removeItem() {
        return this.feedChute.removeItem();
    }

    public void pressButton1() {
        this.display.executeButton1();
    }

    public void pressButton2() {
        this.display.executeButton2();
    }
}
