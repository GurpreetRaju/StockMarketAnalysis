package Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

public class Data {
	
	private Date periodBeginDate;
	private Date periodEndDate;
	
	public Date getPeriodBeginDate() {
		return periodBeginDate;
	}

	public void setPeriodBeginDate(Date periodBeginDate) {
		this.periodBeginDate = periodBeginDate;
	}

	public Date getPeriodEndDate() {
		return periodEndDate;
	}

	public void setPeriodEndDate(Date periodEndDate) {
		this.periodEndDate = periodEndDate;
	}

	private class StockListNode {
		private Date date;
		private double value;
		
		public StockListNode(Date date, double value) {
			super();
			this.date = date;
			this.value = value;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}
		
	}
	
	public LinkedList<StockListNode> stock = new LinkedList <>();
	
	private LinkedList<Integer> movingAverages = new LinkedList <>();
	
	public void getData(){
		//TODO: add real data getting
		stock.add(new StockListNode(new Date(2017,02,01),200));
		stock.add(new StockListNode(new Date(2017,02,02),100));
		stock.add(new StockListNode(new Date(2017,02,03),300));
		stock.add(new StockListNode(new Date(2017,02,04),500));
	}
	
	public LinkedList<StockListNode> getDataToChart() {
		return stock;
	}
	
	public String[] getDataOnline() throws Exception {
		String[] arg = new String[10];
		
		URL oracle = new URL("http://ichart.finance.yahoo.com/table.csv?s=GOOGL&a=11&b=15&c=2016&d=11&e=27&f=2016&g=d&ignore=.csv");
        URLConnection url = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(url.getInputStream()));
        String inputLine;
        int i = 0;
        while ((inputLine = in.readLine()) != null) 
        {
        	//String[] dataCSV = inputLine.split(",");
        	/*String date = dataCSV[0];
        	float openStock = Float.parseFloat(dataCSV[1]);
        	float High = Float.valueOf(toString(dataCSV[2])).floatValue(); 
        	float Low	= Float.valueOf(dataCSV[3]).floatValue();
        	float closeStock = Float.valueOf(dataCSV[4]).floatValue();
        	int Volume = Integer.parseInt(dataCSV[5]);
        	float AdjClose = Float.valueOf(dataCSV[6]).floatValue();
        	System.out.println(openStock + " " + High + " " + Low + " " + closeStock + " " + Volume + " " + AdjClose);
        	*/
        	arg[i] = inputLine;
        	i++;
        }
        in.close();
		 
		return arg;
	}
	
	public static void main(String[] args) throws Exception{
        Data o = new Data();
        String[] str = new String[10];
        str = o.getDataOnline();
        int i=0;
        while(i!=10 && str[i]!=null){
        	System.out.println(str[i]);
        	i++;
        }
    }
}
