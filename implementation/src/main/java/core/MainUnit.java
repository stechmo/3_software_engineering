package core;

import hardware.FeedChute;
import hardware.LedElement;
import item.Item;
import other.State;
import ui.Button;
import ui.LED;
import ui.Display;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class MainUnit {
    private List<String> workerIDs;
    private State state;
    private Display display;
    private LedElement led;
    private FeedChute feedChute;
    private InMemoryDatabase inMemoryDatabase;
    private int insertedItems;
    private int acceptedItems;
    private int disposableItems;
    private int reusableItems;
    private int nonAcceptedItems;
    private double disposableAmount;
    private double reusableAmount;
    private double totalAmount;
    private String receipt;
    private int seq;
    private int hashCode;

    public MainUnit(InMemoryDatabase inMemoryDatabase, LedElement led, Display display, FeedChute feedChute, int hashCode) {
        this.workerIDs = Arrays.asList("AAA", "AAB", "AAC");
        this.display = display;
        this.led = led;
        this.feedChute = feedChute;
        this.inMemoryDatabase = inMemoryDatabase;
        setLocked("Locked");
        this.insertedItems =  0;
        this.acceptedItems = 0;
        this.disposableItems = 0;
        this.reusableItems = 0;
        this.nonAcceptedItems = 0;
        this.disposableAmount = 0;
        this.reusableAmount = 0;
        this.totalAmount = 0;
        this.seq = 0;
        this.hashCode = hashCode;
    }

    public void insertItem(Item item) {
        if (this.state == State.READY) {
            setLocked("Processing item | please wait.");
            this.display.setButton1(null);
            while (this.feedChute.getCurrentAngle() != 180) {
                this.feedChute.turnItem();
            }
            String barcode = this.feedChute.scanItem();
            if (barcode != null) {
                DepositItem itemInfos = this.inMemoryDatabase.getItemByBarcode(barcode);
                if (itemInfos == null) {
                    setWaiting("Please remove item from insertion slot.");
                } else {
                    this.insertedItems++;
                    if (itemInfos.getDepositAmount() == 0) {
                        this.nonAcceptedItems++;
                    } else {
                        this.acceptedItems++;
                        if (itemInfos.getMaterialType() == "Metal") {
                            this.disposableItems++;
                            this.disposableAmount += itemInfos.getDepositAmount();
                        //komprimieren
                        } else {
                            if(itemInfos.getRecyclingType() == "Reusable") {
                                this.reusableItems++;
                                this.reusableAmount += itemInfos.getDepositAmount();
                                //mehrweg-Schritt

                            } else if (itemInfos.getRecyclingType() == "Deposable") {
                                this.disposableItems++;
                                this.disposableAmount += itemInfos.getDepositAmount();
                                //zerkleinern
                            }
                        }
                    }
                    this.totalAmount += itemInfos.getDepositAmount();
                    setReady(itemInfos.getLabel() + " | "
                            + itemInfos.getRecyclingType() + " | "
                            + itemInfos.getDepositAmount() + " | "
                            + this.insertedItems + " | "
                            + this.acceptedItems + " | "
                            + this.disposableItems + " | "
                            + this.reusableItems + " | "
                            + this.nonAcceptedItems + " | "
                            + this.totalAmount + " €"
                    );
                    this.display.print("Possible action:");
                    this.display.setButton1(Button.FINISH);
                }
            }
        }
    }

    public void removeItem() {
        if(this.totalAmount == 0) {
            setReady("Ready");
        } else {
            setReady("Possible action:");
            this.display.setButton1(Button.FINISH);
        }
    }

    public void changeStatus(String code) {
        if (workerIDs.contains(code)) {
            if (this.state == State.LOCKED) {
                setReady("Ready");
            } else if (this.state == State.READY) {
                setLocked("Locked");
            }
        }
    }

    public void finish() {
        this.seq++;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        this.receipt = "Seq: " + this.seq + "\n" +
                formattedDateTime + "\n" +
                "Serialnumber: " + this.hashCode + "\n" +
                "#inserted items: " + this.insertedItems + "\n" +
                "#accepted items: " + this.acceptedItems + "\n" +
                "#disposable: " + this.disposableItems + " (" + this.disposableAmount + " €)\n" +
                "#reusable: " + this.reusableItems + " (" + this.reusableAmount + " €)\n" +
                "#non-accepted items: " + this.nonAcceptedItems + "\n" +
                "> total: " + this.totalAmount + " €";
        
        this.display.print("Possible actions:");
        this.display.setButton1(Button.DONATION);
        this.display.setButton2(Button.DEPOSIT_RECEIPT);
    }

    private void setReady(String message) {
        this.display.print(message);
        this.led.setLed(LED.GREEN);
        this.state = State.READY;
    }

    private void setLocked(String message) {
        this.display.print(message);
        this.led.setLed(LED.RED);
        this.state = State.LOCKED;
    }

    private void setWaiting(String message) {
        this.display.print(message);
        this.led.setLed(LED.YELLOW);
        this.state = State.WAITING;
    }
}
