/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofisica;

import grafos.AristaGrafico;
import grafos.Autos;
import grafos.Calculo;
import grafos.CalculoCombustible;
import grafos.CalculoTiempo;
import grafos.CargaDeDatos;
import grafos.Ciudad;
import grafos.Dfs;
import generales.Fisica;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.shape.Circle;
import grafos.Grafo;
import grafos.Vertice;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class VentanaGrafoController implements Initializable {

    boolean verDatos=true;
    
    
    @FXML
    private ComboBox comboBoxOrigen;
    @FXML
    private ComboBox comboBoxDestino;
    @FXML
    private ComboBox comboBoxVehiculos;
    @FXML
    private ComboBox comboBoxCalculo;
    @FXML
    Label labelResultado, labelNombre,labelDiametro,labelAltura,labelVelProm;
    @FXML
    Label labelJunin, labelBolivar,labelTandil, labelOlavarria, labelAzul, labelMDP, labelAvellaneda, labelBsAs, labelLaPlata, labelFlorencioVarela;
    @FXML
    Label labelInfo1,labelInfo2, labelInfo3, labelInfo4, labelInfo5, labelInfo6, labelInfo7, labelInfo8, labelInfo9, labelInfo10, labelInfo11,labelInfo12,labelInfo13, labelInfo14,labelInfo15, labelInfo16,labelInfo17, labelInfo18,labelInfo19,labelInfo20;
    Button btnCalcularDFS;
    Button btnVolverAtras;
    Button btnVisualizarDatos;
    @FXML
    Circle crclJunin,crclBolivar, crclBsAs ,crclAvellaneda, crclFlorencioVarela, crclLaPlata, crclTandil, crclAzul ,crclOlavarria, crclMDP;
    ArrayList <Circle> circulos=new ArrayList <Circle>();
    ArrayList <Label> informacion= new ArrayList<Label>();
    @FXML
    AnchorPane anchorPanel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Este orden debe respetarse.
        circulos.add(crclFlorencioVarela); circulos.add(crclLaPlata);circulos.add(crclBsAs);circulos.add(crclAvellaneda);circulos.add(crclMDP);circulos.add(crclAzul); circulos.add(crclOlavarria); circulos.add(crclBolivar); circulos.add(crclTandil); circulos.add(crclJunin);
        
        informacion.add(labelJunin); informacion.add(labelMDP); informacion.add(labelAvellaneda); informacion.add(labelBolivar); informacion.add(labelTandil);informacion.add(labelOlavarria); informacion.add(labelAzul);informacion.add(labelBsAs); informacion.add(labelLaPlata); informacion.add(labelFlorencioVarela);
        informacion.add(labelInfo1); informacion.add(labelInfo2); informacion.add(labelInfo3);informacion.add(labelInfo4); informacion.add(labelInfo5); informacion.add(labelInfo6); informacion.add(labelInfo7); informacion.add(labelInfo8); informacion.add(labelInfo9); informacion.add(labelInfo10); informacion.add(labelInfo11); informacion.add(labelInfo12); informacion.add(labelInfo13); informacion.add(labelInfo14); informacion.add(labelInfo15); informacion.add(labelInfo16); informacion.add(labelInfo17); informacion.add(labelInfo18); informacion.add(labelInfo19); informacion.add(labelInfo20);
        Grafo.getInstance().setCirculos(circulos);
        CargaDeDatos cargar= new CargaDeDatos(); cargar.cargarGrafo();
        crearLineas();
        ArrayList<String> listaOrigen = new ArrayList();
        ArrayList<String> listaAutos=new ArrayList();
        ArrayList<String> listaCalculo= new ArrayList();
        Grafo grafo=Grafo.getInstance();
        ArrayList <Vertice> nodos=grafo.getListaDeVertices();
        for (Vertice vertice: nodos){
            listaOrigen.add(((Ciudad)vertice.getDato()).getCiudadNombre());
        }
        ArrayList<Autos> autos=grafo.getVehiculos();
        for(Autos auto:autos){
            listaAutos.add(auto.getTipo());
        }
        
        listaCalculo.add("Tiempo");
        listaCalculo.add("Combustible");
        
        ObservableList<String> visualOrigen =  FXCollections.observableArrayList(listaOrigen);
        ObservableList<String> visualDestino =  FXCollections.observableArrayList(listaOrigen);
        ObservableList<String> visualAutos= FXCollections.observableArrayList(listaAutos);
        ObservableList<String> visualCalculo= FXCollections.observableArrayList(listaCalculo);
        comboBoxOrigen.setItems(visualOrigen);
        comboBoxDestino.setItems(visualDestino);
        comboBoxVehiculos.setItems(visualAutos);
        comboBoxCalculo.setItems(visualCalculo);
    }
    
    @FXML
    private void recorrerGrafo(MouseEvent event) throws Exception{
        String ciudadOrigen=String.valueOf(comboBoxOrigen.getValue());
        String ciudadDestino=String.valueOf(comboBoxDestino.getValue());
        String vehiculo= String.valueOf(comboBoxVehiculos.getValue());
        String calculo= String.valueOf(comboBoxCalculo.getValue());
        
        Grafo grafo=Grafo.getInstance();
        Vertice origen=grafo.buscarVertice(ciudadOrigen);
        Vertice destino=grafo.buscarVertice(ciudadDestino);
        Autos auto=grafo.buscarAuto(vehiculo);
        Calculo calcular;
        String adicional;
        if (calculo=="Tiempo"){
            calcular=new CalculoTiempo(auto);
            adicional="Horas";
        }
        else{
            calcular=new CalculoCombustible(auto);
            adicional= "Litros de nafta";
        }
        Dfs recorrer=new Dfs(calcular);
        double resultado=recorrer.mejorCamino(origen, destino);
        String cadena= "Resultado: "+ Fisica.truncarDecimal(resultado, 2)+" "+adicional;
        labelResultado.setText(cadena);
        //Pinto las lineas
        ArrayList <Vertice> mejorCamino=recorrer.getCamino();
        this.pintarLineas(mejorCamino);
    }
    @FXML
    private void volverAtras(MouseEvent event) throws Exception{
        Parent subMenu = FXMLLoader.load(getClass().getResource("Submenu.fxml"));
        Scene escena=new Scene(subMenu);
        Stage stage= new Stage();
        stage.setScene(escena);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.close();
        stage.show();
    }
    
    @FXML
    private void mostrarInformacion(MouseEvent event) throws Exception{
        Circle ciudad=(Circle)event.getSource();
        Vertice nodoLogico=Grafo.getInstance().buscarVertice(ciudad);
        labelNombre.setText(((Ciudad)nodoLogico.getDato()).getCiudadNombre());
        labelAltura.setText(""+((Ciudad)nodoLogico.getDato()).getCiudadAltura()+" m");
        labelDiametro.setText(""+((Ciudad)nodoLogico.getDato()).getCiudadArea());
        labelVelProm.setText(""+((Ciudad)nodoLogico.getDato()).getCiudadVelocidadMedia()+" m/s");
    }
    
    @FXML
    private void marcarCirculo(MouseEvent event) throws Exception{
        /*Hay que corregir
        ComboBox comboBox=(ComboBox)event.getSource();
        String nomCiudad=String.valueOf(comboBox.getValue());
        Grafo grafo=Grafo.getInstance();
        Vertice verticeLogico=grafo.buscarVertice(nomCiudad);
        Circle circulo= grafo.buscarVerticeGrafico(verticeLogico).getCirculo();
        circulo.setFill(Paint.valueOf("#fc5ca9"));*/
    }
    
    @FXML
    private void visualizarDatos(MouseEvent event) throws Exception{
        /*Oculta todos los labels*/
        if (verDatos==false){
            for (Label text: informacion){
                text.setVisible(true);
            }
            verDatos=true;
        }
        else{
            for (Label text: informacion){
                text.setVisible(false);
            }
            verDatos=false;
        }
    }
    
    @FXML
    private void crearLineas(){             //Creo las lineas que unen a los nodos
        new Thread(new Runnable() {
            @Override public void run() {
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                        Stage stage = (Stage) crclJunin.getScene().getWindow();
                        Grafo grafo= Grafo.getInstance();
        ArrayList <AristaGrafico> aristasGraficas= grafo.getListaDeAristasGraficas();
        for (AristaGrafico actual: aristasGraficas){
            Vertice origen=actual.getVertices()[0];
            Vertice destino= actual.getVertices()[1];
            Circle crcOrigen=grafo.buscarVerticeGrafico(origen).getCirculo();
            Circle crcDestino=grafo.buscarVerticeGrafico(destino).getCirculo();
            
            /*¨Personalizando la linea*/
            Line linea=actual.getLinea();
            linea.setEndX(crcOrigen.getLayoutX());
            linea.setEndY(crcOrigen.getLayoutY());
            linea.setStartX(crcDestino.getLayoutX());
            linea.setStartY(crcDestino.getLayoutY());
            linea.setVisible(true);
            linea.setFill(Paint.valueOf("#000000"));
            linea.setStroke(Paint.valueOf("Black"));
            linea.setStrokeWidth(4);
            AnchorPane prueba= (AnchorPane)((stage.getScene()).getRoot());
            prueba.setOpacity(100);
            prueba.getChildren().add(linea);
            linea.toBack();
            
        }
                    }
                });
            }
        }).start();
        
    }
    
    private void pintarLineas(ArrayList <Vertice> camino){
        Grafo grafo= Grafo.getInstance();
        ArrayList <AristaGrafico> aristasGraficas=grafo.getListaDeAristasGraficas();
        //Despinto las lineas anteriores
        for (AristaGrafico arista : aristasGraficas){
            arista.getLinea().setStroke(Paint.valueOf("#000000"));
        }
        int contador=0;
        while(camino.size()>contador+1){
            Vertice nodoA=camino.get(contador);
            Vertice nodoB=camino.get(contador+1);
            AristaGrafico aristaGrafica=grafo.buscarAristaGrafica(nodoA, nodoB);
            aristaGrafica.getLinea().setStroke(Paint.valueOf("#C44D58"));
            contador++;
            
        }
    }
}
