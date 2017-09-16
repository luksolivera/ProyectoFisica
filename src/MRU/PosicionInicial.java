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
public class PosicionInicial extends VariableMRU{

    public PosicionInicial(String unidad) {
        super(unidad);
    }

    @Override
    public String toString() {
        return "Posición inicial";
    }

    @Override
    public double calcular(OrdenadorMRU ordenador){
        return ordenador.getpFinal() - Fisica.mruDistancia(ordenador.getVelocidad(), ordenador.getTiempo());
    }
    
}
