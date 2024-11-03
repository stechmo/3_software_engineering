package hardware;

import core.MainUnit;

public class Reader {
    private MainUnit mainUnit;

    public Reader(MainUnit mainUnit) {
        this.mainUnit = mainUnit;
    }

    public void readCard(String code) {
        this.mainUnit.changeStatus(code);
    }
}
