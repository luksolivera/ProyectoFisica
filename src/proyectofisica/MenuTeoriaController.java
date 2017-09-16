/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofisica;

import Teoria.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class MenuTeoriaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML Button botonAtras, botonSimulacion, botonSiguiente, botonAnterior,botonSimulacion1,botonSimulacion2;
    @FXML Text textInfo;
    @FXML TreeView Arbol;
    @FXML Label labelTitulo;
    @FXML ImageView ImageView1,ImageView2;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            // TODO
            Arbol Arb= new Arbol();
            TreeItem contenidos= new TreeItem("Contenidos");
            contenidos.getChildren().addAll(Arb.getContenidos());
            contenidos.setExpanded(true);
            Arbol.setRoot(contenidos);
            clear();
    }    
    private void clear(){
        botonAnterior.setDisable(true);
        botonSimulacion.setDisable(true);
        botonSiguiente.setDisable(true);
        botonSimulacion1.setVisible(false);
        botonSimulacion2.setVisible(false);
        ImageView1.setImage(null);
        ImageView2.setImage(null);
    }
    @FXML
    private void saltarAtras(ActionEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("Submenu.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setScene(escena);
        primary.show();
    }
    @FXML
    private void seleccionContenido(MouseEvent event)throws Exception{
        clear();
        try{
        // obtengo el objeto que esta seleccionado
        TreeItem<String> seleccion = (TreeItem<String>) Arbol.getSelectionModel().getSelectedItem();
        String seleccionado= seleccion.getValue();
        //variables de intancia
        String texto;
        Tema opcion;
        switch (seleccionado){
            case ("Posición"):
                //instancio el Tema, pido que me de su texto y seteo el texto de la imagen
                opcion= new Posicion();
                hacer(event,opcion);
                break;
                
            case ("Desplazamiento"):
                opcion= new Desplazamiento();
                hacer(event,opcion);
                break;
            case ("Velocidad"):
                opcion= new Velocidad();
                hacer(event,opcion);
                break;
            case ("Aceleración"):
                opcion= new Aceleracion();
                hacer(event,opcion);
                break;
            case ("MRU"):
                botonSimulacion.setDisable(false);
                opcion= new MRU();
                hacer(event,opcion);
                break;
            case ("MRUV"):
                botonSimulacion.setDisable(false);
                opcion= new MRUV();
                hacer(event,opcion);
                break;
            case ("Caida Libre/ Lanzamiento Vertical"):
                botonSimulacion.setDisable(false);
                opcion= new CaidaLibre();
                hacer(event,opcion);
                break;
            case ("Movimiento de Proyectiles"):
                botonSimulacion.setDisable(false);
                opcion= new Proyectil();
                hacer(event,opcion);
                break;
            case ("Primera ley"):
                botonSimulacion1.setVisible(true);
                opcion= new Primera();
                hacer(event,opcion);
                break;
            case ("Segunda ley"):
                botonSimulacion1.setVisible(true);
                opcion= new Segunda();
                hacer(event,opcion);
                break;
            case ("Tercer ley"):
                botonSimulacion1.setVisible(true);
                opcion= new Tercer();
                hacer(event,opcion);
                break;
            case ("Diagrama de cuerpo libre"):
                botonSimulacion1.setVisible(true);
                opcion= new Diagrama();
                hacer(event,opcion);
                break;
            case ("Rozamiento"):
                botonSimulacion1.setVisible(true);
                opcion= new Rozamiento();
                hacer(event,opcion);
                break;
            case ("Trabajo y Energía"):
                botonSimulacion2.setVisible(true);
                opcion= new Trabajo();
                hacer(event,opcion);
                break;
            case ("Energía Cinética"):
                botonSimulacion2.setVisible(true);
                opcion= new Cinetica();
                hacer(event,opcion);
                break;
            case ("Energía Potencial Gravitacional"):
                botonSimulacion2.setVisible(true);
                opcion= new Potencial();
                hacer(event,opcion);
                break;
            case ("Energía Potencial Elástica"):
                botonSimulacion2.setVisible(true);
                opcion= new Elastica();
                hacer(event,opcion);
                break;
            case ("Energía Mecánica"):
                botonSimulacion2.setVisible(true);
                opcion= new Mecanica();
                hacer(event,opcion);
                break;    
            case ("Potencia"):
                opcion= new Potencia();
                hacer(event,opcion);
                break;
            case ("Impulso y cant de movimiento"):
                opcion= new Impulso();
                hacer(event,opcion);
                break;
            case ("Choque"):
                opcion= new Choque();
                hacer(event,opcion);
                break;
            case ("Centro de masa"):
                opcion= new CentroMasa();
                hacer(event,opcion);
                break;    
            case ("Cuerpo rigido: Cinématica"):
                opcion= new CRCinetica();
                hacer(event,opcion);
                break;
            case ("Momento de inercia"):
                opcion= new MomentoInercia();
                hacer(event,opcion);
                break;
            case ("Energía en el movimiento"):
                opcion= new EnergiaMov();
                hacer(event,opcion);
                break;
            case ("Cuerpo rigido: Dinámica"):
                opcion= new CRDinamica();
                hacer(event,opcion);
                break;    
            case ("Rotrotraslación de un cuerpo"):
                opcion= new Rototraslacion();
                hacer(event,opcion);
                break;
            case ("Equilibrio de un cuerpo"):
                opcion= new Equilibrio();
                hacer(event,opcion);
                break;
            case ("Gravitación"):
                opcion= new Gravitacion();
                hacer(event,opcion);
                break;
            case ("Elasticidad"):
                opcion= new Elasticidad();
                hacer(event,opcion);
                break;    
            case ("Movimiento periódico"):
                opcion= new MovPeriodico();
                hacer(event,opcion);
                break;
            case ("Movimiento armónico simple"):
                opcion= new MAS();
                hacer(event,opcion);
                break;
            case ("Movimiento armónico simple angular"):
                opcion= new MASAngular();
                hacer(event,opcion);
                break;
            case ("Movimiento oscilatorio amortiguado"):
                opcion= new MOA();
                hacer(event,opcion);
                break;    
            case ("Movimiento oscilatorio forzado"):
                opcion= new MOF();
                hacer(event,opcion);
                break;
            case ("Ondas mecánicas"):
                opcion= new OndasMecanicas();
                hacer(event,opcion);
                break;
            case ("Fluidos"):
                opcion= new Fluidos();
                hacer(event,opcion);
                break;
            case ("Hidroestática"):
                opcion= new Hidroestatica();
                hacer(event,opcion);
                break;
            case ("Hidrodinámica"):
                opcion= new Hidrodinamica();
                hacer(event,opcion);
                break; 
            }
        }
        catch(Exception e){
            
        } 
    }
    @FXML
    private void siguiente(MouseEvent event, Tema tema){
    // obtengo el texto siguiente y lo muestro
        clear();
        Tema siguiente= tema.siguiente();
        hacer(event, siguiente);
        botonSiguiente.setOnAction(e-> siguiente(event, siguiente));
    }
    @FXML
    private void anterior(MouseEvent event, Tema tema){
        //obtengo el texto anterior y lo muestro.
        clear();
        Tema anterior= tema.anterior();hacer(event, anterior);
        botonAnterior.setOnAction(e-> anterior(event, anterior));
    }
    @FXML
    private void saltarLeyDeNewton(MouseEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("LeyDeNewton1.fxml"));
        Scene escena=new Scene(cinematica);
        Stage primary=new Stage();
        primary.setResizable(false);
        primary.setTitle("Leyes de Newton");
        primary.setScene(escena);
        primary.show();
    }
    @FXML
    private void saltarEnergia(MouseEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("MenuEnergia.fxml"));
        Scene escena=new Scene(cinematica);
        Stage primary=new Stage();
        primary.setResizable(false);
        primary.setTitle("Trabajo y Energía");
        primary.setScene(escena);
        primary.show();
    }
    @FXML
    private void saltarCinematica(MouseEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("cinematica1.fxml"));
        Scene escena=new Scene(cinematica);
        Stage primary=new Stage();
        primary.setResizable(false);
        primary.setTitle("Cinemática");
        primary.setScene(escena);
        primary.show();
    }
    @FXML
    private void hacer(MouseEvent event,Tema opcion){
        //reorganizo las imagen views.
        ImageView2.setFitWidth(200);
        ImageView1.setFitWidth(300);
        ImageView2.setFitHeight(200);
        ImageView1.setFitHeight(300);
        ImageView1.setFitWidth(200);
        ImageView2.setLayoutX(345);
        ImageView1.setLayoutX(345);
        //Velocidad es un caso especial por la imagen
        if (opcion.getTitulo()== "Velocidad"){
            ImageView2.setLayoutX(170);
            ImageView1.setLayoutX(275);
            ImageView2.setFitWidth(400);
            ImageView1.setFitWidth(300);
        }
        //habilito los botones 
        botonSiguiente.setDisable(false);
        botonAnterior.setDisable(false);
        ImageView1.setVisible(true);
        ImageView2.setVisible(true);
        labelTitulo.setText(opcion.getTitulo());
        String texto= opcion.getTexto();
        textInfo.setText(texto);
        // modifico el boton para que pueda cambiar de tema
        botonSiguiente.setOnAction(e-> siguiente(event,opcion));
        botonAnterior.setOnAction(e-> anterior(event,opcion));
        ImageView1.setImage(opcion.getImagen1());
        ImageView2.setImage(opcion.getImagen2());
    }
}   
