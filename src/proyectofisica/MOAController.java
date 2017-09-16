/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofisica;

import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author User
 */
public class MOAController implements Initializable {
    @FXML
    private ComboBox comboBox00;
    @FXML
    private ComboBox comboBox10;
    @FXML
    private Label lbl10,lbl11,lbl12,lbl13;
    @FXML
    private TextField txt00,txt01,txt02,txt10;
    @FXML
    private Button btn00,btn10,btnSalir;
    @FXML
    private LineChart<Double,Double> lineChart10;
    String ejeX,ejeY;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList lista00 = new ArrayList();
        ArrayList lista10 = new ArrayList();
        MOA.Variable vPos,vVel,vAcel;
        vPos = new MOA.Posicion("m");
        vVel = new MOA.Velocidad("m/s");
        vAcel = new MOA.Aceleracion("m/s^2");
        lista00.add(vPos);lista00.add(vVel);lista00.add(vAcel);
        ejeX = "Eje X";
        ejeY = "Eje Y";
        lista10.add(ejeX);lista10.add(ejeY);
        comboBox00.setItems(FXCollections.observableList(lista00));
        comboBox10.setItems(FXCollections.observableList(lista10));
       
        }    
    
    @FXML
    private void seleccionarComboBox00(ActionEvent e){
        MOA.Variable variable = (MOA.Variable) comboBox00.getValue();
        btn00.setOnAction(evento -> graficar(variable));
    }
    
    @FXML    
    private void seleccionarComboBox10(ActionEvent e){
        String variable = (String) comboBox00.getValue();
        switch(variable){
            case "Eje X":
                
                break;
            case "Eje Y":
                break;
        }
    }
//    @FXML    
    private void graficar( MOA.Variable variable){
        double amplitud = generales.Util.filtro(txt00);
        double frecuencia = generales.Util.filtro(txt01);
        double faseInicial = generales.Util.filtro(txt02);
        
        double min = -1/frecuencia;
        double max = 1/frecuencia;
        ObservableList<XYChart.Series<Double, Double>> lineChartData = FXCollections.observableArrayList();
        LineChart.Series<Double, Double> series = new LineChart.Series<Double, Double>();
        series.setName("Grafica: "+ variable.toString());
        for (double i = min; i<max; i=i+(max/1000)){
            series.getData().add(new XYChart.Data<Double, Double>(i,variable.calcularMOA(amplitud, frecuencia, faseInicial,i)));
        }
        
        lineChartData.add(series);
        
        lineChart10.setCreateSymbols(true);
        
        lineChart10.setData(lineChartData);
        lineChart10.createSymbolsProperty();
    }
    @FXML    
    private void calcularCoordenada(){
        
    }
    @FXML    
    private void saltarAtras(ActionEvent e) throws IOException{
        Parent armonico = FXMLLoader.load(getClass().getResource("Menusimulacion1.fxml"));
        Scene escena=new Scene(armonico);
        final Node source=(Node)e.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("Movimiento Oscilatorio");
        primary.setScene(escena);
        primary.show();
    }
    
}
