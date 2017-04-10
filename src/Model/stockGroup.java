package Model;
/*
	Created by: Gurpreet Raju
	Composite Pattern
*/
import java.util.LinkedList;

public class stockGroup extends stockComponent {
    LinkedList<stockComponent> stocklist = new LinkedList<stockComponent>();

    public void add(stockComponent newComponent) {
        this.stocklist.add(newComponent);
    }

    public void remove(stockComponent newComponent) {
        this.stocklist.remove(newComponent);
    }

    public stockComponent get(String stockName) {
        for (stockComponent s : this.stocklist) {
            if (stockName.equals(s.getStockName())) {
                return s;
            }
        }
        return null;
    }

    public int size() {
        return this.stocklist.size();
    }

    public stockComponent get(int index) {
        return this.stocklist.get(index);
    }
}
