package hardware;

import item.BackSide;

public class Scanner {
    public String scanItem(BackSide side) {
        return side.getBarcode();
    }
}
