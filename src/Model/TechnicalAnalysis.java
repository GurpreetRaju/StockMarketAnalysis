package Model;

import org.jfree.chart.JFreeChart;

import java.util.Date;

public class TechnicalAnalysis {
    //private SMAIndicator maIndicator = new SMAIndicator();
    private LineChart chart = null;
    private watchList wlist = new watchList();
    private String stockfile = "src/stocklist.csv";
    stockListReader newStockList = new stockListReader(this.stockfile);
    
    public JFreeChart performAnalysis(){
      	chart = new LineChart();
    	return chart.getChart();
    }

    public JFreeChart performAnalysis(String companyName, Date[] timeperiod) {
        chart = null;
        try {
            //stockListReader newStockList = new stockListReader(this.stockfile);
            chart = new LineChart(companyName, timeperiod, newStockList.getStockCode(companyName));
        } catch (Exception e) {
            System.out.print("Exception" + e);
        }
        JFreeChart jfree = chart.getChart();
        return jfree;
    }
    

    public String addMA(int i) {
        if (!chart.isSeriesExist(i)) {
            chart.updateDataset(i);
            String str = chart.getIndicatorSignal(i);
            return str;
        }
        return null;
    }

    public String[] getStockList() {

        return newStockList.getStockList();
    }

    public void removeMA(int i) {
        if (chart.isSeriesExist(i)) {
            chart.removeSeries(i);
        }
    }

    public String[][] getWatchlist() {
        return wlist.getWatchlistEntities();
    }

    public void addToWishlist(String stockName) {
        wlist.addToWatchlist(stockName, newStockList.getStockCode(stockName));
    }

    public void removeFromWatchlist(String[] delstock) {
        wlist.removeFromWatchList(delstock);
    }
}
