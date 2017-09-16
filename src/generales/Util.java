/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generales;

import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Util {
    public static double filtro(TextField text){
        Boolean tiene=true;
        double resultado=0.0;
        if (text.getText()== ""){
            resultado= 0.0;      
        }
        for (int x=0;x<text.getText().length();x++){
            if (text.getText().codePointAt(x)>= 45 && text.getText().codePointAt(x) <= 57){
                tiene=false;
                if(text.getText().codePointAt(x)== 47){
                    String [] corte= text.getText().split("/");
                    double numerador = Double.valueOf(corte[0]);
                    double denominador = Double.valueOf(corte[1]);
                    text.setText(String.valueOf(numerador / denominador));
                }
            }
            else{
                tiene=true;
                JOptionPane.showMessageDialog(null, "no ingrese letras ni caracteres especiales","Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
        }

        if (tiene == false){
            resultado = Double.valueOf(text.getText());
        }
        if (tiene == true){
            
        }
        return resultado;  
    }
    public static double filtro2(TextField text){
                Boolean tiene=true;
        double resultado=0.0;
        if (text.getText()== ""){
            resultado= 0.0;      
        }
        for (int x=0;x<text.getText().length();x++){
            if (text.getText().codePointAt(x)>= 46 && text.getText().codePointAt(x) <= 57){
                tiene=false;
                if(text.getText().codePointAt(x)== 47){
                    String [] corte= text.getText().split("/");
                    double numerador = Double.valueOf(corte[0]);
                    double denominador = Double.valueOf(corte[1]);
                    text.setText(String.valueOf(numerador / denominador));
                }
            }
            else{
                tiene=true;
                JOptionPane.showMessageDialog(null, "no ingrese letras ni caracteres especiales","Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
        }

        if (tiene == false){
            resultado = Double.valueOf(text.getText());
        }
        if (tiene == true){
            
        }
        return resultado;
    }
}
