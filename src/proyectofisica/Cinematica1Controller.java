/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofisica;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author usuario
 */

public class Cinematica1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    ImageView imagenMRU; 
    ImageView imagenMRUV;
    ImageView imagenCaidaLibre;
    ImageView imagenTiroOblicuo;
    ImageView imagenTiroVertical;
    Button botonVolverAtras;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void saltarMRU(MouseEvent event) throws Exception {
        Parent MRU = FXMLLoader.load(getClass().getResource("Mru.fxml"));
        Scene escena=new Scene(MRU);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("MRU - Movimiento rectilíneo uniforme");
        primary.setScene(escena);
        primary.show();
    }
        @FXML
    private void saltarMRUV(MouseEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("Mruv.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("MRUV - Movimiento rectilíneo uniformemente variado");
        primary.setScene(escena);
        primary.show();
    }
        @FXML
    private void saltarTiroOblicuo(MouseEvent event) throws Exception {
        Parent tiroOblicuo = FXMLLoader.load(getClass().getResource("TiroOblicuo.fxml"));
        Scene escena=new Scene(tiroOblicuo);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("Tiro oblicuo");
        primary.setScene(escena);
        primary.show();
    }
        @FXML
    private void saltarCaidaLibre(MouseEvent event) throws Exception {
        Parent tiroVertical = FXMLLoader.load(getClass().getResource("CaidaLibre.fxml"));
        Scene escena=new Scene(tiroVertical);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("Tiro vertical - Caída libre");
        primary.setScene(escena);
        primary.show();
    }
    @FXML
    private void saltarAtras(MouseEvent event) throws Exception {
        Parent simulacion = FXMLLoader.load(getClass().getResource("Menusimulacion1.fxml"));
        Scene escena=new Scene(simulacion);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("Simulación");
        primary.setScene(escena);
        primary.show();
    }
}
