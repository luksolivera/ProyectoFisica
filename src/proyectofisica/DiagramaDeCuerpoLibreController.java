/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofisica;

import generales.Util;
import generales.Fisica;
import java.awt.HeadlessException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
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
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author usuario
 */
public class DiagramaDeCuerpoLibreController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ComboBox boxCalcular;
    @FXML
    CheckBox CheckRoce, CheckNormal, CheckSuelo;
    @FXML
    Button VolverAtras;
    @FXML
    Button Calcular;
//    @FXML
//    RadioButton RadioRoce, RadioMasa, RadioCoeficiente, RadioAceleracion, RadioFuerzaX;
    @FXML
    TextField TextAceleracion, TextMasa,TextFuerzaXY, TextFuerzaAngulo, TextCoeficiente, TextPeso, TextRoce, TextNormal, TextAngulo;
    @FXML
    Label LabelAceleracion, LabelMasa, LabelFuerzaXY, LabelFuerzaAngulo, LabelCoeficiente, LabelPeso, LabelRoce, LabelNormal, LabelAngulo, LabelResultado, LabelResultado1;
    ArrayList<Label> labels= new ArrayList<>();
    ArrayList<TextField> textFields= new ArrayList<>();
    ArrayList<String> queCalcular= new ArrayList<>();
    static RadioButton seleccionado=null; 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Carga las arrays
        labels.add(LabelRoce);labels.add(LabelPeso);labels.add(LabelResultado);labels.add(LabelResultado1);labels.add(LabelAngulo);
        labels.add(LabelCoeficiente);labels.add(LabelMasa);labels.add(LabelAceleracion);labels.add(LabelFuerzaAngulo);labels.add(LabelFuerzaXY);labels.add(LabelNormal);
        textFields.add(TextCoeficiente);textFields.add(TextFuerzaAngulo);textFields.add(TextFuerzaXY); textFields.add(TextAngulo);
        textFields.add(TextMasa);textFields.add(TextNormal);textFields.add(TextPeso);textFields.add(TextRoce);
        textFields.add(TextAceleracion);
        queCalcular.add("Aceleración");queCalcular.add("Fuerza en X");queCalcular.add("Masa");queCalcular.add("Fuerza de Roce");
        queCalcular.add("Coeficiente de roce");
        ObservableList<String> visualCalculo= FXCollections.observableArrayList(queCalcular);
        boxCalcular.setItems(visualCalculo);
