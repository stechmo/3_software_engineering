package smartphone;

import java.util.ArrayList;
import java.util.List;

public class Smartphone {
    private List<String> wallet;
    public Smartphone() {
        this.wallet = new ArrayList<>();
    }

    public void addReceipt(String receipt) {
        this.wallet.add(receipt);
    }
}
