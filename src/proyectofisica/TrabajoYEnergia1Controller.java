/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofisica;

import generales.Fisica;
import generales.Util;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class TrabajoYEnergia1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML Button botonAtras,botonCalcular;
    @FXML Label label1,label2,label3,label4,label5,labelResultado;
    @FXML TextField text1,text2,text3,text4;
    @FXML ComboBox boxCalcular1, boxCalcular2;
    ArrayList<Label> labels= new ArrayList();
    ArrayList<TextField> textfields= new ArrayList();
    ObservableList<String> general = FXCollections.observableArrayList("Trabajo", "Energía Cinética", "Energía Potencial","Energía Elástica", "Energía Mecánica");
    ObservableList<String> trabajo=FXCollections.observableArrayList("Fuerza Constante", "Trabajo-Cinética");
    ObservableList<String> cinetica=FXCollections.observableArrayList("Energía", "Velocidad","Energía Final (Trabajo)","Velocidad Final (Trabajo)");
    ObservableList<String> mecanica=FXCollections.observableArrayList("Energía", "Velocidad");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        boxCalcular1.setItems(general);
        labels.add(label1);labels.add(label2);labels.add(label3);labels.add(label4);labels.add(label5);
        labels.add(labelResultado);
        textfields.add(text1);textfields.add(text2);textfields.add(text3);textfields.add(text4);
        boxCalcular2.setDisable(true);
        this.clear(); 
    }
    private void clear(){
        for(Label x: labels){
            x.setVisible(false);
        }
        
        for(TextField x: textfields){
            x.setVisible(false);
            x.setText("");
        }
    }
     @FXML
    private void saltarAtras(ActionEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("MenuEnergia.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("Menu Trabajo y Energía");
        primary.setScene(escena);
        primary.show();
    }
    @FXML
    private void seleccionCalcular(ActionEvent event)throws Exception{
        this.clear();
        String opcion = String.valueOf(boxCalcular1.getValue());
        label1.setText(opcion); label1.setVisible(true);
        switch(opcion){
             case "Trabajo":
                boxCalcular2.setDisable(false);
                boxCalcular2.setItems(trabajo);
                boxCalcular2.setOnAction(e-> seleccionCalcularTrabajo(event));
                 break;
             case "Energía Cinética":
                 
                boxCalcular2.setDisable(false);
                boxCalcular2.setItems(cinetica);
                boxCalcular2.setOnAction(e-> seleccionCalcularCinetica(event));
                 break;
             case "Energía Potencial":
                label2.setVisible(true); label2.setText("Masa: ");
                boxCalcular2.setDisable(true);
                label3.setVisible(true); label3.setText("Altura: ");
                text1.setVisible(true); text1.setPromptText("Kilo");
                text2.setVisible(true); text2.setPromptText("Metro");
                botonCalcular.setOnAction(e-> calcularPotencial(event));
                 break;
             case "Energía Elástica":
                boxCalcular2.setDisable(true);
                label2.setVisible(true); label2.setText("Constante: ");
                label3.setVisible(true); label3.setText("Longuitud: ");
                text1.setVisible(true); text1.setPromptText("Newton/Metro");
                text2.setVisible(true); text2.setPromptText("Metro");
                botonCalcular.setOnAction(e-> calcularElastica(event));
                break;
             case "Energía Mecánica":
                 boxCalcular2.setDisable(false);
                 boxCalcular2.setItems(mecanica);
                 boxCalcular2.setOnAction(e-> seleccionCalcularMecanica(event));
                 break;
         }
    }
    @FXML
    private void seleccionCalcularTrabajo(ActionEvent event){
        this.clear();label1.setVisible(true);
        String opcion = String.valueOf(boxCalcular2.getValue());
        switch(opcion){
            case "Fuerza Constante":
                label2.setVisible(true); label2.setText("Fuerza: ");
                label3.setVisible(true); label3.setText("Ángulo: ");
                label4.setVisible(true); label4.setText("Distancia: ");
                text1.setVisible(true); text1.setPromptText("Newton");
                text2.setVisible(true); text2.setPromptText("grados");
                text3.setVisible(true); text3.setPromptText("metros");
                botonCalcular.setOnAction(e-> calcularTrabajoConstante(event));
                break;
            case "Trabajo-Cinética":
                label2.setVisible(true); label2.setText("Energía Inicial: ");
                label3.setVisible(true); label3.setText("Energía Final: ");
                text1.setVisible(true); text1.setPromptText("Joule");
                text2.setVisible(true); text2.setPromptText("Joule");
                botonCalcular.setOnAction(e-> calcularTrabajoCinetica(event));
                break;
        }
    }
    @FXML
    private void seleccionCalcularMecanica(ActionEvent event){
        this.clear();label1.setVisible(true);
        String opcion = String.valueOf(boxCalcular2.getValue());
        switch(opcion){
            case "Energía":
                label2.setVisible(true); label2.setText("Energía Cinética: ");
                label3.setVisible(true); label3.setText("Energía Potencial: ");
                label4.setVisible(true); label4.setText("Energía Elástica: ");
                text1.setVisible(true); text1.setPromptText("Joule");
                text2.setVisible(true); text2.setPromptText("Joule");
                text3.setVisible(true); text3.setPromptText("Joule");
                botonCalcular.setOnAction(e-> calcularEnergiaMecanica(event));
                break;
            case "Velocidad":
                label2.setVisible(true); label2.setText("Masa: ");
                label3.setVisible(true); label3.setText("Energía Potencial: ");
                label4.setVisible(true); label4.setText("Energía Elástica: ");
                label5.setVisible(true); label5.setText("Energía Mecánica: ");
                text1.setVisible(true); text1.setPromptText("Kilo");
                text2.setVisible(true); text2.setPromptText("Joule");
                text3.setVisible(true); text3.setPromptText("Joule");
                text4.setVisible(true); text4.setPromptText("Joule");
                botonCalcular.setOnAction(e-> calcularVelocidadMecanica(event));
                break;
        }
    }
    @FXML
    private void seleccionCalcularCinetica(ActionEvent event){
        this.clear();label1.setVisible(true);
        String opcion = String.valueOf(boxCalcular2.getValue());
        switch(opcion){
            case "Energía":
                label2.setVisible(true); label2.setText("Masa: ");
                label3.setVisible(true); label3.setText("Velocidad: ");
                text1.setVisible(true); text1.setPromptText("Kilo");
                text2.setVisible(true); text2.setPromptText("Metros/Segundos");
                botonCalcular.setOnAction(e-> calcularEnergiaCinetica(event));
                break;
            case  "Velocidad":
                label2.setVisible(true); label2.setText("Masa: ");
                label3.setVisible(true); label3.setText("Energía Cinética: ");
                text1.setVisible(true); text1.setPromptText("Kilo");
                text2.setVisible(true); text2.setPromptText("Joule");
                botonCalcular.setOnAction(e-> calcularVelocidadCinetica(event));               
                break;
            case "Energía Final (Trabajo)":
                label2.setVisible(true); label2.setText("Energía Inicial: ");
                label3.setVisible(true); label3.setText("Trabajo: ");
                text1.setVisible(true); text1.setPromptText("Joule");
                
                text2.setVisible(true); text2.setPromptText("Joule");
                botonCalcular.setOnAction(e-> calcularCineticaTrabajo(event));
                break;
            case "Velocidad Final (Trabajo)":
                label2.setVisible(true); label2.setText("Energía Inicial: ");
                label3.setVisible(true); label3.setText("Masa: ");
                label4.setVisible(true); label4.setText("Trabajo: ");
                text1.setVisible(true); text1.setPromptText("Joule");
                text2.setVisible(true); text2.setPromptText("Kilo");
                text3.setVisible(true); text3.setPromptText("Joule");
                botonCalcular.setOnAction(e-> calcularVelocidadFinal(event));
                break;
        }
    }
    @FXML
    private void calcularPotencial(ActionEvent event)   {
        double altura= Util.filtro(text2);
        double masa= Util.filtro(text1);
        double resultado= Fisica.energiaPotencial(masa, altura);
        labelResultado.setVisible(true);
        labelResultado.setText("Potencial= "+ String.valueOf(Fisica.truncarDecimal(resultado, 3))+ " J");
    }
    @FXML
    private void calcularElastica(ActionEvent event){
        double constante= Util.filtro(text1);
        double longuitud= Util.filtro(text2);
        double resultado= Fisica.energiaElastica(constante, longuitud);
        labelResultado.setVisible(true);
        labelResultado.setText("Elástica= "+ String.valueOf(Fisica.truncarDecimal(resultado, 3))+ " J");
    }
    @FXML
    private void calcularTrabajoConstante(ActionEvent event){
        double fuerza= Util.filtro(text1);
        double distancia= Util.filtro(text3);
        double angulo= Util.filtro(text2);
        double resultado= Fisica.trabajoFuerza(fuerza, distancia, angulo);
        labelResultado.setVisible(true);
        labelResultado.setText("Trabajo= "+ String.valueOf(Fisica.truncarDecimal(resultado, 3))+ " J");
    }
    @FXML
    private void calcularTrabajoCinetica(ActionEvent event){
        double inicial= Util.filtro(text1);
        double Final= Util.filtro(text2);
        labelResultado.setVisible(true);
        labelResultado.setText("Trabajo= " + String.valueOf(Final - inicial)+ " J");
        
    }
    @FXML
    private void calcularEnergiaMecanica(ActionEvent event){
        double cinetica = Util.filtro(text1);
        double potencial = Util.filtro(text2);
        double elastica = Util.filtro(text3);
        labelResultado.setVisible(true);
        labelResultado.setText("Mecánica= " + String.valueOf(cinetica + potencial + elastica)+ " J");
    }
    @FXML
    private void calcularVelocidadMecanica(ActionEvent event){
        double mecanica = Util.filtro(text4);
        double potencial = Util.filtro(text2);
        double elastica = Util.filtro(text3);
        double masa = Util.filtro(text1);
        double resultado= Fisica.velocidadMecanica(mecanica, elastica, potencial, masa);
        labelResultado.setVisible(true);
        labelResultado.setText("Velocidad= "+ String.valueOf(Fisica.truncarDecimal(resultado, 3))+ " m/s");
    }
    @FXML
    private void calcularVelocidadCinetica(ActionEvent event){
        double cinetica = Util.filtro(text2);
        double masa = Util.filtro(text1);
        double resultado= Fisica.velocidadCinetica(cinetica, masa);
        labelResultado.setVisible(true);
        labelResultado.setText("Velocidad= "+ String.valueOf(Fisica.truncarDecimal(resultado, 3))+ " m/s");
    }
    @FXML
    private void calcularEnergiaCinetica(ActionEvent event){
        double velocidad = Util.filtro(text2);
        double masa = Util.filtro(text1);
        double resultado= Fisica.energiaCinetica(masa, velocidad);
        labelResultado.setVisible(true);
        labelResultado.setText("Cinética= "+ String.valueOf(Fisica.truncarDecimal(resultado, 3))+ " J");
    }
    @FXML
    private void calcularCineticaTrabajo(ActionEvent event){
        double inicial = Util.filtro(text1);
        double trabajo = Util.filtro(text2);
        labelResultado.setVisible(true);
        labelResultado.setText("Cinética Final= "+ String.valueOf(trabajo + inicial)+ " J");
    }
    @FXML
    private void calcularVelocidadFinal(ActionEvent event){
        double inicial = Util.filtro(text1);
        double trabajo = Util.filtro(text3);
        double masa = Util.filtro(text2);
        double resultado= Fisica.energiaVelocidadTrabajo(inicial, trabajo, masa);
        labelResultado.setVisible(true);
        labelResultado.setText("Velocidad= "+ String.valueOf(Fisica.truncarDecimal(resultado, 3))+ " m/s");
    }
}
