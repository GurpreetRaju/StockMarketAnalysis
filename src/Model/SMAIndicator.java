package Model;

import java.util.LinkedList;

import org.jfree.chart.JFreeChart;

public class SMAIndicator{

	public SMAIndicator() {
	}

	public JFreeChart createChart(LinkedList<String[]> data) {
		Chart linechart = new LineChart(data);
		JFreeChart chart = linechart.CreateChart();
		return chart;
	}
	
}
