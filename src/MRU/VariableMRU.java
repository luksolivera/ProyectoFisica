/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MRU;

/**
 *
 * @author MCristopher
 */
public abstract class VariableMRU {
    private double dato;
    private String unidad;
   
    public VariableMRU(String unidad){
        this.unidad = unidad;
    }
    
    public abstract double calcular(OrdenadorMRU ordenador);

    public double getDato() {
        return dato;
    }

    public void setDato(double dato) {
        this.dato = dato;
    }
    
    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
