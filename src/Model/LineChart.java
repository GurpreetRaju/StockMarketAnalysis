package Model;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class LineChart implements Chart{

	private String chartTitle = "StockChart";
	private String xAxisLabel = "Date";
	private String yAxisLabel = "Stock price";
	private LinkedList<String[]> data;
	
	public LineChart(LinkedList<String[]> data2) {
		this.data = data2;
	}

	public JFreeChart CreateChart(){
		
		JFreeChart lineChart = ChartFactory.createTimeSeriesChart(chartTitle,
		            xAxisLabel, yAxisLabel, createDataset(),true,true,false);
	      
	      return lineChart;
	}
	
	public XYDataset createDataset(){
		TimeSeries series1 = new TimeSeries("21 Day");
		data.remove();
		while(data.size()!=0){
			String[] elt = data.remove();
			series1.add(new Day(toDate(elt[0])),Float.parseFloat(elt[1]));//pass a string date and stock price moving average value
		}
		TimeSeries series2 = new TimeSeries("55 Day");
		
		series2.add(new Day(toDate("2016-12-24")),46);
			
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);        
		dataset.addSeries(series2);
		
		return dataset;
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
	
	public static void main(String[] arg) throws Exception{
		LinkedList<String[]> list = new LinkedList<String[]>();
		Data data = new Data();
		list = data.getData();
		LineChart linechart = new LineChart(list);
		JFreeChart chart = linechart.CreateChart();
		ChartPanel chartPanel = new ChartPanel( chart );
		chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
		JFrame jFrame = new JFrame();
		jFrame.add(chartPanel);
		chartPanel.setVisible( true );
		jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jFrame.setVisible(true);
	}
		
}
