/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofisica;

import java.awt.Panel;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class SubmenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button btnMostrar, btnSalir;
    Button btnAbrirSubmenuContenido, btnAbrirSubMenuSimu, btnAbrirSubMenuGrafo, btnAbrirSubMenuBiblio, btnAbrirSubMenuAcerca;
    @FXML
    Label lblTitulo, lblDescripcion;
    Panel subMenuSimulacion;
    String url;
    String titulo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Stage stage = (Stage) btnAbrirSubmenuContenido.getScene().getWindow();
//        stage.setTitle("Menu Principal-CUM-");
        try {
            abrirsubmenuSimulacion(null);
        } catch (Exception ex) {
            Logger.getLogger(SubmenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    private void mostrarContenido(MouseEvent event) throws Exception{
        Parent cinematica = FXMLLoader.load(getClass().getResource(url));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setTitle(titulo);
        primary.setResizable(false);
        primary.setScene(escena);
        primary.show();
    }
    @FXML
    private void abrirsubmenuContenido(MouseEvent event) throws Exception{
        this.btnMostrar.setVisible(false);
        //this.url="Contenido.fxml";   Falta crear esta ventana
        lblTitulo.setText("Contenido");
        this.lblDescripcion.setText("Aca habria una descripcion muy bella");
    }
    
    @FXML
    private void abrirsubmenuSimulacion(MouseEvent event) throws Exception{
        this.btnMostrar.setVisible(true);
        this.url="Menusimulacion1.fxml";
        lblTitulo.setText("Simulación");
        this.lblDescripcion.setText("Modifique las variables y compruebe sus resultados obtenidos en los ejercicios en\nla práctica de la materia.");
        
        this.titulo= "Simulación";
    }
    
    @FXML
    private void abrirsubmenuGrafo(MouseEvent event) throws Exception{
        this.btnMostrar.setVisible(true);
        this.url="VentanaGrafo.fxml";
        lblTitulo.setText("Recorrido eficiente");
        this.lblDescripcion.setText("Un mapa que contiene datos reales de ciudades y rutas de la provincia Buenos Aires. \nCalcula el mejor trayecto entre una ciudad A y otra ciudad B.");
        this.titulo="Recorrido eficiente";
    }
    
    @FXML
    private void abrirsubmenuBibliografia(MouseEvent event) throws Exception{
        this.btnMostrar.setVisible(false);
        lblTitulo.setText("Bibliografía");
        this.lblDescripcion.setText("ALgunos libros");
    }
    
    @FXML
    private void abrirsubmenuAcercaDe(MouseEvent event) throws Exception{
        this.btnMostrar.setVisible(false);
        lblTitulo.setText("Acerca de");
        this.lblDescripcion.setText("Descripcion");
    }
    
    @FXML
    private void salirPrograma(MouseEvent event) throws Exception{
        Platform.exit();
    }
}
