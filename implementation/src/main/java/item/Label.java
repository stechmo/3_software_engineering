package item;

import lombok.Getter;

@Getter
public class Label {
    String inscription;

    public Label(String inscription) {
        this.inscription = inscription;
    }
}
