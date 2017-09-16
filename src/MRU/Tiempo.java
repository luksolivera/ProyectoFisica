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
public class Tiempo extends VariableMRU{

    public Tiempo(String unidad) {
        super(unidad);
    }

    @Override
    public String toString() {
        return "Tiempo";
    }

    @Override
    public double calcular(OrdenadorMRU ordenador){
        return Fisica.mruTiempo(ordenador.getVelocidad(),ordenador.getpFinal()-ordenador.getpInicial());
    }
    
}
