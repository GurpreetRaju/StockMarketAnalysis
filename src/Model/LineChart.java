package Model;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class LineChart implements Chart{

	private String chartTitle = "StockChart";
	private String xAxisLabel = "Date";
	private String yAxisLabel = "Stock price";
	//private static Plot plot = (XYPlot) new Plot();
	private String[] timePeriod = new String[2];
	private String company = new String();
	private LinkedList<String[]> data;
	
	private JFreeChart lineChart;
	private TimeSeriesCollection dataset;
	
	public LineChart(String company, String[] time, String companyName) {
		this.chartTitle = company;
		this.timePeriod = time;
		this.company = companyName;
		Data stockData = new Data();
		try {
			this.data = stockData.getData(this.timePeriod, this.company);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createChart();
	}

	private void createChart(){
		
		lineChart = ChartFactory.createTimeSeriesChart(chartTitle,
		            xAxisLabel, yAxisLabel, createDataset(),true,true,false);
		//System.out.println("Done Creating chart");
	}
	
	public JFreeChart getChart(){
		return lineChart;
	}
	
	public TimeSeriesCollection createDataset(){
		System.out.println("Creating dataset");
		TimeSeries series1 = new TimeSeries("Stock");
		int i = 0;
		while(i<data.size()){
			String[] elt = data.get(i);
			series1.add(new Day(toDate(elt[0])),Float.parseFloat(elt[4]));//pass a string date and stock price moving average value
			i++;
		}
		
		dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);        
		
		return dataset;
	}
	
	public void updateDataset(int n){
		
		LinkedList<String[]> listMA = new SMAIndicator().calculateMA(data, n);
		
		TimeSeries series2 = new TimeSeries(n + " Day MA");
		
		while(!listMA.isEmpty())
		{
			String[] elt2 = listMA.remove();
			((TimeSeries) series2).add(new Day(toDate(elt2[0])),Float.parseFloat(elt2[1]));
		}
		TimeSeriesCollection dataset = (TimeSeriesCollection) lineChart.getXYPlot().getDataset();
		dataset.addSeries(series2);
		lineChart.getXYPlot().setDataset(dataset);
	}
	
	
	private Date toDate(String dateString){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
	    Date date = null;
	    try {
	    	System.out.println(dateString);
	        date = df.parse(dateString);
	        String newDateString = df.format(date);
	        System.out.println(newDateString);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
		return date;
	}
		
}
