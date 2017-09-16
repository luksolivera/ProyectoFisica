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
/**
 * FXML Controller class
 *
 * @author usuario
 */
public class LeyDeNewton1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    ImageView imagenDiagramaDeCuerpoLibre; 
    ImageView imagenSistemasDePoleas1;
    ImageView imagenSistemaDePoleas2;
    ImageView imagenMaquinaDeAtwood;
    Button botonVolverAtras;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML
    private void saltarAtras(MouseEvent event) throws Exception {      
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
    private void saltarDiagrama(MouseEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("DiagramaDeCuerpoLibre.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        
        primary.setScene(escena);
        primary.show();
    }
    @FXML
    private void saltarPoleas(MouseEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("Poleas1.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        
        primary.setScene(escena);
        primary.show();
    }
    @FXML
    private void saltarSumatoria(MouseEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("SumatoriaDeFuerzas.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        
        primary.setScene(escena);
        primary.show();
    }
}
