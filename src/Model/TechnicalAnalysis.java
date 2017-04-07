package Model;

import java.util.Date;

import org.jfree.chart.JFreeChart;

public class TechnicalAnalysis{
	//private SMAIndicator maIndicator = new SMAIndicator();
	private LineChart chart = null;
	private watchList wlist = new watchList();
	private String file = "src/stocklist.csv";
		
	public JFreeChart performAnalysis(String companyName, Date[] timeperiod){
			chart = null;
			try{
				stockListReader newStockList = new stockListReader(this.file);
				//System.out.print("Chechpoint 1" + newStockList.getStockCode(companyName));
				chart = new LineChart(companyName, timeperiod, newStockList.getStockCode(companyName));
			}
			catch(Exception e){
				System.out.print("Exception" + e);
			}     
			JFreeChart jfree = chart.getChart();
			return jfree;
	}
	
	public String addMA(int i){
		if(!chart.isSeriesExist(i)){
			chart.updateDataset(i);
			String str = chart.getIndicatorSignal(i);
			return str;
		}
		return null;
	}

	public String[] getStockList(){
		stockListReader newStockList = new stockListReader(this.file);
		return newStockList.getStockList();
	}
	
	public void removeMA(int i) {
		if(chart.isSeriesExist(i)){
			chart.removeSeries(i);
		}		
	}

	public String[][] getWatchlist() {
	    return wlist.getWatchlistEntities();
	}

	public void addToWishlist(String stockName) {
		stockListReader newStockList = new stockListReader(this.file);
		wlist.addToWatchlist(stockName,newStockList.getStockCode(stockName));
	}
}
