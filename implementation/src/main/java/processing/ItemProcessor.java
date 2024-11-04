package processing;

import item.Item;
import util.CustomStack;

public class ItemProcessor {
    protected CustomStack<Item> container;
    public ItemProcessor() {
        this.container = new CustomStack<>(100);
    }

    public void addItem(Item item) {
        this.container.push(item);
    }
}
