package Model;

public abstract class stockComponent {

    private String stockName = new String();

    public void add(stockComponent newComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(stockComponent newComponent) {
        throw new UnsupportedOperationException();
    }

    public String getStockName() {
        return this.stockName;
    }

}
