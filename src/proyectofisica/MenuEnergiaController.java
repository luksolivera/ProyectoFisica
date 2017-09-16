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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class MenuEnergiaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML Button botonAtras;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void saltarAtras(ActionEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("Menusimulacion1.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("Simulación");
        primary.setScene(escena);
        primary.show();
    }
    @FXML
    private void saltarSisDeEnergia(MouseEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("TrabajoYEnergia.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        
        primary.setScene(escena);
        primary.show();
    }
    @FXML
    private void saltarTrabajoYEnergia(MouseEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("TrabajoYEnergia1.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        
        primary.setScene(escena);
        primary.show();
    }
}
