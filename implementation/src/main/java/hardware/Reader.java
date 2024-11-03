package hardware;

import core.MainUnit;
import smartphone.Smartphone;

public class Reader {
    private MainUnit mainUnit;

    public Reader(MainUnit mainUnit) {
        this.mainUnit = mainUnit;
    }

    public void readCard(String code) {
        this.mainUnit.changeStatus(code);
    }

    public void readSmartphone(Smartphone smartphone) {
        this.mainUnit.readSmartphone(smartphone);
    }
}
