package core;



import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {
    private Map<String, DepositItem> depositItems;

    public InMemoryDatabase() {
        this.depositItems = new HashMap<>();
        for (DepositItem depositItem : DepositItem.values()) {
            this.depositItems.put(depositItem.getBarcode(), depositItem);
        }
    }

    public DepositItem getItemByBarcode(String barcode) {
        return depositItems.get(barcode);
    }
}
