/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofisica;

import MRUV.Aceleracion;
import MRUV.Calculo;
import MRUV.CalculoAceleracion;
import MRUV.CalculoDistanciaInicial;
import MRUV.CalculoDistanciaFinal;
import MRUV.CalculoVelocidadInicial;
import MRUV.DistanciaFinal;
import MRUV.DistanciaInicial;
import MRUV.OrdenadorDeVariable;
import MRUV.Tiempo;
import MRUV.VelocidadFinal;
import MRUV.VelocidadInicial;
import generales.Fisica;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import proyectofisica.VacioExcepcion;
/**
 * FXML Controller class
 *
 * @author usuario
 */
public class MruvController implements Initializable {

    @FXML
    Label lbl10,lbl11,lbl20,lbl21,lbl30, lblr0,lblr1;
    @FXML
    TextField txt10,txt11,txt20,txt21,txt30;
    @FXML
    RadioButton radBotonVelocidad,radBotonDistancia,radBotonTiempo,radBotonAceleracion;
    @FXML
    ComboBox comboBoxVelOpcion,comboBoxDistOpcion; 
    @FXML
    CheckBox checkBox10,checkBox20;  
    @FXML
    Button botonCalcular;
    
    OrdenadorDeVariable ordenador;
    MRUV.Variable op1,op2,op3,op4,op5,op6;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        op1 = new Tiempo("s");
        op2 = new Aceleracion("m/s^2");
        op3 = new VelocidadInicial("m/s");
        op4 = new VelocidadFinal("m/s");
        op5 = new DistanciaInicial("m");
        op6 = new DistanciaFinal("m");
        
        ArrayList listaV = new ArrayList();
        ArrayList listaD = new ArrayList();
        listaV.add(op3);listaV.add(op4);listaD.add(op5);listaD.add(op6);
        ObservableList<String> listaVObs =  FXCollections.observableArrayList(listaV);
        ObservableList<String> listaDObs =  FXCollections.observableArrayList(listaD);
        comboBoxVelOpcion.setItems(listaVObs);
        comboBoxDistOpcion.setItems(listaDObs);
 
