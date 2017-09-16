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
public class PosicionFinal extends VariableMRU{

    public PosicionFinal(String unidad) {
        super(unidad);
    }

    @Override
    public String toString() {
        return "Posición final";
    }
    
    @Override
    public double calcular(OrdenadorMRU ordenador){
        return ordenador.getpInicial() + Fisica.mruDistancia(ordenador.getVelocidad(), ordenador.getTiempo());
    }
    
    //SOLO PORQUE ES UNA FORMULA
//    public double formula1(double velocidad,double tiempo, double pInicial){
//    }
}
