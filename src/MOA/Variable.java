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
public abstract class Variable {
    private String unidad;
    private double valor;
    public Variable(String unidad){
        this.unidad = unidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public abstract double calcularMOA(double amplitud, double frecuencia, double faseInicial,double tiempo);
    
}
