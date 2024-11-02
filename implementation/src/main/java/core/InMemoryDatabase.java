package core;


import java.util.Map;

public class InMemoryDatabase {
    private Map<String, DepositItem> depositItems;

    public InMemoryDatabase() {
        for (DepositItem depositItem : DepositItem.values()) {
            this.depositItems.put(depositItem.getBarcode(), depositItem);
        }
    }

    public DepositItem getItemByBarcode(String barcode) {
        return depositItems.get(barcode);
    }
}
