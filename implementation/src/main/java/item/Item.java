package item;

import lombok.Getter;

@Getter
public abstract class Item {
    protected Side[] sides;
    protected RecyclingType recyclingType;
    protected MaterialType materialType;
    protected double depositAmount;

    public Item(String inscription, String barcode, RecyclingType recyclingType, MaterialType materialType, double depositAmount) {
        this.sides = new Side[]{
                new FrontSide(inscription),
                new OtherSide(90),
                new BackSide(barcode),
                new OtherSide(270)
        };
        this.recyclingType = recyclingType;
        this.materialType = materialType;
        this.depositAmount = depositAmount;
    }
}