//        radioBoton.add(RadioAceleracion);radioBoton.add(RadioCoeficiente);
//        radioBoton.add(RadioMasa);radioBoton.add(RadioRoce); radioBoton.add(RadioFuerzaX);
        this.clear();
        
    }    
    @FXML
    private void saltarAtras(MouseEvent event) throws Exception {
        Parent cinematica = FXMLLoader.load(getClass().getResource("LeyDeNewton1.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setScene(escena);
        primary.show();
    }
    
    private void clear(){
        for (Label x : labels){
            x.setVisible(false);
        }
        for (TextField x : textFields){
            x.setVisible(false);
            x.setText("");
        }
        CheckRoce.setVisible(false);
        CheckRoce.setSelected(false);
        CheckNormal.setSelected(false);
        CheckNormal.setVisible(false);
        CheckSuelo.setVisible(true);
        CheckSuelo.setSelected(false);
    }
    @FXML
    private void seleccionarCalculo( ActionEvent event) throws Exception{
        String opcion = String.valueOf(boxCalcular.getValue());
        switch (opcion){
            case "Aceleración":
                this.seleccionAceleracion(event);
                break;
            case "Fuerza en X":
                this.seleccionFuerzaX(event);
                break;
            case "Masa":
                this.seleccionMasa(event);
                break;
            case "Fuerza de Roce":
                this.seleccionFuerzaRoce(event);
                break;
            case "Coeficiente de roce":
                this.seleccionCoeficiente(event);
                break;

        }
    }
    @FXML
    private void seleccionFuerzaRoce(ActionEvent event) throws Exception {
        this.clear();
        for (TextField t : textFields){
                   if (t == TextCoeficiente){
                       t.setVisible(true);
                   }
                   if (t == TextNormal){
                       t.setVisible(true);
                   }
               }
               for (Label t : labels){
                   if (t == LabelCoeficiente){
                       t.setVisible(true);
                   }
                   if (t == LabelNormal){
                       t.setVisible(true);
                   }
               }
               CheckSuelo.setVisible(false);
               CheckNormal.setVisible(true);
               Calcular.setOnAction(e -> calcularRoce(event));
    }
    @FXML
    private void seleccionMasa(ActionEvent event) throws Exception {
        this.clear();
        for(TextField t: textFields){
             if(TextMasa == t || t== TextCoeficiente || t==TextAngulo || t==TextNormal || t==TextPeso ){
           }else{
                 t.setVisible(true);
            }
                }
                for(Label t : labels){
                    if(LabelMasa == t || t== LabelCoeficiente  || t==LabelAngulo || t==LabelNormal || t==LabelPeso){
                    }else {
                        t.setVisible(true);
                    }
                }
                Calcular.setOnAction(e -> calcularMasa(event));
    }
    @FXML
    private void seleccionAceleracion(ActionEvent event) throws Exception {
        this.clear();
        for (TextField t : textFields){
            if (t == TextAceleracion || t== TextPeso || t == TextNormal || t== TextCoeficiente || t==TextAngulo){
            }else{ 
                 t.setVisible(true);
             }    
            }
            for (Label t : labels){
                if (t == LabelAceleracion || t== LabelPeso || t== LabelNormal || t== LabelCoeficiente || t==LabelAngulo){
            } else{
                       t.setVisible(true);
                   }
               }
            CheckRoce.setVisible(true);
            Calcular.setOnAction(e -> calcularAceleracion(event));
    }
    @FXML
    private void seleccionCoeficiente(ActionEvent event) throws Exception {
        this.clear();
        for (TextField t : textFields){
                   if (t == TextRoce ){
                       t.setVisible(true);
                   }
                   if (t == TextNormal){
                       t.setVisible(true);
                   }
               }
               for (Label t : labels){
                   if (t == LabelRoce ){
                       t.setVisible(true);
                   }
                   if (t == LabelNormal){
                       t.setVisible(true);
                   }
               }
               CheckSuelo.setVisible(false);
               CheckNormal.setVisible(true);
               Calcular.setOnAction(e -> calcularCoeficiente(event));
    }
    @FXML
    private void seleccionFuerzaX(ActionEvent event) throws Exception {
        this.clear();
        for(TextField t: textFields){
            if(TextRoce == t || TextMasa == t || t== TextAceleracion ){
                t.setVisible(true);
            }
        }       
        for(Label t: labels){
            if(LabelRoce == t || LabelMasa == t|| t== LabelAceleracion){
                t.setVisible(true);
            }
        }
                CheckRoce.setVisible(true);
                Calcular.setOnAction(e -> calcularFuerzaX(event));
    }
    @FXML
    private void CheckBoxRoce(MouseEvent event) throws Exception{
        if (CheckRoce.isSelected()){
            TextRoce.setVisible(false);
            TextRoce.setText("");
            TextCoeficiente.setVisible(true);
            LabelRoce.setVisible(false);
            LabelCoeficiente.setVisible(true);
        }
        if (! CheckRoce.isSelected()){
            TextRoce.setVisible(true);
            TextCoeficiente.setText("");
            TextCoeficiente.setVisible(false);
            LabelRoce.setVisible(true);
            LabelCoeficiente.setVisible(false);
        }
    }
    @FXML
    private void CheckBoxNormal(MouseEvent event) throws Exception{
       if(CheckNormal.isSelected()){
                TextNormal.setVisible(false);
                TextNormal.setText("");
                LabelNormal.setVisible(false);
                TextPeso.setVisible(true);
                LabelPeso.setVisible(true);
       }
       if(! CheckNormal.isSelected()){
            TextNormal.setVisible(true);
            TextPeso.setText("");
            LabelNormal.setVisible(true);
            TextPeso.setVisible(false);
            LabelPeso.setVisible(false);
       }
    }
    @FXML
    private void CheckBoxSuelo(MouseEvent event) throws Exception{
       if(CheckSuelo.isSelected()){
                TextAngulo.setVisible(true);
                TextAngulo.setText("");
                LabelAngulo.setVisible(true);
       }
       if(! CheckSuelo.isSelected()){
            TextAngulo.setVisible(false);
            LabelAngulo.setVisible(false);
       }
     }
    private void calcularAceleracion(ActionEvent event){         
        double resultado=0.0;
        double fuerza = Util.filtro(TextFuerzaXY);
        double anguloFuerza = Util.filtro(TextFuerzaAngulo);
        double angulo = Util.filtro(TextAngulo);
        double masa= Util.filtro(TextMasa);
        double roce=Util.filtro(TextRoce);
        double coeficiente= Util.filtro(TextCoeficiente);
        fuerza= Fisica.fuerzaEjex(fuerza, anguloFuerza);
        double peso= Fisica.fuerzaPesoX(Fisica.fuerzaPeso(masa), angulo);
        if (masa != 0 && CheckRoce.isSelected() == true ){
            resultado = (fuerza + peso - Fisica.fuerzaDeRozamiento(coeficiente, peso))/masa;
            LabelResultado.setText(String.valueOf(Fisica.truncarDecimal(resultado, 3))+ " m/s^2");
            LabelResultado.setVisible(true);
        }
        else{
            if(masa != 0 && CheckRoce.isSelected() == false){
                resultado = (fuerza + peso- roce)/masa;
                LabelResultado.setText(String.valueOf(Fisica.truncarDecimal(resultado, 3)) + " m/s^2");
                LabelResultado.setVisible(true);
        }
             else{
             LabelResultado.setText("ERROR: División por cero");
                        LabelResultado.setVisible(true); 
                    }
        }
        LabelResultado1.setText("Aceleración");
        LabelResultado1.setVisible(true);
        
    }
    private void calcularCoeficiente(ActionEvent event){
        double normal= Util.filtro(TextNormal);
        double roce= Util.filtro(TextRoce);
        double resultado = 0;
        double peso= Util.filtro(TextPeso);
               if (CheckNormal.isSelected()== true && peso != 0){
                   
                   resultado= roce/peso;
                   LabelResultado.setText(String.valueOf(Fisica.truncarDecimal(resultado, 3)));
                   LabelResultado.setVisible(true);
               }
               else{
                   if(CheckNormal.isSelected()== false && normal !=0){
                   
                   resultado= roce/normal;
                   LabelResultado.setText(String.valueOf(Fisica.truncarDecimal(resultado, 3)));
                   LabelResultado.setVisible(true);
                   }    
                    else{
                    LabelResultado.setText(String.valueOf("ERROR división por 0"));
                    LabelResultado.setVisible(true);   
                   }
               }
        LabelResultado1.setText("Cooeficiente de roce");
        LabelResultado1.setVisible(true); 
              
    }
    private void calcularRoce(ActionEvent event){
        double normal= Util.filtro(TextNormal);
        double coeficiente= Util.filtro(TextCoeficiente);
        double resultado = 0;
        double peso= Util.filtro(TextPeso);
               if (CheckNormal.isSelected()== true){
                   resultado= coeficiente*peso;
                   LabelResultado.setText(String.valueOf(Fisica.truncarDecimal(resultado, 3)) + " N");
                   LabelResultado.setVisible(true);
               }
               else{
                   if(CheckNormal.isSelected()== false){
                   resultado= coeficiente * normal;
                   LabelResultado.setText(String.valueOf(Fisica.truncarDecimal(resultado, 3)) + " N ");
                   LabelResultado.setVisible(true);
               }
               else{
                    LabelResultado.setText(String.valueOf("ERROR división por 0"));
                    LabelResultado.setVisible(true);   
               }
        }
        LabelResultado1.setText("Fuerza de Roce");
        LabelResultado1.setVisible(true); 
    }
    private void calcularFuerzaX(ActionEvent event){
        double resultado=0;
        double aceleracion= Util.filtro(TextAceleracion);
        double angulo = Util.filtro(TextAngulo);
        double masa= Util.filtro(TextMasa);
        double roce=Util.filtro(TextRoce);
        double coeficiente= Util.filtro(TextCoeficiente);
        double peso= Fisica.fuerzaPesoX(Fisica.fuerzaPeso(masa), angulo);
        if (CheckNormal.isSelected()== true){
            resultado= masa*aceleracion + Fisica.fuerzaDeRozamiento(coeficiente, peso) - peso;
            LabelResultado.setText(String.valueOf(Fisica.truncarDecimal(resultado, 3)) + " N");
            LabelResultado.setVisible(true);
        }
        else{
            resultado= masa*aceleracion + roce - peso;
            LabelResultado.setText(String.valueOf(Fisica.truncarDecimal(resultado, 3)) + " N");
            LabelResultado.setVisible(true);
        }
        LabelResultado1.setText("Fuerza en X");
        LabelResultado1.setVisible(true);    
    }
    private void calcularMasa(ActionEvent event){
        double resultado=0.0;
        double fuerza = Util.filtro(TextFuerzaXY);
        double anguloFuerza = Util.filtro(TextFuerzaAngulo);
        double angulo = Util.filtro(TextAngulo);
        double aceleracion= Util.filtro(TextAceleracion);
        double roce=Util.filtro(TextRoce);
        double coeficiente= Util.filtro(TextCoeficiente);
        fuerza= Fisica.fuerzaEjex(fuerza, anguloFuerza);
        if (aceleracion != 0.000000){
            resultado = (fuerza - roce) /aceleracion;
            LabelResultado.setText(String.valueOf(Fisica.truncarDecimal(resultado, 3)) + " K");
            LabelResultado.setVisible(true);
        }
        else{
            LabelResultado.setText("ERROR: División por cero");
            LabelResultado.setVisible(true); 
            
        }
        LabelResultado1.setText("Masa");
        LabelResultado1.setVisible(true);
        
    } 
}
