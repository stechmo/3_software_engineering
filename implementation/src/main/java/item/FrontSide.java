package item;

import lombok.Getter;

@Getter
public class FrontSide extends Side {
    private final Label label;

    public FrontSide(String inscription) {
        this.label = new Label(inscription);
        this.angle = 0;
    }
}
