package Controller;

//import java.util.Date;
//import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.ResourceBundle;

import Model.TechnicalAnalysis;
import View.TechnicalAnalysisView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TechnicalAnalysisController {
	@FXML private TextField txtInputMA;
	@FXML Button btnAddMa;
	@FXML StackedAreaChart<String, Number> stackedAreaChart;
	@FXML NumberAxis yAxis;
	
//	private TechnicalAnalysisView taview;
	private TechnicalAnalysis tamodel;
	private String[] timeperiod;
	
	public TechnicalAnalysisController(){
		
	}
	
    public void initialize() {
			String[] time = {"01,01,2015", "01,01,2016"};
						
//			DateAxis dateAxis = new DateAxis();
			
			XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
			
			this.tamodel = new TechnicalAnalysis();
			LinkedList<String[]> data = this.tamodel.performAnalysis(time);
			
//			ObservableList<XYChart.Data<Date, Number>> oSeries = FXCollections.observableArrayList();
//			ObservableList<XYChart.Data<Date, Number>> oSeries = FXCollections.observableArrayList();
			
/*			oSeries.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2012, 11, 15).getTime(), 2));
			oSeries.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2014, 5, 3).getTime(), 4));
*/			
			
			for( String[] line : data) {
				
				series.getData().add(new XYChart.Data<String,Number>(line[0] ,Float.parseFloat(line[6])));
//				oSeries.add(new XYChart.Data<Date, Number>(new GregorianCalendar( Integer.parseInt(line[0].substring(0,4)), Integer.parseInt(line[0].substring(6,7)), Integer.parseInt(line[0].substring(9,10))).getTime(), Float.parseFloat(line[6])));
				
			}
			
//			series.add(new XYChart.Series<>("Series1", series1Data));

//			oSeries.setName("Stock");
			yAxis.setAutoRanging(false);
			yAxis.setLowerBound(0);
			yAxis.setUpperBound(1000);
			yAxis.setTickUnit(3);
			
			stackedAreaChart.getStylesheets().add("Chart.css");
			stackedAreaChart.setCreateSymbols(false);
			stackedAreaChart.getData().add(series);
			
/*			NumberAxis numberAxis = new NumberAxis();
			numberAxis.setAutoRanging(false);
			numberAxis.setLowerBound(0);
			numberAxis.setUpperBound(1000);
			numberAxis.setTickUnit(3);

			DateAxis dateAxis = new DateAxis();
			StackedAreaChart<Date, Number> lineChart = new StackedAreaChart<Date, Number>(dateAxis, numberAxis, oSeries);
*/			
/*			
			ObservableList<XYChart.Series<Date, Number>> series = FXCollections.observableArrayList();
			 
			ObservableList<XYChart.Data<Date, Number>> series1Data = FXCollections.observableArrayList();
			series1Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2012, 11, 15).getTime(), 2));
			series1Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2014, 5, 3).getTime(), 4));
			 
			ObservableList<XYChart.Data<Date, Number>> series2Data = FXCollections.observableArrayList();
			series2Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2014, 0, 13).getTime(), 8));
			series2Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2014, 7, 27).getTime(), 4));
			 
			series.add(new XYChart.Series<>("Series1", series1Data));
			series.add(new XYChart.Series<>("Series2", series2Data));

			NumberAxis numberAxis = new NumberAxis();
			DateAxis dateAxis = new DateAxis();
			stackedAreaChart = new StackedAreaChart <> (dateAxis, numberAxis, oSeries);
*/			
//			stackedAreaChart = lineChart;
			//TODO Add Data field to fxml instead of CategoryAxis 
	    }
	
	public void onLoad(ActionEvent event){
		
	}
	
	public TechnicalAnalysisController(TechnicalAnalysis tamodel, String[] period){
		this.tamodel = tamodel;
		this.timeperiod = period;
		
		XYChart.Series<String, Number> series = new XYChart.Series <String, Number>();
		
		series.getData().add(new XYChart.Data<String,Number>("1962-01-02",2));

		System.out.println(series.getData().toString());

		series.setName("Stock");

	}
	
/*	public static void main(String[] arg){
		launch(arg);
		String[] time = {"01,28,2016", "02,28,2017"};
		TechnicalAnalysisController ta = new TechnicalAnalysisController(new TechnicalAnalysis(),time);
	}*/
}
