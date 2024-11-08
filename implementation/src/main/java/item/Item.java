package item;

import core.Database;
import core.DatabaseItem;
import lombok.Getter;

@Getter
public abstract class Item {
    protected Side[] sides;
    protected RecyclingType recyclingType;
    protected MaterialType materialType;
    protected double depositAmount;

    public Item(String barcode) {
        DatabaseItem databaseItem = Database.INSTANCE.getDatabaseItemByBarcode(barcode);
        if(databaseItem != null) {
            this.sides = new Side[]{
                    new FrontSide(databaseItem.getInscription()),
                    new OtherSide(90),
                    new BackSide(barcode),
                    new OtherSide(270)
            };
            this.recyclingType = databaseItem.getRecyclingType();
            this.materialType = databaseItem.getMaterialType();
            this.depositAmount = databaseItem.getDepositAmount();
        }

    }
}
