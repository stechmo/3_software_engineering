package item;

import lombok.Getter;

@Getter
public enum MaterialType {
    METAL("Metal"),
    GLASS("Glass"),
    PLASTIC("Plastic");

    private String type;

    MaterialType(String type) {
        this.type = type;
    }
}
