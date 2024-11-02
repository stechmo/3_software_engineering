package item;

import lombok.Getter;

@Getter
public class BackSide extends Side {
    private final String barcode;

    public BackSide(String barcode) {
        this.barcode = barcode;
    }
}
