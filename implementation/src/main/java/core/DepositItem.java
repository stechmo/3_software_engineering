package core;

import lombok.Getter;

@Getter
public enum DepositItem {
    R8YZ7CLKZ4("R8YZ7CLKZ4", "ABC Can | 0.33L", "Einweg", "Metall", 0.25),
    TMVKRW69LE("TMVKRW69LE", "ABC Can | 0.5L", "Einweg", "Metall", 0.25),
    BZFI339NSY("BZFI339NSY", "DE Bottle | 0.33L", "Mehrweg", "Glas", 0.25),
    J3DWML7W52("J3DWML7W52", "DE Bottle | 0.5L", "Mehrweg", "Glas", 0.30),
    XP0KCVB7C("XP0KCVB7C", "DE Bottle | 0.75L", "Mehrweg", "Glas", 0.50),
    XVJIX0XAUE("XVJIX0XAUE", "DE Bottle | 1L", "Mehrweg", "Glas", 0.75),
    JS92HP13RP("JS92HP13RP", "FG Bottle | 0.5L", "Einweg", "Plastik", 1.00),
    HG9RQV5("HG9RQV5", "FG Bottle | 1L", "Einweg", "Plastik", 2.00);

    private final String barcode;
    private final String label;
    private final String recyclingType;
    private final String materialType;
    private final double depositAmount;

    DepositItem(String barcode, String label, String recyclingType, String materialType, double depositAmount) {
        this.barcode = barcode;
        this.label = label;
        this.recyclingType = recyclingType;
        this.materialType = materialType;
        this.depositAmount = depositAmount;
    }
}