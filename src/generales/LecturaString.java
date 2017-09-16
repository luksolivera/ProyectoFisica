/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generales;

import java.awt.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author User
 */
public class LecturaString {
    private double numero;
    public LecturaString(TextField campo){
        String cadena = campo.getText();
        //
//        try{
//            this.numero = Double.valueOf(cadena);
//        }
//        catch(VacioException e){
//            this.numero = e.dameUn0;
//            //cartel
//        }
//        catch(LetraANumeroException e){
//            this.numero = e.dameUn0;
//            //cartel y se rompio
//            
//        }
        //
        if(cadena == "")
            this.numero = 0;
        else 
            this.numero = Double.valueOf(cadena);
    }
    public LecturaString(String cadena){
        if(cadena == "")
            this.numero = 0;
        else 
            this.numero = Double.valueOf(cadena);
    }
    public double getNumero(){
        return this.numero;
    }
}
