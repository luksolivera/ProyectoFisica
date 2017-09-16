/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofisica;

import MRU.PosicionFinal;
import MRU.PosicionInicial;
import MRU.Tiempo;
import MRU.Velocidad;
import generales.Fisica;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
//---
import java.net.URL;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class MruController implements Initializable {
    @FXML
    Label lbl01,lbl11,lbl21,lblr0,lblr1;
    @FXML
    Button botonCalcular,botonAtras;
    @FXML
    TextField txt0,txt1,txt2;
    @FXML
    ComboBox comboBoxOpcion;
    
    MRU.VariableMRU op1,op2,op3,op4;
    
    //CONSIDERAR
    MRU.OrdenadorMRU ordenador;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        op1 = new Velocidad("m/s");
        op2 = new Tiempo("s");
        op3 = new PosicionInicial("m");
        op4 = new PosicionFinal("m");
        ArrayList lista = new ArrayList();
        lista.add(op1);lista.add(op2);lista.add(op3);lista.add(op4);
        ObservableList<String> listaObs =  FXCollections.observableArrayList(lista);
        comboBoxOpcion.setItems(listaObs);
        
        ordenador = new MRU.OrdenadorMRU();
        mostrarDatos(false);
    }
     
    @FXML
    private void seleccionarComboBoxOpcion(ActionEvent event) throws Exception {
       MRU.VariableMRU variable = (MRU.VariableMRU) comboBoxOpcion.getValue();
       actualizarLabel(variable);
       botonCalcular.setOnAction(e -> calcular(variable));
       mostrarDatos(true);
       vaciarTxt();
    }
    
    private void calcular(MRU.VariableMRU variable){
//        ordenador.
        leerTextFields(variable);
        ordenador.setVelocidad((Velocidad)op1);
        ordenador.setTiempo((Tiempo)op2);
        ordenador.setpInicial((PosicionInicial)op3);
        ordenador.setpFinal((PosicionFinal)op4);
        double resultado = variable.calcular(ordenador);
        lblr1.setText(String.valueOf(Fisica.truncarDecimal(resultado, 2))+" "+ variable.getUnidad());
        
        lblr0.setVisible(true);
        lblr1.setVisible(true);
    }
    private void leerTextFields(MRU.VariableMRU variable){
        
        double valor1 = generales.Util.filtro(txt0);
        double valor2 = generales.Util.filtro(txt1);
        double valor3 = generales.Util.filtro(txt2);
        
        String opcion;
        opcion = variable.toString();
        switch(opcion){
            case "Velocidad":
                op2.setDato(valor1);
                op3.setDato(valor2);
                op4.setDato(valor3);
                break;
            case "Tiempo":
                op1.setDato(valor1);
                op3.setDato(valor2);
                op4.setDato(valor3);
                break;
            case "Posición inicial":
                op1.setDato(valor1);
                op2.setDato(valor2);
                op4.setDato(valor3);
                break;
            case "Posición final":
                op1.setDato(valor1);
                op2.setDato(valor2);
                op3.setDato(valor3);
                break;    
        }
    }
    
    private void actualizarLabel(MRU.VariableMRU variable){
        String opcion = variable.toString();
        switch(opcion){
            case "Velocidad":
                lbl01.setText(op2.toString());
                txt0.setPromptText(op2.getUnidad());
                lbl11.setText(op3.toString());
                txt1.setPromptText(op3.getUnidad());
                lbl21.setText(op4.toString());
                txt2.setPromptText(op4.getUnidad());
                break;
            case "Tiempo":
                lbl01.setText(op1.toString());
                txt0.setPromptText(op1.getUnidad());
                lbl11.setText(op3.toString());
                txt1.setPromptText(op3.getUnidad());
                lbl21.setText(op4.toString());
                txt2.setPromptText(op4.getUnidad());
                break;
            case "Posición inicial":
                lbl01.setText(op1.toString());
                txt0.setPromptText(op1.getUnidad());
                lbl11.setText(op2.toString());
                txt1.setPromptText(op2.getUnidad());
                lbl21.setText(op4.toString());
                txt2.setPromptText(op4.getUnidad());
                break;
            case "Posición final":
                lbl01.setText(op1.toString());
                txt0.setPromptText(op1.getUnidad());
                lbl11.setText(op2.toString());
                txt1.setPromptText(op2.getUnidad());
                lbl21.setText(op3.toString());
                txt2.setPromptText(op3.getUnidad());
                break;    
        }
    }
    
    private void mostrarDatos(boolean estado){
        lbl01.setVisible(estado);
        lbl11.setVisible(estado);
        lbl21.setVisible(estado);
    
        txt0.setVisible(estado);
        txt1.setVisible(estado);
        txt2.setVisible(estado);
        
        lblr0.setVisible(false);
        lblr1.setVisible(false);
    }
    
    private void vaciarTxt(){
        txt0.setText("");
        txt1.setText("");
        txt2.setText("");
    }
    @FXML
    private void saltarAtras(ActionEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("cinematica1.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("Cinemática");
        primary.setScene(escena);
        primary.show();
    }
}
