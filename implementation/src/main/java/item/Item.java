package item;

import lombok.Getter;

@Getter
public abstract class Item {
    protected Side[] sides;

    public Item(String inscription, String barcode) {
        this.sides = new Side[]{
                new FrontSide(inscription),
                new OtherSide(90),
                new BackSide(barcode),
                new OtherSide(270)
        };
    }
}
