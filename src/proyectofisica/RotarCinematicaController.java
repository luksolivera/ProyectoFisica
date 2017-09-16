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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import variables.AceleracionAngular;
import variables.Guardador;
import variables.MRUV;
import variables.PosicionAngularFinal;
import variables.PosicionAngularInicial;
import variables.Rotacional;
import variables.TiempoX;
import variables.VariablesMRUV;
import variables.VelocidadAngularFinal;
import variables.VelocidadAngularIncial;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class RotarCinematicaController implements Initializable {
    
    @FXML
    ComboBox cbIncognitas;
    VariablesMRUV aceleracion,vel0, velF, tiempo, pos0,posF;
    @FXML
    TextField tfTiempo, tfVel0, tfVelF, tfPosF, tfPos0,tfAceleracion;
    @FXML
    Label resultado;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<VariablesMRUV> listaIncognitas= new ArrayList();
        listaIncognitas.add(aceleracion=new AceleracionAngular());
        listaIncognitas.add(vel0=new VelocidadAngularIncial());
        listaIncognitas.add(velF= new VelocidadAngularFinal());
        listaIncognitas.add(tiempo=new TiempoX());
        listaIncognitas.add(pos0=new PosicionAngularInicial());
        listaIncognitas.add(posF= new PosicionAngularFinal());
        
        ObservableList<VariablesMRUV> visualIncognitas= FXCollections.observableArrayList(listaIncognitas);
        cbIncognitas.setItems(visualIncognitas);
    }    
    @FXML
    private void saltarAtras(ActionEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("MenuRototraslacion.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setScene(escena);
        primary.show();
    }
    @FXML
    private void calcular(MouseEvent event) throws Exception {
        VariablesMRUV calculador= (VariablesMRUV)cbIncognitas.getValue();
        Guardador g= new Guardador();
        MRUV tipoMRUV= new Rotacional(g);
        
        g.setAceleracion(Util.filtro(tfAceleracion));
        //g.setPosicion(cbPosicion.isSelected());
        g.setPosicionYFinal(Util.filtro(tfPosF));
        g.setPosicionYInicial(Util.filtro(tfPos0));
        g.setTiempo(Util.filtro(tfTiempo));
        g.setVelocidadFinal(Util.filtro(tfVelF));
        g.setVelocidadInicial(Util.filtro(tfVel0));
        
        double resultado=calculador.calcular(tipoMRUV);
        resultado= Fisica.truncarDecimal(resultado, 2);
        String res= String.valueOf(resultado);
        if (g.getResultado())
            res= res+" y "+Fisica.truncarDecimal(g.getTiempo(), 2);
        res= res+" "+calculador.unidad();
//        this.lbResultado.setText(res);
    }
}
