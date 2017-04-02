package Model;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class Stock extends stockComponent{
	private String stockName = new String();
	private String stockCode = new String();
	private LinkedList<tick> stockData = new LinkedList<tick>();
	private Data data = new onlineDataReader();
	
	private SMAIndicator shortMA = new SMAIndicator();
	private SMAIndicator midMA = new SMAIndicator();
	private SMAIndicator longMA = new SMAIndicator();
	private Date[] timePeriod;
	
	
	public Stock(String newStockName, String newStockCode, Date[] timePeriod){
		this.stockName = newStockName;
		this.stockCode = newStockCode;
		this.timePeriod = timePeriod;
		this.stockData = data.getData(this.timePeriod, this.stockCode);
	}
	
	public Stock(String newStockName, String newStockCode){
		this.stockName = newStockName;
		this.stockCode = newStockCode;
		this.stockData = data.getData(defaultTimeperiod(), this.stockCode);
	}
	
	public String getStockName(){
		return this.stockName;
	}
	
	public String getStockCode(){
		return this.stockCode;
	}
		
	public LinkedList<tick> getStockData(){
		return this.stockData;
	}
	
	public void updateTimePeriod(Date[] newTimePeriod){
		this.timePeriod = newTimePeriod;
		this.stockData = data.getData(this.timePeriod, this.stockName);
	}
	
	private Date[] defaultTimeperiod(){
		Date[] timePeriod = new Date[2];
		Calendar cal = Calendar.getInstance();
		timePeriod[1] = cal.getTime();
		cal.add(Calendar.YEAR, -1); // http://stackoverflow.com/questions/14946886/store-current-date-and-date-1-year-from-current-in-java
		timePeriod[0] = cal.getTime();
		return timePeriod;
	}
	
	public String indicatorSignal(int ma){
		return selectMA(ma).indicatorSignal();	
	}
	
	public SMAIndicator selectMA(int i){
		switch(i){
		case 21:
			return shortMA;
		case 55:
			return midMA;
		case 100:
			return longMA;
		default:
			return shortMA;
		}
	}

	public int getStockDataSize() {
		return this.stockData.size();
	}
}
