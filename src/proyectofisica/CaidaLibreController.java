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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import variables.CaidaLibre;
import variables.Guardador;
import variables.MRUV;
import variables.PosicionYFinal;
import variables.PosicionYInicial;
import variables.TiempoY;
import variables.TiroVertical;
import variables.VelocidadFinal;
import variables.VelocidadFinalY;
import variables.VelocidadInicial;
import variables.VelocidadInicialY;
import variables.VariablesMRUV;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class CaidaLibreController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ComboBox calcular, tipo;
    @FXML
    Label lbResultado,lbVelocidad,lbTiempoY,lbEjeY, lbPos0; 
    @FXML
    TextField tfVelIni,tfTiempo,tfPosFin, tfPosIni, tfAceleracion, tfVelFin;
    @FXML
    CheckBox cbPosicion, cbAceleracion;
    @FXML
    Button btnCalcular;
    VariablesMRUV posYFinal;
    VariablesMRUV velFinal, posYInicial, tiempo, velInicial;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbAceleracion.setSelected(true);
        tfAceleracion.setVisible(false);
        
        ArrayList listaCalculo= new ArrayList();
        listaCalculo.add(posYFinal=new PosicionYFinal());
        listaCalculo.add(velFinal=new VelocidadFinalY());
        listaCalculo.add(posYInicial=new PosicionYInicial());
        listaCalculo.add(tiempo=new TiempoY());
        listaCalculo.add(velInicial=new VelocidadInicialY());
        ObservableList visualCalculo= FXCollections.observableArrayList(listaCalculo);
        calcular.setItems(visualCalculo);
        calcular.setValue(calcular.getItems().get(0));
        
        ArrayList listaTipo= new ArrayList();
        listaTipo.add(new TiroVertical(new Guardador()));
        listaTipo.add(new CaidaLibre(new Guardador()));
        ObservableList visualTipo=FXCollections.observableArrayList(listaTipo);
        tipo.setItems(visualTipo);
        tipo.setValue(tipo.getItems().get(0));
        configurarLabels();
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
    private void calcular(MouseEvent event) throws Exception {
        VariablesMRUV calculador= (VariablesMRUV)calcular.getValue();
        MRUV tipoMRUV= (MRUV)tipo.getValue();
        
        Guardador guardar=tipoMRUV.crearGuardador();
        if (!cbAceleracion.isSelected())
            guardar.setAceleracion(Util.filtro(tfAceleracion));
        else
            guardar.setAceleracion(Fisica.gravedad);
        guardar.setPosicion(cbPosicion.isSelected());
        guardar.setPosicionYFinal(Util.filtro(tfPosFin));
        guardar.setPosicionYInicial(Util.filtro(tfPosIni));
        guardar.setTiempo(Util.filtro(tfTiempo));
        guardar.setVelocidadFinal(Util.filtro(tfVelFin));
        guardar.setVelocidadInicial(Util.filtro(tfVelIni));
        
        double resultado=calculador.calcular(tipoMRUV);
        resultado= Fisica.truncarDecimal(resultado, 2);
        String res= String.valueOf(resultado);
        if (guardar.getResultado())
            res= res+" y "+Fisica.truncarDecimal(guardar.getTiempo(), 2);
        res= res+" "+calculador.unidad();
        this.lbResultado.setText(res);
    }
    @FXML
    private void queQuiereCalcular(ActionEvent event) throws Exception{
        configurarLabels();
    }

    private void configurarLabels(){
        String stCalcular=(calcular.getValue()).toString();
        
        lbTiempoY.setText("Tiempo");
        tfPosFin.setText("");
        tfPosIni.setText("");
        tfTiempo.setText("");
        tfVelIni.setText("");
        tfVelFin.setVisible(false);
        
        lbEjeY.setVisible(true);
        lbPos0.setVisible(true);
        lbTiempoY.setVisible(true);
        lbVelocidad.setVisible(true);
        cbPosicion.setSelected(false);
        cbPosicion.setVisible(false);
        switch (stCalcular){
            
            case "Tiempo":
                lbVelocidad.setVisible(true);
                lbEjeY.setVisible(false);
                lbPos0.setVisible(false);
                lbTiempoY.setVisible(true);
                lbTiempoY.setText("Velocidad final");
                tfPosFin.setVisible(false);
                tfPosIni.setVisible(false);
                tfTiempo.setVisible(false);
                tfVelIni.setVisible(true);
                cbPosicion.setVisible(true);
                tfVelFin.setVisible(true);
                break;
            case "Posición final":
                lbEjeY.setVisible(false);
                tfPosFin.setVisible(false);
                tfPosIni.setVisible(true);
                tfTiempo.setVisible(true);
                tfVelIni.setVisible(true);
                break;
            case "Velocidad final":
                lbPos0.setVisible(false);
                lbEjeY.setVisible(false);
                tfPosFin.setVisible(false);
                tfPosIni.setVisible(false);
                tfTiempo.setVisible(true);
                tfVelIni.setVisible(true);
                break;
            case "Posición inicial":
                lbPos0.setVisible(false);
                tfPosFin.setVisible(true);
                tfPosIni.setVisible(false);
                tfTiempo.setVisible(true);
                tfVelIni.setVisible(true);
                break;
            case "Velocidad inicial":
                lbVelocidad.setVisible(false);
                tfPosFin.setVisible(true);
                tfPosIni.setVisible(true);
                tfTiempo.setVisible(true);
                tfVelIni.setVisible(false);
                break;
        }
    }
    @FXML
    private void conPosicion(MouseEvent event) throws Exception {
        if(cbPosicion.isSelected()){
            lbTiempoY.setVisible(false);
            lbEjeY.setVisible(true);
            lbVelocidad.setVisible(true);
            lbPos0.setVisible(true);
            tfPosFin.setVisible(true);
            tfPosIni.setVisible(true);
            tfTiempo.setVisible(false);
            tfVelIni.setVisible(true);
            tfVelFin.setVisible(false);
        }
        else
            configurarLabels();
        
    }
    @FXML
    private void clickCBAceleracion(ActionEvent event) throws Exception{
        if (cbAceleracion.isSelected()){
            tfAceleracion.setVisible(false);
        }
        else {
            tfAceleracion.setVisible(true);
        }
    }
}
