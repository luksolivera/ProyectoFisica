/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofisica;

import generales.Fisica;
import generales.Util;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import variables.Fuerza;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class SumatoriaDeFuerzasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button botonCalcular, botonAtras, botonAñadir,botonQuitar;
    @FXML
    Label labelFuerza, labelAngulo,labelResultado1,labelResultado2;
    @FXML
    TextField textFuerza, textAngulo;
    @FXML
    TableView tabla;
    @FXML
    TableColumn columFuerza, columAngulo;
    ObservableList<Fuerza> lista= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        botonCalcular.setDisable(true);
        botonQuitar.setDisable(true);
        
        columFuerza.setCellValueFactory(new PropertyValueFactory<Fuerza, String>("fuerza") );
        columAngulo.setCellValueFactory(new PropertyValueFactory<Fuerza, String>("angulo") );
        tabla.setItems(lista);
    }
    @FXML
    private void saltarAtras(ActionEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("LeyDeNewton1.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setScene(escena);
        primary.show();
    }    
    @FXML
    private void añadir( ActionEvent event) throws Exception{
        botonCalcular.setDisable(false);
        botonQuitar.setDisable(false);
        double fuerza= Util.filtro2(textFuerza);
        double angulo= Util.filtro2(textAngulo);
        if(fuerza == 0){
          angulo=0;  
        }
        lista.add(new Fuerza(fuerza,angulo));
    }
    @FXML
    private void quitar( ActionEvent event) throws Exception{
        lista.remove(0, lista.size());
    }
    @FXML
    private void calcular( ActionEvent event) throws Exception{
        double resultadoX = 0;
        double resultadoY = 0;
        double resultadoA = 0;
        double resultado = 0;
        for (Fuerza x : lista){
            resultadoX= resultadoX + x.getFuerzaX();
            resultadoY= resultadoY + x.getFuerzaY();
        }
        resultadoA=resultadoY/resultadoX;
        resultado = Math.sqrt(Math.pow(resultadoX, 2) +Math.pow(resultadoY, 2));
        resultadoA= Math.atan(resultadoA)*180/Math.PI;
        labelResultado1.setText("Fuerza Resultante= " + String.valueOf(Fisica.truncarDecimal(resultado, 2))+ " N");
        labelResultado2.setText("Ángulo = " + String.valueOf(Fisica.truncarDecimal(resultadoA, 3))+ " °");
    }
    
    
    
}
