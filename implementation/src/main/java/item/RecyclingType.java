package item;

import lombok.Getter;

@Getter
public enum RecyclingType {
    DISPOSABLE("Disposable"),
    REUSABLE("Reusable");

    private String type;
    RecyclingType(String type) {
        this.type = type;
    }
}
