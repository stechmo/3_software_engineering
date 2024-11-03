package main;

import core.InMemoryDatabase;
import core.MainUnit;
import hardware.FeedChute;
import hardware.LedElement;
import hardware.Reader;
import item.Item;
import ui.Display;

public class DepositMachine {
    private InMemoryDatabase inMemoryDatabase;
    private LedElement ledElement;
    private Reader reader;
    private Display display;
    private FeedChute feedChute;
    private MainUnit mainUnit;

    public DepositMachine() {
        this.inMemoryDatabase = new InMemoryDatabase();
        this.ledElement = new LedElement();
        this.display = new Display();
        this.feedChute = new FeedChute();
        this.mainUnit = new MainUnit(this.inMemoryDatabase, this.ledElement, this.display, this.feedChute, this.hashCode());
        this.display.setMainUnit(this.mainUnit);
        this.feedChute.setMainUnit(this.mainUnit);
        this.reader = new Reader(this.mainUnit);
    }

    public void readCard(String code) {
        this.reader.readCard(code);
    }

    public void insertItem(Item item, int angle) {
        this.feedChute.insertItem(item, angle);
    }
}
