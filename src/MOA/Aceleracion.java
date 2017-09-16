/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MOA;

/**
 *
 * @author User
 */
public class Aceleracion extends Variable{
    public Aceleracion(String unidad){
        super(unidad);
    }

    @Override
    public String toString() {
        return "Aceleración";
    }

    @Override
    public double calcularMOA(double amplitud, double frecuencia, double faseInicial, double tiempo) {
        return generales.Fisica.moaAceleracion(amplitud, frecuencia, faseInicial, tiempo);
    }
    
}
