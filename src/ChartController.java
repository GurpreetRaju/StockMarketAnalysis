

import java.util.ArrayList;

import View.JFXChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class ChartController {
	@FXML
	private TextField txtMAaddField;
	
	@FXML LineChart<String,Number> lineChart;
	
//	private ArrayList<Integer> stock = new ArrayList<Integer>();
//	ArrayList<Integer> stock = new ArrayList<Integer>();
//	ArrayList<Integer> sta = new ArrayList<Integer>();
	int[] stock = {1312,823,623,123,1234,3445,5345,2334,234,24,242,3413,4213,423,4213,4253,4234};
	
	
	public void btn (ActionEvent event){
		XYChart.Series<String, Number> series = new XYChart.Series <String, Number>();
		int i = 1;
		for (int e : stock){
			series.getData().add(new XYChart.Data<String,Number>(Integer.toString(i),e));
			i++;
		}
		series.setName("Stock");
		lineChart.getData().add(series);
	}
	public int getMA (int position, int maWindow, int[] stock){
		int maValue = 0;
		for (int i = position - (maWindow - 1) ;i < position; i++){
			maValue += stock[i];
		}
//		System.out.println("maValue / maWindow" + maValue + " " + maWindow);
		maValue = maValue / maWindow;
		return maValue;
	}
	
	public void addMA (ActionEvent event){
		XYChart.Series<String, Number> ma = new XYChart.Series <String, Number>();
		int maWindow = Integer.parseInt(txtMAaddField.getText());
		for (int i= maWindow-1;i <= stock.length;i++){
			int mav = getMA(i,maWindow,stock);
			ma.getData().add(new XYChart.Data<String,Number>(Integer.toString(i),mav));
		}
		ma.setName("MA ("+txtMAaddField.getText()+")");
		lineChart.getData().add(ma);
	}
}
