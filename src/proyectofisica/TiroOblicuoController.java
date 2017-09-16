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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import variables.Angulo;
import variables.Guardador;
import variables.MRUV;
import variables.PosicionXFinal;
import variables.PosicionXInicial;
import variables.PosicionYFinal;
import variables.PosicionYInicial;
import variables.TiempoX;
import variables.TiempoY;
import variables.TiroOblicuo;
import variables.VelocidadInicial;
import variables.VelocidadInicialY;
import variables.VariablesMRUV;


public class TiroOblicuoController implements Initializable {

    @FXML
    Label lbResultado;
    @FXML
    Label lbAngulo,lbTiempo,lbVel0,lbPosF,lbPos0;
    @FXML
    TextField tfAngulo, tfTiempo, tfVel0, tfPosF, tfPos0,tfAceleracion;
    @FXML
    ComboBox calcular;
    @FXML
    ComboBox evaluar;
    @FXML
    CheckBox cbAceleracion;
    VariablesMRUV posYFinal;
    VariablesMRUV velFinal;
    VariablesMRUV posYInicial, tiempo, velInicial, angulo, posXFinal, posXInicial;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbAceleracion.setSelected(true);
        tfAceleracion.setVisible(false);
        
        ArrayList listaEvaluar= new ArrayList();
        listaEvaluar.add("Eje X");
        listaEvaluar.add("Eje Y");
        ObservableList visualCalculo= FXCollections.observableArrayList(listaEvaluar);
        evaluar.setItems(visualCalculo);
        
    }    
    @FXML
    private void saltarAtras(MouseEvent event) throws Exception {      
        Parent cinematica = FXMLLoader.load(getClass().getResource("cinematica1.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("Cinemática");
        primary.setScene(escena);
        primary.show();
    }
    @FXML
    private void queQuiereCalcular(ActionEvent event) throws Exception{
        configurarLabels();
    }
    
    @FXML
    private void queQuiereEvaluar(ActionEvent event) throws Exception{
        if (evaluar.getValue()=="Eje X")
            evaluarEjeX();
        else
            evaluarEjeY();
    }
    
    private void evaluarEjeX(){
        ArrayList listaCalculo= new ArrayList();
        listaCalculo.add(tiempo=new TiempoX());
        listaCalculo.add(posXInicial=new PosicionXInicial());
        listaCalculo.add(posXFinal=new PosicionXFinal());
        ObservableList visualCalculo= FXCollections.observableArrayList(listaCalculo);
        calcular.setItems(visualCalculo);
        calcular.setPromptText("Seleccionar");
        
        lbPos0.setText("Posición Inicial X");
        lbPosF.setText("Posición final X");
    }
    private void evaluarEjeY(){
        ArrayList listaCalculo= new ArrayList();
        listaCalculo.add(posYInicial=new PosicionYInicial());
        listaCalculo.add(posYFinal=new PosicionYFinal());
        listaCalculo.add(velInicial=new VelocidadInicialY());
        //listaCalculo.add(velFinal=new VelocidadFinal());
        listaCalculo.add(tiempo=new TiempoY());
        listaCalculo.add(angulo=new Angulo());
        ObservableList visualCalculo= FXCollections.observableArrayList(listaCalculo);
        calcular.setItems(visualCalculo);
        calcular.setPromptText("Seleccionar");
        lbPos0.setText("Posición Inicial Y");
        lbPosF.setText("Posición final Y");
    }
    @FXML
    private void calcular(MouseEvent event) throws Exception {
        Guardador guardar=new Guardador();
        if (cbAceleracion.isSelected()){
            guardar.setAceleracion(Fisica.gravedad);
            
            }
        else{
            guardar.setAceleracion(Util.filtro(tfAceleracion));
            
            }
        guardar.setAngulo(Util.filtro(tfAngulo));
        guardar.setPosicionXFinal(Util.filtro(tfPosF));
        guardar.setPosicionXInicial(Util.filtro(tfPos0));
        guardar.setPosicionYFinal(Util.filtro(tfPosF));
        guardar.setPosicionYInicial(Util.filtro(tfPos0));
        guardar.setTiempo(Util.filtro(tfTiempo));
        guardar.setVelocidadInicial(Util.filtro(tfVel0));
        guardar.setPosicion(true);//cambiar tal vez
        
        MRUV tiroOblicuo= new TiroOblicuo(guardar);
        VariablesMRUV calculador= (VariablesMRUV)calcular.getValue();
        
        double resultado=calculador.calcular(tiroOblicuo);
        String res= String.valueOf(Fisica.truncarDecimal(resultado, 2));
        if (guardar.getResultado())
            res= res+" y "+ Fisica.truncarDecimal(guardar.getTiempo(),2);
        res= res+" "+calculador.unidad();
        lbResultado.setText(res);
    }
    
    private void configurarLabels(){
        lbAngulo.setVisible(true);
        lbPos0.setVisible (true);
        lbPosF.setVisible(true);
        lbResultado.setVisible(true);
        lbTiempo.setVisible(true);
        lbVel0.setVisible(true);
        tfAngulo.setVisible(true);
        tfPos0.setVisible(true);
        tfPosF.setVisible(true);
        tfTiempo.setVisible(true);
        tfVel0.setVisible(true);
        lbVel0.setText("Velocidad inicial");
        String stCalcular= (calcular.getValue()).toString();
        switch (stCalcular){
            case "Posición inicial":
                lbPos0.setVisible(false);
                tfPos0.setVisible(false);
                break;
            case "Posición final":
                lbPosF.setVisible(false);
                tfPosF.setVisible(false);
                break;
            case "Velocidad inicial":
                lbVel0.setVisible(false);
                tfVel0.setVisible(false);
                break;
            case "Velocidad final":
                //Revisar
                break;
            case "Ángulo":
                lbAngulo.setVisible(false);
                tfAngulo.setVisible(false);
                break;
            case "Tiempo":
                lbTiempo.setVisible(false);
                tfTiempo.setVisible(false);
                break;
        }
    }
    @FXML
    private void cbAceleracionClick(ActionEvent event) throws Exception{
        if (cbAceleracion.isSelected())
            tfAceleracion.setVisible(false);
        else
            tfAceleracion.setVisible(true);
    }
}
