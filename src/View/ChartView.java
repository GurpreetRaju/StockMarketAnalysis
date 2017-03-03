package View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Random;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChartView extends Application {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy MM dd");
    
    
    @Override
    public void start(Stage stage) {
    	final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Date");
        
        final LineChart<String, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setAnimated(true);
        chart.setTitle("Stock Market Analysis");
        
        XYChart.Series stock = new XYChart.Series();
        
        stock.setName("Stock 1");
        
        //TODO: Not real View for now, I don't know how to make View separated. 
        
        LinkedList<StockListNode> stock = 
        
        
        XYChart.Series series = new XYChart.Series(sortedData);
        series.setName("Stock");
        chart.getData().add(series);
        
//        chart.getData().add(new Series<>(sortedData));
//        chart.setAnimated(true);

        final int dayRange = 30 ;
        LocalDate today = LocalDate.now() ;
        Random rng = new Random();

        for (int i = 0; i < 20 ; i++) {
            LocalDate date = today.minusDays(rng.nextInt(dayRange));
            String formattedDate = formatter.format(date);
            double value = rng.nextDouble() ;

            addData(data, formattedDate, value);
        }

        DatePicker datePicker = new DatePicker();
        Spinner<Double> valuePicker = new Spinner<>(0.0, 1.0, 0, 0.1);
        valuePicker.setEditable(true);

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addData(data, formatter.format(datePicker.getValue()), valuePicker.getValue()));

        HBox controls = new HBox(5, datePicker, valuePicker, addButton);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(5));

        BorderPane root = new BorderPane(chart, null, null, controls, null);
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    private void addData(ObservableList<Data<String, Number>> data, String formattedDate, double value) {
        Data<String, Number> dataAtDate = data.stream()
            .filter(d -> d.getXValue().equals(formattedDate))
            .findAny()
            .orElseGet(() -> {
                Data<String, Number> newData = new Data<String, Number>(formattedDate, 0.0);
                data.add(newData);
                return newData ;
            }) ;
        dataAtDate.setYValue(dataAtDate.getYValue().doubleValue() + value);
    	
/*    	
        primaryStage.setTitle("Hello World!");

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        

      //defining the axes
        final DateAxis xAxis = new DateAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        yAxis.setLabel("Date");
        
        //creating the chart
        final LineChart<Date,Number> lineChart = 
                new LineChart<Date,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));
        
        lineChart.getData().add(series);
        
        StackPane root = new StackPane();
        root.getChildren().add(lineChart);
        
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
*/
    }
}
