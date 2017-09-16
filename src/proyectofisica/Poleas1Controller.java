/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofisica;

import generales.Fisica;
import generales.Util;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class Poleas1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Label labelTension, labelTension2, labelObjeto1, labelObjeto2, labelPolea, labelMasa1, labelMasa2, labelMasa3, labelAceleracion,labelAngulo, labelRoce, labelRadio,labelResultado1,labelResultado2;
    @FXML
    TextField textTension, textAceleracion, textMasa1, textMasa2, textMasa3, textAngulo, textRoce, textRadio, textTension2;
    @FXML
    ComboBox boxCalcular;
    @FXML
    Button calcular;
    @FXML
    CheckBox checkPolea, checkRoce;
    ArrayList<Label> labels=new ArrayList();
    ArrayList<TextField> textfields=new ArrayList();
    ArrayList<String> queCalcular=new ArrayList();
    ArrayList<String> queCalcular2=new ArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        queCalcular.add("Aceleración");queCalcular.add("Tensión");
        queCalcular2.add("Aceleración");queCalcular2.add("Tensión 1 y 2");//queCalcular2.add("Masa Polea");queCalcular2.add("Radio Polea");queCalcular2.add("Aceleración Angular");
        labels.add(labelAceleracion);labels.add(labelAngulo);labels.add(labelMasa1);labels.add(labelMasa2);labels.add(labelMasa3);
        labels.add(labelObjeto1);labels.add(labelObjeto2);labels.add(labelPolea);labels.add(labelRadio);labels.add(labelResultado1);
        labels.add(labelRoce);labels.add(labelTension);labels.add(labelTension2);
        textfields.add(textAceleracion);textfields.add(textMasa2);textfields.add(textAngulo);textfields.add(textMasa1);textfields.add(textMasa3);
        textfields.add(textRadio);textfields.add(textRoce);textfields.add(textTension);textfields.add(textTension2);
        ObservableList<String> visualCalculo= FXCollections.observableArrayList(queCalcular);
        
        boxCalcular.setItems(visualCalculo);
        this.clear();
    }
    @FXML
    private void saltarAtras(MouseEvent event) throws Exception {      
        Parent cinematica = FXMLLoader.load(getClass().getResource("LeyDeNewton1.fxml"));
        Scene escena=new Scene(cinematica);
        final Node source=(Node)event.getSource();
        Stage primary=(Stage) source.getScene().getWindow();
        primary.setResizable(false);
        primary.setTitle("Leyes de Newton");
        primary.setScene(escena);
        primary.show();
    }
    private void clear(){
        for (Label x : labels ){
            x.setVisible(false);
        }
        for(TextField x: textfields){
            x.setVisible(false);
            x.setText("");
        }
        checkRoce.setVisible(false);
    }
    @FXML
    private void checkPolea(ActionEvent event){
        this.clear();
        ObservableList<String> visualCalculo= FXCollections.observableArrayList(queCalcular);
        ObservableList<String> visualCalculo2= FXCollections.observableArrayList(queCalcular2);
        if (checkPolea.isSelected()== true){
            boxCalcular.setItems(visualCalculo2);
        }
        else{
            boxCalcular.setItems(visualCalculo);
        }
    }
    @FXML
    private void seleccionarCalculo( ActionEvent event) throws Exception{
        String opcion = String.valueOf(boxCalcular.getValue());
        switch (opcion){
            case "Aceleración":
                this.seleccionAceleracion(event);
                break;
            case "Tensión":
                this.seleccionTension(event);
                break;
//            case "Radio Polea":
//                this.seleccionRadio(event);
//                break;
//            case "Masa Polea":
//                this.seleccionMasa(event);
//                break;
//            case "Aceleración Angular":
//                this.seleccionAngular(event);
//                break;
            case "Tensión 1 y 2":
                this.seleccionTensiones(event);
                break;
        }
    }
    private void seleccionAceleracion(ActionEvent event){
        this.clear();
        checkRoce.setVisible(true);
        if (checkPolea.isSelected()== true){
            for (Label x : labels){
                if (x == labelAceleracion || x==labelRoce || x==labelTension2 || x==labelTension || x==labelRadio){}
                else{
                    x.setVisible(true);
                }
            }
            for (TextField x : textfields ){
                if (x== textAceleracion || x == textRoce || x == textTension2 || x == textTension || x==textRadio){}
                else{
                    x.setVisible(true);
                }
            }
        }
        else{
            for (Label x : labels){
                if (x == labelAceleracion || x==labelRoce || x== labelMasa3 || x==labelPolea || x==labelRadio || x==labelTension2 || x==labelTension){}
                else{
                    x.setVisible(true);
                }
            }
            for (TextField x : textfields){
                if (x== textAceleracion || x == textRoce || x==textMasa3 || x==textRadio || x==textTension2 || x==textTension){}
                else{
                    x.setVisible(true);
                }
            }
        }
        calcular.setOnAction(e -> this.calcularAceleracion(event));
    }
    private void seleccionTension(ActionEvent event){
        this.clear();
        checkRoce.setVisible(true);
        for (Label x : labels){
            if (x == labelTension || x==labelRoce || x== labelMasa3 || x==labelPolea || x==labelRadio || x==labelTension2){}
            else{
                x.setVisible(true);
            }
        }
        for (TextField x : textfields){
            if (x== textTension || x == textRoce || x==textMasa3 || x==textRadio || x==textTension2 ){}
            else{
                x.setVisible(true);
            }
        }
        calcular.setOnAction(e -> this.calcularTension(event));
        
    }
    private void seleccionTensiones(ActionEvent event){
        this.clear();
        checkRoce.setVisible(true);
        for (Label x : labels){
            if (x == labelTension || x==labelRoce || x==labelTension2){}
            else{
                x.setVisible(true);
            }
        }
        for (TextField x : textfields){
            if (x== textTension || x == textRoce || x==textTension2 ){}
            else{
                x.setVisible(true);
            }
        }
        calcular.setOnAction(e -> this.calcularTensiones(event));
        
    }
