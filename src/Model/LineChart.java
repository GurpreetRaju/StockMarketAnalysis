package Model;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import java.util.Date;
import java.util.LinkedList;

public class LineChart implements Chart {

    private String xAxisLabel = "Date";
    private String yAxisLabel = "Stock price";
    //private static Plot plot = (XYPlot) new Plot();
    private Stock stock;
    private JFreeChart lineChart;
    private TimeSeriesCollection dataset;

    public LineChart(String companyName, Date[] time, String companyCode) {
        stock = new Stock(companyName, companyCode, time);
    	//stock = new Stock();
        createChart();
    }

    private void createChart() {
        lineChart = ChartFactory.createTimeSeriesChart(this.stock.getStockName(),
                xAxisLabel, yAxisLabel, createDataset(), true, true, false);
    }

    public JFreeChart getChart() {
        return lineChart;
    }

    public TimeSeriesCollection createDataset() {
        System.out.println("Creating dataset");
        TimeSeries series1 = new TimeSeries("Stock");
        LinkedList<tick> data = stock.getStockData();
        int i = 0;
        while (i < data.size()) {
            tick elt = data.get(i);
            series1.add(new Day(elt.getDate()), elt.getData());//pass a string date and stock price moving average value
            i++;
        }

        dataset = new TimeSeriesCollection();
        dataset.addSeries(series1);

        return dataset;
    }

    public void updateDataset(int i) {

        LinkedList<tick> listMA = stock.calculateMA(i);

        TimeSeries series2 = new TimeSeries(i + " Day MA");

        for (tick elt2 : listMA) {
            //tick elt2 = listMA.remove();
            ((TimeSeries) series2).add(new Day(elt2.getDate()), elt2.getData());
        }
        dataset = (TimeSeriesCollection) lineChart.getXYPlot().getDataset();
        dataset.addSeries(series2);
        lineChart.getXYPlot().setDataset(dataset);
    }

    public boolean isSeriesExist(int i) {
        if (dataset.getSeries(i + " Day MA") != null) {
            return true;
        }
        return false;
    }

    public void removeSeries(int i) {
        dataset.removeSeries(dataset.getSeriesIndex(i + " Day MA"));
    }

    public String getIndicatorSignal(int ma) {
        String str = stock.indicatorSignal(ma);
        return str;
    }

//	public static void main(String[] arg){
//		Date[] timePeriod = new Date[2];
//		Calendar cal = Calendar.getInstance();
//		timePeriod[1] = cal.getTime();
//		cal.add(Calendar.YEAR, -1); // http://stackoverflow.com/questions/14946886/store-current-date-and-date-1-year-from-current-in-java
//		timePeriod[0] = cal.getTime();
//		LineChart chart = new LineChart("Google", timePeriod,"GOOG");
//		JFrame frame = new JFrame();
//		frame.setSize(600, 400);
//		ChartPanel chartPanel = new ChartPanel(chart.getChart());
//        chartPanel.setSize(frame.getSize());
//        frame.add(chartPanel);
//        frame.setVisible(true);
//        chart.updateDataset(20);
//        String str = chart.getIndicatorSignal(20);
//        System.out.println(str);
//	}
}
