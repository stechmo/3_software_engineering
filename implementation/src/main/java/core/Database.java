package core;

import item.*;

import java.util.HashMap;

public enum Database {
    INSTANCE;

    HashMap<String, DatabaseItem> items;
    Database() {
        this.items = new HashMap<>();
        this.items.put("R8YZ7CLKZ4", new DatabaseItem("ABC Can | 0.33L", "R8YZ7CLKZ4", RecyclingType.DISPOSABLE, MaterialType.METAL, 0.25));
        this.items.put("TMVKRW69LE", new DatabaseItem("ABC Can | 0.5L", "TMVKRW69LE", RecyclingType.DISPOSABLE, MaterialType.METAL, 0.25));
        this.items.put("BZFI339NSY", new DatabaseItem("DE Bottle | 0.33L", "BZFI339NSY", RecyclingType.REUSABLE, MaterialType.GLASS, 0.25));
        this.items.put("J3DWML7W52", new DatabaseItem("DE Bottle | 0.5L", "J3DWML7W52", RecyclingType.REUSABLE, MaterialType.GLASS, 0.30));
        this.items.put("XP0KCVB7C", new DatabaseItem("DE Bottle | 0.75L", "XP0KCVB7C", RecyclingType.REUSABLE, MaterialType.GLASS, 0.50));
        this.items.put("XVJIX0XAUE", new DatabaseItem("DE Bottle | 1L", "XVJIX0XAUE", RecyclingType.REUSABLE, MaterialType.GLASS, 0.75));
        this.items.put("JS92HP13RP", new DatabaseItem("FG Bottle | 0.5L", "JS92HP13RP", RecyclingType.DISPOSABLE, MaterialType.PLASTIC, 1.00));
        this.items.put("HG9RQV5", new DatabaseItem("FG Bottle | 1L", "HG9RQV5", RecyclingType.DISPOSABLE, MaterialType.PLASTIC, 2.00));
    }

    public DatabaseItem getDatabaseItemByBarcode(String barcode) {
        return items.get(barcode);
    }
}