//    private void seleccionRadio(ActionEvent event){
//        this.clear();
//        checkRoce.setVisible(true);
//        for (Label x : labels){
//            if (x==labelRadio || x==labelRoce){}
//            else{
//                x.setVisible(true);
//            }
//        }
//        for (TextField x : textfields){
//            if (x==textRadio || x==textRoce){}
//            else{
//                x.setVisible(true);
//            }
//        }
//        calcular.setOnAction(e -> this.calcularRadio(event));
//        
//    }
//    private void seleccionMasa(ActionEvent event){
//        this.clear();
//        checkRoce.setVisible(true);
//        for (Label x : labels){
//            if (x== labelMasa3 || x==labelRoce ){}
//            else{
//                x.setVisible(true);
//            }
//        }
//        for (TextField x : textfields){
//            if (x==textMasa3 || x==textRoce){}
//            else{
//                x.setVisible(true);
//            }
//        }
//        calcular.setOnAction(e -> this.calcularMasa(event));
//    }
//    private void seleccionAngular(ActionEvent event){
//        this.clear();
//        for (Label x : labels){
//            if (x== labelAceleracion || x== labelRadio ){
//                x.setVisible(true);
//            }
//        }
//        for (TextField x : textfields){
//            if (x==textAceleracion || x==textRadio ){
//                x.setVisible(true);
//            }
//        }
//        calcular.setOnAction(e -> this.calcularAngular(event));
//                
//    }
    @FXML
    private void calcularAceleracion(ActionEvent event) {
        double masa1= Util.filtro(textMasa1);
        double masa2= Util.filtro(textMasa2);
        double masa3=Util.filtro(textMasa3);
        double roce= Util.filtro(textRoce);
        double pesoY= Fisica.fuerzaPeso(masa2);
        double pesoX= Fisica.fuerzaPesoX(Fisica.fuerzaPeso(masa1), Util.filtro(textAngulo));
        double resultado = (pesoY - pesoX - roce)/(masa1 + masa2 + masa3/2);
        labelResultado1.setText("Aceleración");
        labelResultado2.setText(String.valueOf(Fisica.truncarDecimal(resultado, 3) + " M/s^2"));
    }
    @FXML
    private void calcularTension(ActionEvent event){
        double masa1= Util.filtro(textMasa1);
        double masa2= Util.filtro(textMasa2);
        double roce= Util.filtro(textRoce);
        double aceleracion= Util.filtro(textAceleracion);
        double pesoX= Fisica.fuerzaPesoX(Fisica.fuerzaPeso(masa1), Util.filtro(textAngulo));
        double resultado = (masa1 * aceleracion + roce + pesoX);
        labelResultado1.setText("Tensión");
        labelResultado2.setText(String.valueOf(Fisica.truncarDecimal(resultado, 3) + " N"));
    }
    @FXML
    private void calcularTensiones(ActionEvent event){
        double masa1= Util.filtro(textMasa1);
        double masa3= Util.filtro(textMasa3);
        double masa2= Util.filtro(textMasa2);
        double roce= Util.filtro(textRoce);
        double aceleracion= Util.filtro(textAceleracion);
        double pesoX= Fisica.fuerzaPesoX(Fisica.fuerzaPeso(masa1), Util.filtro(textAngulo));
        double tension= masa1 * aceleracion + roce + pesoX;
        double resultado = (masa3 * aceleracion / 2 + tension);
        labelResultado1.setText("Tensión 1= " + String.valueOf(Fisica.truncarDecimal(tension,2)) + " N");
        labelResultado2.setText("Tensión 2= " + String.valueOf(Fisica.truncarDecimal(resultado, 2) + " N"));
    }
//    @FXML
//    private void calcularMasa(ActionEvent event){
//        
//    }
//    @FXML
//    private void calcularRadio(ActionEvent event){
//        
//    }
//    @FXML
//    private void calcularAngular(ActionEvent event){
//        
//    }
    @FXML
    private void CheckBoxRoce( ActionEvent event) throws Exception{
        if (checkRoce.isSelected()){
            textRoce.setVisible(true);
            textRoce.setText("");
            labelRoce.setVisible(true);
        }
        if (! checkRoce.isSelected()){
            textRoce.setVisible(false);
            labelRoce.setVisible(false);
        }
    }
}
