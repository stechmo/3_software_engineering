package core;

import item.MaterialType;
import item.RecyclingType;
import lombok.Getter;

@Getter
public enum DepositItem {
    // accepted
    R8YZ7CLKZ4("R8YZ7CLKZ4", "ABC Can | 0.33L", RecyclingType.DISPOSABLE, MaterialType.METAL, 0.25),
    TMVKRW69LE("TMVKRW69LE", "ABC Can | 0.5L", RecyclingType.DISPOSABLE, MaterialType.METAL, 0.25),
    BZFI339NSY("BZFI339NSY", "DE Bottle | 0.33L", RecyclingType.REUSABLE, MaterialType.GLASS, 0.25),
    J3DWML7W52("J3DWML7W52", "DE Bottle | 0.5L", RecyclingType.REUSABLE, MaterialType.GLASS, 0.30),
    XP0KCVB7C("XP0KCVB7C", "DE Bottle | 0.75L", RecyclingType.REUSABLE, MaterialType.GLASS, 0.50),
    XVJIX0XAUE("XVJIX0XAUE", "DE Bottle | 1L", RecyclingType.REUSABLE, MaterialType.GLASS, 0.75),
    JS92HP13RP("JS92HP13RP", "FG Bottle | 0.5L", RecyclingType.DISPOSABLE, MaterialType.PLASTIC, 1.00),
    HG9RQV5("HG9RQV5", "FG Bottle | 1L", RecyclingType.DISPOSABLE, MaterialType.PLASTIC, 2.00),

    // not accepted
    _3A6MR6O7SL("3A6MR6O7SL", "X Can | 0.5L", RecyclingType.DISPOSABLE, MaterialType.METAL, 0.0),
    HA3PVEN757("HA3PVEN757", "Y Bottle | 0.33L", RecyclingType.REUSABLE, MaterialType.GLASS, 0.0),
    _447DS7U9J4("447DS7U9J4", "Y Bottle | 0.5L", RecyclingType.REUSABLE, MaterialType.GLASS, 0.0),
    _5HQOA0EAN4("5HQOA0EAN4", "Y Bottle | 1L", RecyclingType.REUSABLE, MaterialType.GLASS, 0.0),
    J03EIQTM2T("J03EIQTM2T", "Z Bottle | 0.33L", RecyclingType.REUSABLE, MaterialType.PLASTIC, 0.0),
    _5JRSQEG201("5JRSQEG201", "Z Bottle | 0.5L", RecyclingType.REUSABLE, MaterialType.PLASTIC, 0.0),
    PV4OG90YMI("PV4OG90YMI", "Z Bottle | 1L", RecyclingType.REUSABLE, MaterialType.PLASTIC, 0.0);

    private final String barcode;
    private final String label;
    private final RecyclingType recyclingType;
    private final MaterialType materialType;
    private final double depositAmount;

    DepositItem(String barcode, String label, RecyclingType recyclingType, MaterialType materialType, double depositAmount) {
        this.barcode = barcode;
        this.label = label;
        this.recyclingType = recyclingType;
        this.materialType = materialType;
        this.depositAmount = depositAmount;
    }
}
