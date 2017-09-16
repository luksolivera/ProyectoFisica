/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofisica;

import generales.Fisica;
import generales.Util;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import variables.CalculoEnergia;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class TrabajoYEnergiaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML ImageView imagenResorteI, imagenResorteD, imagenD, imagenI,imagenD1,imagenI1;
    @FXML Button botonAtras, botonCalcular;
    @FXML Label labelResultado,labelCinetica,labelMecanica,labelPotencial,labelElastica,labelVelocidad,labelLonguitud, labelConstante,labelA,labelB,labelC,labelD,labelE;
    @FXML TextField textInicial,textFinal,textConstante,textLonguitud,textLonguitud2,textCoeficiente, textMasa,textRadio;
    @FXML ComboBox boxResorte;
    private double [][] resultados= new double [5][5];
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> opcionResorte= FXCollections.observableArrayList("Sin resorte", "Principio", "Final");
        boxResorte.setItems(opcionResorte);
        boxResorte.setValue(boxResorte.getItems().get(0));
        labelLonguitud.setVisible(false);labelConstante.setVisible(false);
        textLonguitud.setVisible(false);textConstante.setVisible(false);
        imagenResorteD.setVisible(false);imagenResorteI.setVisible(false);
        labelResultado.setVisible(false);labelCinetica.setVisible(false);labelElastica.setVisible(false);
        labelMecanica.setVisible(false);labelPotencial.setVisible(false);labelVelocidad.setVisible(false);
    }
    @FXML
    private void saltarAtras(ActionEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("MenuEnergia.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("Menu Trabajo y Energía");
        primary.setScene(escena);
        primary.show();
    }
    @FXML
    private void seleccionDeResorte(ActionEvent event){
         String opcion = String.valueOf(boxResorte.getValue());
         switch(opcion){
             case "Sin resorte":
                labelLonguitud.setVisible(false);labelConstante.setVisible(false);
                textLonguitud.setVisible(false);textConstante.setVisible(false);
                imagenResorteD.setVisible(false);imagenResorteI.setVisible(false);
                 break;
             case "Principio":
                labelLonguitud.setVisible(true);labelConstante.setVisible(true);
                textLonguitud.setVisible(true);textConstante.setVisible(true);
                imagenResorteI.setVisible(true);imagenResorteD.setVisible(false);
                 break;
             case "Final":
                labelLonguitud.setVisible(true);labelConstante.setVisible(true);
                textLonguitud.setVisible(true);textConstante.setVisible(true);
                imagenResorteD.setVisible(true); imagenResorteI.setVisible(false);
                 break;
         }
    }
    @FXML
    private void seleccionIncremetoInicial(ActionEvent event) throws Exception{
        textInicial.setText(String.valueOf(Util.filtro(textInicial)+1));
        if (Double.valueOf(Util.filtro(textInicial))<= 0.0){
            imagenI.setVisible(false);
            imagenI1.setVisible(true);
            imagenResorteI.setLayoutY(168);
        }
        else{
            imagenI.setVisible(true);
            imagenI1.setVisible(false);
            imagenResorteI.setLayoutY(61);
            
        }
    }
    @FXML
    private void seleccionIncremetoFinal(ActionEvent event) throws Exception{
        textFinal.setText(String.valueOf(Util.filtro(textFinal)+1));
        if (Double.valueOf(Util.filtro(textFinal))<= 0.0){
            imagenD.setVisible(true);
            imagenD1.setVisible(false);
            imagenResorteD.setLayoutY(168);
        }
        else{
            imagenD.setVisible(false);
            imagenD1.setVisible(true);
            imagenResorteD.setLayoutY(61);
            
        }
    }
    @FXML
    private void seleccionDecremetoInicial(ActionEvent event) throws Exception{
        
        textInicial.setText(String.valueOf(Util.filtro(textInicial)-1));
        if (Double.valueOf(Util.filtro(textInicial))<= 0.0){
            imagenI.setVisible(false);
            imagenI1.setVisible(true);
            imagenResorteI.setLayoutY(168);
        }
        else{
            imagenI.setVisible(true);
            imagenI1.setVisible(false);
            imagenResorteI.setLayoutY(61);
        }
    }
    @FXML
    private void seleccionDecremetoFinal(ActionEvent event) throws Exception{
        textFinal.setText(String.valueOf(Util.filtro(textFinal)-1));
        if (Double.valueOf(Util.filtro(textFinal))<= 0.0){
            imagenD.setVisible(true);
            imagenD1.setVisible(false);
            imagenResorteD.setLayoutY(168);
        }
        else{
            imagenD.setVisible(false);
            imagenD1.setVisible(true);
            imagenResorteD.setLayoutY(61);
            
        }
    }
    @FXML
    private void calcular(ActionEvent event) throws Exception{
        double alturaInicial= Util.filtro(textInicial);
        double alturaFinal= Util.filtro(textFinal);
        double masa= Util.filtro(textMasa);
        double constate= Util.filtro(textConstante);
        double coeficiente= Util.filtro(textCoeficiente);
        double longuitudResorte= Util.filtro(textLonguitud);
        double longuitudRoce= Util.filtro(textLonguitud2);
        double radio= Util.filtro(textRadio);
        CalculoEnergia datos= new CalculoEnergia(masa,constate,coeficiente,alturaInicial,alturaFinal,longuitudResorte,longuitudRoce,radio);
        resultados=datos.hacerCalculos(boxResorte);
        labelResultado.setText("Seleccione Punto");
        labelResultado.setVisible(true);labelCinetica.setVisible(true);labelElastica.setVisible(true);
        labelMecanica.setVisible(true);labelPotencial.setVisible(true);labelVelocidad.setVisible(true);
        
    }
    @FXML
    private void calculoA(MouseEvent event){
    // 0            1           2       3           4
    // Mecanica, cinetica, potencial, elastica, velocidad;
        labelResultado.setText("Resultados en A");
        labelMecanica.setText("Energía Mecánica: " + String.valueOf(Fisica.truncarDecimal(resultados[0][0], 3))+ " J");
        labelCinetica.setText("Energía Cinética: " + String.valueOf(Fisica.truncarDecimal(resultados[0][1], 3))+ " J");
        labelPotencial.setText("Energía Potencial: " + String.valueOf(Fisica.truncarDecimal(resultados[0][2], 3))+ " J");
        labelElastica.setText("Energía Elástica: " + String.valueOf(Fisica.truncarDecimal(resultados[0][3], 3))+ " J");
        labelVelocidad.setText("Velocidad: " + String.valueOf(Fisica.truncarDecimal(resultados[0][4], 2))+ " m/s");
    }
    @FXML
    private void calculoB(MouseEvent event){
        labelResultado.setText("Resultados en B");
        labelMecanica.setText("Energía Mecánica: " + String.valueOf(Fisica.truncarDecimal(resultados[1][0], 3))+ " J");
        labelCinetica.setText("Energía Cinética: " + String.valueOf(Fisica.truncarDecimal(resultados[1][1], 3))+ " J");
        labelPotencial.setText("Energía Potencial: " + String.valueOf(Fisica.truncarDecimal(resultados[1][2], 3))+ " J");
        labelElastica.setText("Energía Elástica: " + String.valueOf(Fisica.truncarDecimal(resultados[1][3], 3))+ " J");
        labelVelocidad.setText("Velocidad: " + String.valueOf(Fisica.truncarDecimal(resultados[1][4], 2))+ " m/s");
    }
    @FXML
    private void calculoC(MouseEvent event){
        labelResultado.setText("Resultados en C");
        labelMecanica.setText("Energía Mecánica: " + String.valueOf(Fisica.truncarDecimal(resultados[2][0], 3))+ " J");
        labelCinetica.setText("Energía Cinética: " + String.valueOf(Fisica.truncarDecimal(resultados[2][1], 3))+ " J");
        labelPotencial.setText("Energía Potencial: " + String.valueOf(Fisica.truncarDecimal(resultados[2][2], 3))+ " J");
        labelElastica.setText("Energía Elástica: " + String.valueOf(Fisica.truncarDecimal(resultados[2][3], 3))+ " J");
        labelVelocidad.setText("Velocidad: " + String.valueOf(Fisica.truncarDecimal(resultados[2][4], 2))+ " m/s");
    }
    @FXML
    private void calculoD(MouseEvent event){
        labelResultado.setText("Resultados en D");
        labelMecanica.setText("Energía Mecánica: " + String.valueOf(Fisica.truncarDecimal(resultados[3][0], 3))+ " J");
        labelCinetica.setText("Energía Cinética: " + String.valueOf(Fisica.truncarDecimal(resultados[3][1], 3))+ " J");
        labelPotencial.setText("Energía Potencial: " + String.valueOf(Fisica.truncarDecimal(resultados[3][2], 3))+ " J");
        labelElastica.setText("Energía Elástica: " + String.valueOf(Fisica.truncarDecimal(resultados[3][3], 3))+ " J");
        labelVelocidad.setText("Velocidad: " + String.valueOf(Fisica.truncarDecimal(resultados[3][4], 2))+ " m/s");
    }
    @FXML
    private void calculoE(MouseEvent event){
        labelResultado.setText("Resultados en E");
        labelMecanica.setText("Energía Mecánica: " + String.valueOf(Fisica.truncarDecimal(resultados[4][0], 3))+ " J");
        labelCinetica.setText("Energía Cinética: " + String.valueOf(Fisica.truncarDecimal(resultados[4][1], 3))+ " J");
        labelPotencial.setText("Energía Potencial: " + String.valueOf(Fisica.truncarDecimal(resultados[4][2], 3))+ " J");
        labelElastica.setText("Energía Elástica: " + String.valueOf(Fisica.truncarDecimal(resultados[4][3], 3))+ " J");
        labelVelocidad.setText("Velocidad: " + String.valueOf(Fisica.truncarDecimal(resultados[4][4], 2))+ " m/s");
    }
    
    
   
}
