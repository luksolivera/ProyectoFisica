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

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class Menusimulacion1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    Button botonCinematica;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    private void saltarCinematica(MouseEvent event) throws Exception {
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
        private void saltarLeyDeNewton(MouseEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("LeyDeNewton1.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("Leyes de Newton");
        primary.setScene(escena);
        primary.show();
    }
        @FXML
        private void saltarEnergia(MouseEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("MenuEnergia.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("Trabajo y Energía");
        primary.setScene(escena);
        primary.show();
    }
        @FXML
        private void saltarRotacion(MouseEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("MenuRototraslacion.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("Movimiento rotacional");
        primary.setScene(escena);
        primary.show();
    }
        
        @FXML
    private void saltarAtras(MouseEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("Submenu.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("Menu Principal");
        primary.setScene(escena);
        primary.show();
    }
}
