/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MRUV;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 *
 * @author User
 */
public class VelocidadInicial extends Variable{

    public VelocidadInicial(String unidad){
        super(unidad);
        super.setCalculo(new CalculoVelocidadInicial());
    }

    @Override
    public String toString() {
        return "Velocidad inicial";
    }
    
    
}