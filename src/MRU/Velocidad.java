/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MRU;

import generales.Fisica;

/**
 *
 * @author MCristopher
 */
public class Velocidad extends VariableMRU{

    public Velocidad(String unidad) {
        super(unidad);
    }

    @Override
    public String toString() {
        return "Velocidad";
    }

    @Override
    public double calcular(OrdenadorMRU ordenador){
        return Fisica.mruVelocidad(ordenador.getTiempo(),ordenador.getpFinal()-ordenador.getpInicial());
    }
    
}
