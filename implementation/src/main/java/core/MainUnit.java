package core;

import hardware.FeedChute;
import item.Item;
import item.MaterialType;
import item.RecyclingType;
import other.State;
import smartphone.Smartphone;
import ui.Button;
import ui.Display;
import ui.LED;
import ui.LedElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainUnit {
    private List<String> workerIDs;
    private State state;
    private final Display display;
    private final LedElement led;
    private final FeedChute feedChute;
    private final InMemoryDatabase inMemoryDatabase;
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
    private final int hashCode;
    private List<String> donations;

    public MainUnit(InMemoryDatabase inMemoryDatabase, LedElement led, Display display, FeedChute feedChute, int hashCode) {
        this.workerIDs = Arrays.asList("AAA", "AAB", "AAC");
        this.display = display;
        this.led = led;
        this.feedChute = feedChute;
        this.inMemoryDatabase = inMemoryDatabase;
        setLocked("Locked");
        resetUnit();
        this.seq = 0;
        this.hashCode = hashCode;
        this.donations = new ArrayList<>();
    }

    public void insertItem(Item item) {
        if (this.state == State.READY) {
            setLocked("Processing item | please wait.");
            this.display.setButton1(Button.EMPTY);
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
                        if (itemInfos.getMaterialType() == MaterialType.METAL) {
                            this.disposableItems++;
                            this.disposableAmount += itemInfos.getDepositAmount();
                            this.feedChute.moveItemToDisposableCanProcessor();
                        } else {
                            if (itemInfos.getRecyclingType() == RecyclingType.REUSABLE) {
                                this.reusableItems++;
                                this.reusableAmount += itemInfos.getDepositAmount();
                                this.feedChute.moveItemToReusableBottleProcessor();
                            } else if (itemInfos.getRecyclingType() == RecyclingType.DISPOSABLE) {
                                this.disposableItems++;
                                this.disposableAmount += itemInfos.getDepositAmount();
                                this.feedChute.moveItemToDisposableBottleProcessor();
                            }
                        }
                    }
                    this.totalAmount += itemInfos.getDepositAmount();
                    setReady(itemInfos.getLabel() + " | "
                            + itemInfos.getRecyclingType().getType() + " | "
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
        System.out.println("item is removed");
        if (this.totalAmount == 0) {
            setReady("Ready");
        } else if (this.totalAmount > 0) {
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

        this.receipt = "-----------Receipt-----------" +
                "Seq: " + this.seq + "\n" +
                formattedDateTime + "\n" +
                "Serialnumber: " + this.hashCode + "\n" +
                "#inserted items: " + this.insertedItems + "\n" +
                "#accepted items: " + this.acceptedItems + "\n" +
                "#disposable: " + this.disposableItems + " (" + this.disposableAmount + " €)\n" +
                "#reusable: " + this.reusableItems + " (" + this.reusableAmount + " €)\n" +
                "#non-accepted items: " + this.nonAcceptedItems + "\n" +
                "> total: " + this.totalAmount + " €\n" +
                "-----------Receipt-----------";

        this.display.print("Possible actions:");
        this.display.setButton1(Button.DONATION);
        this.display.setButton2(Button.DEPOSIT_RECEIPT);
    }

    public void donate() {
        this.donations.add(this.receipt);
        System.out.println(this.receipt);
        resetUnit();
        setReady("Ready");
    }

    public void depositReceipt() {
        setWaiting("place your smartphone on reader");
    }

    public void readSmartphone(Smartphone smartphone) {
        smartphone.addReceipt(this.receipt);
        System.out.println(this.receipt);
        resetUnit();
        setReady("Ready");
    }

    private void resetUnit() {
        this.display.setButton1(Button.EMPTY);
        this.display.setButton2(Button.EMPTY);
        this.insertedItems = 0;
        this.acceptedItems = 0;
        this.disposableItems = 0;
        this.reusableItems = 0;
        this.nonAcceptedItems = 0;
        this.disposableAmount = 0;
        this.reusableAmount = 0;
        this.totalAmount = 0;
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
