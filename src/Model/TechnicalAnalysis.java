package Model;

import java.util.Date;

import org.jfree.chart.JFreeChart;

public class TechnicalAnalysis{
	//private SMAIndicator maIndicator = new SMAIndicator();
	private LineChart chart = null;
		
	public JFreeChart performAnalysis(String companyName, Date[] timeperiod){
			chart = null;
			try{
				stockListReader newStockList = new stockListReader();
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
		stockListReader newStockList = new stockListReader();
		return newStockList.getStockList();
	}
	
	public void removeMA(int i) {
		if(chart.isSeriesExist(i)){
			chart.removeSeries(i);
		}		
	}
//	public static void main(String[] arg){
//		Date[] timePeriod = new Date[2];
//		Calendar cal = Calendar.getInstance();
//		timePeriod[1] = cal.getTime();
//		cal.add(Calendar.YEAR, -1); // http://stackoverflow.com/questions/14946886/store-current-date-and-date-1-year-from-current-in-java
//		timePeriod[0] = cal.getTime();
//		TechnicalAnalysis ta = new TechnicalAnalysis();
//		
//		JFreeChart chart = ta.performAnalysis("Alphabet Inc.", timePeriod);
//		JFrame frame = new JFrame();
//		frame.setSize(600, 400);
//		ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setSize(frame.getSize());
//        frame.add(chartPanel);
//        frame.setVisible(true);
//        String str = ta.addMA(20);
//        System.out.println(str);
//	}
}
