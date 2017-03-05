package Model;

import java.util.LinkedList;

import org.jfree.chart.JFreeChart;

public class SMAIndicator{

	public SMAIndicator() {
	}

	public JFreeChart createChart(LinkedList<String[]> data) {
		System.out.println("maIndicator.createChart");
		LinkedList<String[]> listMAs = new LinkedList<String[]>();
		listMAs = calculateMA(data,5);
		Chart linechart = new LineChart(data,listMAs);
		JFreeChart chart = linechart.CreateChart();
		return chart;
	}
	
	private LinkedList<String[]> calculateMA(LinkedList<String[]> data, int n){
		LinkedList<String[]> listMA = new LinkedList<String[]>();
		int j = data.size() - 1;
		while(j>n){
			System.out.println("calculateMA iteration: " + j);
			float addition = sum(data,j,j-n+1);
			float average = addition/n;
			System.out.println("average " + average);
			String[] node = new String[2];
			String[] date = data.get(j-n+1);
			node[0] = date[0];
			System.out.println("date " + node[0]);
			node[1] = String.valueOf(average);
			listMA.add(node);
			System.out.println("node added to listMA");
			j--;
		}
		return listMA;
	}
	
	private Float sum(LinkedList<String[]> data,int i,int k){
		String[] value = data.get(i);
		if(i==k){
			return Float.parseFloat(value[4]);
		}
		return Float.parseFloat(value[4]) + sum(data,i-1,k);
	}
	
}
