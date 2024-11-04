package ui;

import lombok.Getter;

@Getter
public enum Button {
    FINISH("Finish"),
    DONATION("Donate"),
    DEPOSIT_RECEIPT("Deposit receipt");

    private String text;

    Button(String text) {
        this.text = text;
    }
}
