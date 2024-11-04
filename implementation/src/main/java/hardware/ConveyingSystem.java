package hardware;

import item.Item;
import processing.ItemProcessor;

public class ConveyingSystem {
    private final ItemProcessor disposableCanProcessor;
    private final ItemProcessor disposableBottleProcessor;
    private final ItemProcessor reusableBottleProcessor;

    public ConveyingSystem(ItemProcessor disposableCanProcessor, ItemProcessor disposableBottleProcessor, ItemProcessor reusableBottleProcessor) {
        this.disposableCanProcessor = disposableCanProcessor;
        this.disposableBottleProcessor = disposableBottleProcessor;
        this.reusableBottleProcessor = reusableBottleProcessor;
    }

    public void processDisposableCan(Item item) {
        this.disposableCanProcessor.addItem(item);
    }

    public void  processDisposableBottle(Item item) {
        this.disposableBottleProcessor.addItem(item);
    }

    public void processReusableBottle(Item item) {
        this.reusableBottleProcessor.addItem(item);
    }
}
