package hardware;

import core.MainUnit;
import item.BackSide;
import item.Item;
import item.Side;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedChute {
    private Item currentItem;
    private int currentAngle;
    private RotationUnit rotationUnit;
    private Scanner scanner;
    private MainUnit mainUnit;
    private ConveyingSystem conveyingSystem;

    public FeedChute(ConveyingSystem conveyingSystem) {
        this.rotationUnit = new RotationUnit();
        this.scanner = new Scanner();
        this.conveyingSystem = conveyingSystem;
    }

    public void insertItem(Item item, int angle) {
        this.currentItem = item;
        this.currentAngle = angle;
        this.mainUnit.insertItem(item);
    }

    public Item removeItem() {
        Item item = this.currentItem;
        this.currentItem = null;
        this.mainUnit.removeItem();
        return item;
    }

    public void turnItem() {
        this.currentAngle = this.rotationUnit.turn(this.currentAngle);
    }

    public String scanItem() {
        int indexSide = this.currentAngle / 90;
        Side[] sides = this.currentItem.getSides();
        if (sides != null) {
            Side side = this.currentItem.getSides()[indexSide];
            if (side instanceof BackSide) {
                return this.scanner.scanItem((BackSide) this.currentItem.getSides()[2]);
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    public void moveItemToDisposableCanProcessor() {
        this.conveyingSystem.processDisposableCan(this.currentItem);
        this.currentItem = null;
    }

    public void moveItemToDisposableBottleProcessor() {
        this.conveyingSystem.processDisposableBottle(this.currentItem);
        this.currentItem = null;
    }

    public void moveItemToReusableBottleProcessor() {
        this.conveyingSystem.processReusableBottle(this.currentItem);
        this.currentItem = null;
    }
}
