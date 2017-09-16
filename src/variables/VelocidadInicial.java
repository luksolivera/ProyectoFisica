/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

import generales.Fisica;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class VelocidadInicial implements VariablesMRUV{
@Override
    public double calcular(MRUV tipo) {
        try{
            
                return tipo.velocidadInicialX();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Estan mal pasados los datos");
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Velocidad inicial";
    }

    @Override
    public String unidad() {
        return "m/s";
    }
    
}
