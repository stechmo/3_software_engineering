package ui;

import core.MainUnit;
import lombok.Setter;

@Setter
public class Display {
    private MainUnit mainUnit;
    private Button button1;
    private Button button2;

    public Display() {
        this.button1 = Button.EMPTY;
        this.button2 = Button.EMPTY;
    }

    public void print(String message) {
        System.out.println(message);
    }

    public void setButton1(Button button) {
        this.button1 = button;
        printButton(this.button1, "Button 1: ");
    }

    public void setButton2(Button button) {
        this.button2 = button;
        printButton(this.button2, "Button 2: ");
    }

    public void executeButton1() {
        switch (button1) {
            case Button.FINISH -> this.mainUnit.finish();
            case Button.DONATION -> this.mainUnit.donate();
        }
    }

    public void executeButton2() {
        if (button2 == Button.DEPOSIT_RECEIPT) this.mainUnit.depositReceipt();
    }

    private void printButton(Button button, String identification) {
        if (button != Button.EMPTY) {
            System.out.println(identification + button.getText());
        }
    }
}
