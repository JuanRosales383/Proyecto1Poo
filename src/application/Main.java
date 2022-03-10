package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		CategoryAxis yAxis = new CategoryAxis();
        yAxis.setLabel("Palabras");

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Frecuencia");

       
		BarChart<Number, String> chart = new BarChart<Number, String>(xAxis, yAxis);
        chart.setTitle("Frecuencia de palabras en Tweets");
        // agregamos datos 
        chart.setData(obtenerDatos());
        
        // Paneles
        StackPane root = new StackPane();
        root.getChildren().add(chart);
        
        // Tama�o del Frame
        Scene scene = new Scene(root, 640, 427);

        primaryStage.setTitle("Frecuencia de palabras en Tweets");
        primaryStage.setScene(scene);
        primaryStage.show();
        
	}
	@SuppressWarnings("unchecked")
	public static ObservableList<XYChart.Series<Number, String>> obtenerDatos() {
		String rutaCSV = "/Users/juancarlosrosales/Downloads/bitcoin.csv";
		String rutaTXT = "/Users/juancarlosrosales/Downloads/palabrasProyecto.txt";
		
		CrearArrayList obj1 = new CrearArrayList();
		CuentaPalabras obj2 = new CuentaPalabras();

		ArrayList<String> listCSV = new ArrayList<>();
		ArrayList<String> listTXT = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		
		int i=0;
		int j=0;
		int coincidencias=0;
		
		listCSV=obj1.ArrayList(rutaCSV);
		listTXT=obj1.ArrayList(rutaTXT);
		

		list = obj1.cambiaArrayList(listCSV);
		for(String txt:list) {
			String[]TempArray = list.toArray(new String[j]);
			System.out.println(TempArray[j]);
			j++;
		}
		
        XYChart.Series<Number, String> frecuenciasPalabras = new XYChart.Series<>();
        frecuenciasPalabras.setName("Cantidad Palabras");
        for(String txt : listTXT){ //Recorre txt
			String[] temporalArray2 = listTXT.toArray(new String[i]);
			
			coincidencias = obj2.cuentaPalabras(list, txt);

        	 frecuenciasPalabras.getData().addAll(
        			 new XYChart.Data<>(coincidencias, listTXT.get(i)));
        	 i++;
        }
        
        ObservableList<XYChart.Series<Number, String>> data = FXCollections.observableArrayList();
        data.addAll(frecuenciasPalabras);
           
        return data;
    }
	
	
	public static void main(String[] args) {
		launch(args);
	}
}