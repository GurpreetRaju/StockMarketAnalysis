package Model;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class Stock extends stockComponent {
    private String stockName = new String();
    private String stockCode = new String();
    private LinkedList<tick> stockData = new LinkedList<tick>();
    private Data data;

    private SMAIndicator[] maList = new SMAIndicator[3];
    private Date[] timePeriod;

    public Stock() {
        this.stockCode = "";
        this.stockName = "File";
        this.timePeriod = defaultTimeperiod();
        data = new CSVFileReader();
        this.stockData = data.getData();
        initIndicators();
    }

    public Stock(String newStockName, String newStockCode, Date[] timePeriod) {
        this.stockName = newStockName;
        this.stockCode = newStockCode;
        this.timePeriod = timePeriod;
        data = new onlineDataReaderAdapter(this.timePeriod, this.stockCode, new GoogleAPIData());
        this.stockData = data.getData();
        initIndicators();
    }

    public Stock(String newStockName, String newStockCode) {
        this.stockName = newStockName;
        this.stockCode = newStockCode;
        System.out.println(newStockCode);
        this.timePeriod = defaultTimeperiod();
        data = new onlineDataReaderAdapter(this.timePeriod, this.stockCode, new GoogleAPIData());
        this.stockData = data.getData();
        initIndicators();
    }

    private void initIndicators() {
        this.maList[0] = new SMAIndicator(this.stockData, 20);
        this.maList[1] = new SMAIndicator(this.stockData, 55);
        this.maList[2] = new SMAIndicator(this.stockData, 100);
    }

    public String getStockName() {
        return this.stockName;
    }

    public String getStockCode() {
        return this.stockCode;
    }

    public LinkedList<tick> getStockData() {
        return this.stockData;
    }

    public void updateTimePeriod(Date[] newTimePeriod) {
        this.timePeriod = newTimePeriod;
        this.stockData = this.data.getData();
    }

    private Date[] defaultTimeperiod() {
        Date[] timePeriod = new Date[2];
        Calendar cal = Calendar.getInstance();
        timePeriod[1] = cal.getTime();
        cal.add(Calendar.YEAR, -1); // http://stackoverflow.com/questions/14946886/store-current-date-and-date-1-year-from-current-in-java
        timePeriod[0] = cal.getTime();
        return timePeriod;
    }

    public String indicatorSignal(int d) {
        String trade = "none";
        tick otick = this.stockData.getFirst();
        //System.out.print(maList[0].getMAList().size());
        if (d == 20) {
            trade = getIndicator(otick, maList[0].get(maList[0].size() - 1), maList[0].get(maList[0].size() - 2));
        } else if (d == 55) {
            SMAIndicator sma1 = this.getMA(20);
            trade = this.getIndicator(otick, sma1.get(sma1.size() - 1), (maList[1].getSameDateNode(otick)), maList[1].get(maList[1].size() - 2));
        } else if (d == 100) {
            SMAIndicator sma1 = this.getMA(55);
            trade = this.getIndicator(otick, sma1.get(sma1.size() - 1), maList[2].getSameDateNode(otick), maList[2].get(maList[2].size() - 2));
        } else if (d == 20100) {
            SMAIndicator sma1 = this.getMA(20);
            SMAIndicator sma2 = this.getMA(100);
            trade = this.getIndicator(otick, sma1.get(sma1.size() - 1), sma2.getSameDateNode(otick), sma2.get(sma2.size() - 2));
        }
        return trade;
    }

    public String indicatorSignal() {
        String trade = new String();
        tick otick = stockData.getFirst();
        System.out.println("checkpoint" + otick.getData());
        trade = getIndicator(otick, this.getMA(20).getSameDateNode(otick), this.getMA(100).getSameDateNode(otick), this.getMA(100).get(getMA(100).size() - 2));
        return trade;
    }

    private String getIndicator(tick currentData, tick currentAv, tick recentAv) {
        System.out.println(recentAv.getData() + " " + currentAv.getData() + " " + currentData.getData());
        if (recentAv.getData() < currentAv.getData() && currentAv.getData() < currentData.getData()) {
            return "buy";
        } else if (recentAv.getData() > currentAv.getData() && currentAv.getData() > currentData.getData()) {
            return "sell";
        }
        return "none";
    }

    private String getIndicator(tick currentData, tick currentsmallAv, tick currentAv, tick recentAv) {
        System.out.println(recentAv.getData() + " " + currentAv.getData() + " " + currentData.getData());
        if (recentAv.getData() < currentAv.getData() && currentAv.getData() < currentData.getData() && currentAv.getData() < currentsmallAv.getData()) {
            return "buy";
        } else if (recentAv.getData() > currentAv.getData() && currentAv.getData() > currentData.getData() && currentAv.getData() > currentsmallAv.getData()) {
            return "sell";
        }
        return "keep";
    }

    public int getStockDataSize() {
        return this.stockData.size();
    }

    public LinkedList<tick> calculateMA(int i) {
        SMAIndicator sm = getMA(i);
        return sm.getMAList();
    }

    private SMAIndicator getMA(int ma) {
        switch (ma) {
            case 20:
                return this.maList[0];
            case 55:
                return this.maList[1];
            case 100:
                return this.maList[2];
        }
        return null;
    }

//	public static void main(String[] arg){
//		Stock s = new Stock("Google","GOOG");
//		System.out.println(s.indicatorSignal(20));
//	}
}
