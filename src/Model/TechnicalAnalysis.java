package Model;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class TechnicalAnalysis{
	private Data data = new Data();
	private SMAIndicator maIndicator = new SMAIndicator();
	
	public JFreeChart performAnalysis(){
		JFreeChart chart = null;
		try{
			chart = maIndicator.createChart(data.getData());
		}
		catch(Exception e){
			
		}
		return chart;
	}
	
	public static void main(String[] arg){
		TechnicalAnalysis Ta = new TechnicalAnalysis();
		JFreeChart chart = Ta.performAnalysis();
		ChartPanel chartPanel = new ChartPanel( chart );
		chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
		JFrame jFrame = new JFrame();
		jFrame.add(chartPanel);
		chartPanel.setVisible( true );
		jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jFrame.setVisible(true);
	}
}
