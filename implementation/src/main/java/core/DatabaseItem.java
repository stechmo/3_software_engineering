package core;

import item.MaterialType;
import item.RecyclingType;
import lombok.Getter;

@Getter
public class DatabaseItem {

    private String inscription;
    private String barcode;
    private RecyclingType recyclingType;
    private MaterialType materialType;
    private double depositAmount;

    public DatabaseItem(String inscription, String barcode, RecyclingType recyclingType, MaterialType materialType, double depositAmount) {
        this.inscription = inscription;
        this.barcode = barcode;
        this.recyclingType = recyclingType;
        this.materialType = materialType;
        this.depositAmount = depositAmount;
    }
}
