/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class AceleracionAngular implements VariablesMRUV{
    @Override
    public double calcular(MRUV tipo) {
        try{
            return tipo.aceleracion();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Estan mal pasados los datos");
        }
        return 0;

        
    }

    @Override
    public String toString() {
        return "Aceleración angular";
    }
    @Override
    public String unidad() {
        return "rad/s^2";
    }
}
