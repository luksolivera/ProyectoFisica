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
public abstract class Variable {
    private double dato;
    private String unidad;
    private Calculo calculo;
    public Variable(String cadena){
        this.unidad = cadena;
    }
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
    
    public Calculo getCalculo() {
        return calculo;
    }

    public void setCalculo(Calculo calculo) {
        this.calculo = calculo;
    }

    
    public String calcular(OrdenadorDeVariable ordenador,boolean[] disponible){
       return this.calculo.calcular(ordenador,disponible);
    }
    
}