        mostrarPlanilla(false);
    }

    
    private void vaciarTxt(){
        txt10.setText("");
        txt11.setText("");
        txt20.setText("");
        txt21.setText("");
        txt30.setText("");
    }
    
    private void mostrarPlanilla(boolean estado){
        txt10.setVisible(estado);
        txt11.setVisible(estado);
        txt20.setVisible(estado);
        txt21.setVisible(estado);
        txt30.setVisible(estado);
        lbl10.setVisible(estado);
        lbl11.setVisible(estado);
        lbl20.setVisible(estado); 
        lbl21.setVisible(estado);
        lbl30.setVisible(estado);
        checkBox10.setVisible(estado);
        checkBox20.setVisible(estado);
        
        lblr0.setVisible(false);
        lblr1.setVisible(false);
    }
    @FXML
    private void seleccionarRadBotonTiempo(ActionEvent event) throws Exception{
        radBotonVelocidad.setSelected(false);
        radBotonDistancia.setSelected(false);
        radBotonAceleracion.setSelected(false);        
        
        comboBoxDistOpcion.setVisible(false);
        comboBoxVelOpcion.setVisible(false);
        
        
        actualizarLabels(op1);
        vaciarTxt();
        mostrarPlanilla(true);
        seleccionarCheckBox10(true);
        seleccionarCheckBox20(true);
        //REVISAR
        botonCalcular.setOnAction(e -> calcular(op1));
    }
    
    @FXML
    private void seleccionarRadBotonAceleracion(ActionEvent event) throws Exception{
        radBotonVelocidad.setSelected(false);
        radBotonTiempo.setSelected(false);
        radBotonDistancia.setSelected(false);        
        
        
        comboBoxDistOpcion.setVisible(false);
        comboBoxVelOpcion.setVisible(false);
        
        actualizarLabels(op2);
        vaciarTxt();
        mostrarPlanilla(true);
        seleccionarCheckBox10(true);
        seleccionarCheckBox20(true);
        
        botonCalcular.setOnAction(e -> calcular(op2));
    }

    @FXML    
    private void seleccionarRadBotonVelocidad(ActionEvent event) throws Exception{
        radBotonDistancia.setSelected(false);
        radBotonTiempo.setSelected(false);
        radBotonAceleracion.setSelected(false);
        
        comboBoxVelOpcion.setVisible(true);
        comboBoxDistOpcion.setVisible(false);
        
        comboBoxVelOpcion.setValue(null);
        
        botonCalcular.setOnAction(e -> vaciarTxt());
        
    }
    
    @FXML
    private void seleccionarRadBotonDistancia(ActionEvent event) throws Exception{
        radBotonVelocidad.setSelected(false);
        radBotonTiempo.setSelected(false);
        radBotonAceleracion.setSelected(false);        
        
        comboBoxDistOpcion.setVisible(true);
        comboBoxVelOpcion.setVisible(false);
        
        comboBoxDistOpcion.setValue(null);
        
        botonCalcular.setOnAction(e ->vaciarTxt());
    }
    
    
    
    private void actualizarLabels(MRUV.Variable variable){
        switch(variable.toString()){
            case "Tiempo":
                lbl10.setText(op4.toString());
                txt10.setPromptText(op4.getUnidad()); 
                lbl11.setText(op3.toString());
                txt11.setPromptText(op3.getUnidad()); 
                lbl20.setText(op6.toString()); 
                txt20.setPromptText(op6.getUnidad());
                lbl21.setText(op5.toString());
                txt21.setPromptText(op5.getUnidad());
                lbl30.setText(op2.toString());
                txt30.setPromptText(op2.getUnidad());
                break;
            case "Aceleración":
                lbl10.setText(op4.toString());
                txt10.setPromptText(op4.getUnidad()); 
                lbl11.setText(op3.toString());
                txt11.setPromptText(op3.getUnidad()); 
                lbl20.setText(op6.toString()); 
                txt20.setPromptText(op6.getUnidad());
                lbl21.setText(op5.toString());
                txt21.setPromptText(op5.getUnidad());
                lbl30.setText(op1.toString());
                txt30.setPromptText(op1.getUnidad());
                break;
            case "Velocidad inicial":
                lbl10.setText(op4.toString());
                txt10.setPromptText(op4.getUnidad()); 
                lbl11.setText(op2.toString());
                txt11.setPromptText(op2.getUnidad()); 
                lbl20.setText(op6.toString()); 
                txt20.setPromptText(op6.getUnidad());
                lbl21.setText(op5.toString());
                txt21.setPromptText(op5.getUnidad());
                lbl30.setText(op1.toString());
                txt30.setPromptText(op1.getUnidad());
                break;
            case "Velocidad final":
                lbl10.setText(op2.toString());
                txt10.setPromptText(op2.getUnidad()); 
                lbl11.setText(op3.toString());
                txt11.setPromptText(op3.getUnidad()); 
                lbl20.setText(op6.toString()); 
                txt20.setPromptText(op6.getUnidad());
                lbl21.setText(op5.toString());
                txt21.setPromptText(op5.getUnidad());
                lbl30.setText(op1.toString());
                txt30.setPromptText(op1.getUnidad());            
                break;
            case "Posición inicial":
                lbl10.setText(op4.toString());
                txt10.setPromptText(op4.getUnidad()); 
                lbl11.setText(op3.toString());
                txt11.setPromptText(op3.getUnidad()); 
                lbl20.setText(op6.toString()); 
                txt20.setPromptText(op6.getUnidad());
                lbl21.setText(op2.toString());
                txt21.setPromptText(op2.getUnidad());
                lbl30.setText(op1.toString());
                txt30.setPromptText(op1.getUnidad());                
                break;
            case "Posición final":
                lbl10.setText(op4.toString());
                txt10.setPromptText(op4.getUnidad()); 
                lbl11.setText(op3.toString());
                txt11.setPromptText(op3.getUnidad()); 
                lbl20.setText(op2.toString()); 
                txt20.setPromptText(op2.getUnidad());
                lbl21.setText(op5.toString());
                txt21.setPromptText(op5.getUnidad());
                lbl30.setText(op1.toString());
                txt30.setPromptText(op1.getUnidad());            
                break; 
        }
    }

    @FXML
    private void seleccionarComboBoxVelocidad(ActionEvent event) throws  Exception{
        MRUV.Variable variable = (MRUV.Variable) comboBoxVelOpcion.getValue();
        actualizarLabels(variable);
   
        mostrarPlanilla(true);
        seleccionarCheckBox10(false);
        seleccionarCheckBox20(true);
        checkBox10.setVisible(false);
        vaciarTxt();
        
        botonCalcular.setOnAction(e -> calcular(variable));
    }
    @FXML
    private void seleccionarComboBoxDistancia(ActionEvent event) throws  Exception{
        MRUV.Variable variable = (MRUV.Variable) comboBoxDistOpcion.getValue();
        actualizarLabels(variable);

        mostrarPlanilla(true);
        seleccionarCheckBox10(true);
        seleccionarCheckBox20(false);
        checkBox20.setVisible(false);
        vaciarTxt();

        botonCalcular.setOnAction(e -> calcular(variable));
    }
 
    @FXML
    private void seleccionarCheckBox10(ActionEvent event) throws Exception {
        CheckBox checkBox = (CheckBox)event.getSource();
        boolean estado = checkBox.isSelected();
        seleccionarCheckBox10(estado);
    }
    @FXML
    private void seleccionarCheckBox20(ActionEvent event) throws Exception {
        CheckBox checkBox = (CheckBox)event.getSource();
        boolean estado = checkBox.isSelected();
        seleccionarCheckBox20(estado);
    }
   
    private void seleccionarCheckBox10(boolean estado){
        checkBox10.setSelected(estado);
        txt11.setVisible(!estado);
        lbl11.setVisible(!estado);
    }
    private void seleccionarCheckBox20(boolean estado){
        checkBox20.setSelected(estado);
        txt21.setVisible(!estado);
        lbl21.setVisible(!estado);
    }

    @FXML
    private void saltarAtras(ActionEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("cinematica1.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setScene(escena);
        primary.setTitle("Cinemática");
        primary.show();
    }
    
    
    private void leerTextFields(MRUV.Variable variable,boolean[] disponible) throws VacioExcepcion,NumberFormatException{
        double valor1,valor2,valor3,valor4,valor5;
        int contador = 0;
       
        if("".equals(txt10.getText())){
            valor1 = Double.NaN;
            disponible[0] = false;
            contador++;
        }else{
            valor1 = Double.parseDouble(txt10.getText());
            disponible[0] = true;
        }
            
        
        boolean estado = Boolean.logicalAnd(checkBox10.isSelected(),checkBox10.isVisible());
        if(!estado){
            if("".equals(txt11.getText())){
                valor2 = Double.NaN;
                disponible[1] = false;
                contador++;
            }else{
                valor2 = Double.parseDouble(txt11.getText());
                disponible[1] = true;
            }
        } 
        else{
            valor2 = 0;
            disponible[1] = true;
        }
        
        
        
        
        if("".equals(txt20.getText())){
           valor3 = Double.NaN;
           disponible[2] = false;
           contador++;
        }else {
            valor3 = Double.parseDouble(txt20.getText());
            disponible[2] = true;
        }
           
        
        estado = Boolean.logicalAnd(checkBox20.isSelected(),checkBox20.isVisible());
        if(!estado){
            if("".equals(txt21.getText())){
                   valor4 = Double.NaN;
                   disponible[3] = false;
                   contador++;
            }else{
                valor4 = Double.parseDouble(txt21.getText());
                disponible[3] = true;
            }     
        } 
        else{
            valor4 = 0;
            disponible[3] = true;
        }
        
            
        if("".equals(txt30.getText())){
           valor5 = Double.NaN;
           disponible[4] = false;
           contador++;
        }else {
           valor5 = Double.parseDouble(txt30.getText());
           disponible[4] = true;
        }
        

        
        
        if(contador > 2)
            throw new VacioExcepcion(contador);
        
        String opcion = variable.toString();
        switch(opcion){
            case "Tiempo":
                op4.setDato(valor1);
                op3.setDato(valor2);
                op6.setDato(valor3);
                op5.setDato(valor4);
                op2.setDato(valor5);
                break;
            case "Aceleración":
                op4.setDato(valor1);
                op3.setDato(valor2);
                op6.setDato(valor3);
                op5.setDato(valor4);
                op1.setDato(valor5);
                break;
            case "Velocidad inicial":
                op4.setDato(valor1);
                op2.setDato(valor2);
                op6.setDato(valor3);
                op5.setDato(valor4);
                op1.setDato(valor5);
                break;
            case "Velocidad final":       
                op2.setDato(valor1);
                op3.setDato(valor2);
                op6.setDato(valor3);
                op5.setDato(valor4);
                op1.setDato(valor5);
                break;
            case "Posición inicial":             
                op4.setDato(valor1);
                op3.setDato(valor2);
                op6.setDato(valor3);
                op2.setDato(valor4);
                op1.setDato(valor5);                
                break;
            case "Posición final":           
                op4.setDato(valor1);
                op3.setDato(valor2);
                op2.setDato(valor3);
                op5.setDato(valor4);
                op1.setDato(valor5);                
                break; 
        }
    }
      //------------------------------------PROYECTO VIEJO 
    
    
    private void calcular(MRUV.Variable variable){
        ordenador = new OrdenadorDeVariable();
        boolean[] disponible = new boolean[5];
        try{
        leerTextFields(variable,disponible);
        ordenador.setTiempo((MRUV.Tiempo)op1);
        ordenador.setAceleracion((MRUV.Aceleracion)op2);
        ordenador.setVelocidadInicial((MRUV.VelocidadInicial)op3);
        ordenador.setVelocidadFinal((MRUV.VelocidadFinal)op4);
        ordenador.setDistanciaInicial((MRUV.DistanciaInicial)op5);
        ordenador.setDistanciaFinal((MRUV.DistanciaFinal)op6);

        
        String resultado =  variable.calcular(ordenador, disponible);    
        lblr1.setText(resultado);

        lblr0.setVisible(true);
        lblr1.setVisible(true);
        }catch(VacioExcepcion e){
            JOptionPane.showMessageDialog(null, e.toString());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingrese solo números", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
