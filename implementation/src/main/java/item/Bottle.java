package item;

public class Bottle extends Item {
    public Bottle(String inscription, String barcode, RecyclingType recyclingType, MaterialType materialType, double depositAmount) {
        super(inscription, barcode, recyclingType, materialType, depositAmount);
    }
}
