package Model;

import org.jfree.chart.ChartPanel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class LineChart extends ApplicationFrame{

	private String chartTitle = "StockChart";
	private String xAxisLabel = "Date";
	private String yAxisLabel = "Stock price";
	
	public LineChart(){
		super("LineChart");
		//this.chartTitle = ChartName;
		CreateChart();
	}
	
	public void CreateChart(){
		
		JFreeChart lineChart = ChartFactory.createTimeSeriesChart(chartTitle,
		            xAxisLabel, yAxisLabel, createDataset(),true,true,false);
	         
	      ChartPanel chartPanel = new ChartPanel( lineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      setContentPane( chartPanel );
	}
	
	public XYDataset createDataset(){
		TimeSeries series1 = new TimeSeries("21 Day");
		
		series1.add(new Day(toDate("12/17/2016")),49.6);
		series1.add(new Day(toDate("12/18/2016")),42);
		series1.add(new Day(toDate("12/20/2016")),56.4);
		series1.add(new Day(toDate("12/21/2016")),66);
		series1.add(new Day(toDate("12/22/2016")),57);
		
		TimeSeries series2 = new TimeSeries("55 Day");
		
		series2.add(new Day(toDate("12/17/2016")),46);
		series2.add(new Day(toDate("12/18/2016")),42.2);
		series2.add(new Day(toDate("12/20/2016")),54);
		series2.add(new Day(toDate("12/21/2016")),68.6);
		series2.add(new Day(toDate("12/22/2016")),57.2);
			
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);        
		dataset.addSeries(series2);
		
		return dataset;
	}
	
	private Date toDate(String dateString){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
	    Date date = null;
	    try {
	        date = df.parse(dateString);
	        String newDateString = df.format(date);
	        System.out.println(newDateString);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    System.out.println(date);
		return date;
	}
	
	public static void main( String[ ] args ) {
	      LineChart chart = new LineChart();

	      chart.pack( );
	      RefineryUtilities.centerFrameOnScreen( chart );
	      chart.setVisible( true );
	}
	
}
