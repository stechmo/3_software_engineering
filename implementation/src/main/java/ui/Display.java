package ui;

import core.MainUnit;
import lombok.Setter;
import ui.Button;

@Setter
public class Display {
    private MainUnit mainUnit;
    private Button button1;
    private Button button2;
    public void print(String message) {
        System.out.println(message);
    }

    public void setButton1(Button button) {
        this.button1 = button;
        printButton(this.button1);
    }

    public void setButton2(Button button) {
        this.button2 = button;
        printButton(this.button2);
    }

    public void executeButton1() {
        switch (button1) {
            case Button.FINISH -> this.mainUnit.finish();
        }
    }

    private void printButton(Button button) {
        switch (button) {
            case Button.FINISH -> System.out.println("Finish");
            case Button.DONATION -> System.out.println("Donation");
            case Button.DEPOSIT_RECEIPT -> System.out.println("Deposit receipt");
        }
    }
}
