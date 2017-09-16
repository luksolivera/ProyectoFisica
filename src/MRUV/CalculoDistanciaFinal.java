/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MRUV;

import MRUV.Aceleracion;
import MRUV.Calculo;
import MRUV.DistanciaInicial;
import MRUV.OrdenadorDeVariable;
import MRUV.Tiempo;
import MRUV.VelocidadFinal;
import MRUV.VelocidadInicial;
import generales.Fisica;
import javax.swing.JOptionPane;

/**
 *
 * @author MCristopher
 */

public class CalculoDistanciaFinal extends Calculo{
    private String unidad;
      @Override
    public String calcular(OrdenadorDeVariable ordenador, boolean[] disponible) {
        VelocidadInicial vInicial = ordenador.getVelocidadInicial();
        VelocidadFinal vFinal = ordenador.getVelocidadFinal();
        Aceleracion a = ordenador.getAceleracion();
        Tiempo t= ordenador.getTiempo();
        DistanciaInicial dInicial = ordenador.getDistanciaInicial();
        this.unidad = ordenador.getDistanciaFinal().getUnidad();
//        if(vFinal.getDato() == Double.NaN)
//        if(vFinal == null)
        if(!disponible[0] & disponible[1] & disponible[2] & disponible[3] & disponible[4])    
            return calcularSinVelocidadFinal(vInicial,a,t,dInicial);
//        if(vInicial.getDato() == Double.NaN)
//        if(vInicial == null)
        if(disponible[0] & !disponible[1] & disponible[2] & disponible[3] & disponible[4])    
            return calcularSinVelocidadInicial(vFinal,a,t,dInicial);
//        if(a.getDato() == Double.NaN)
//        if(a == null)
        if(disponible[0] & disponible[1] & !disponible[2] & disponible[3] & disponible[4])    
            return calcularSinAceleracion(vInicial,vFinal,t,dInicial);
//        if(t.getDato() == Double.NaN)
//        if(t == null)
        if(disponible[0] & disponible[1] & disponible[2] & disponible[3] & !disponible[4])    
            return calcularSinTiempo(vInicial,vFinal,a,dInicial);
        
        if(!disponible[0] | !disponible[1] | !disponible[2] | !disponible[3] | !disponible[4]){
            JOptionPane.showMessageDialog(null, "Faltan datos para resolver", "Error", JOptionPane.ERROR_MESSAGE);
            return "";
        }else
            return verificarCuentas(vFinal,vInicial,a,t,dInicial);
    }

    private String calcularSinVelocidadFinal(VelocidadInicial vInicial, Aceleracion a, Tiempo t, DistanciaInicial dInicial) {
        double resultado = Fisica.mruvPosicionFinal(dInicial.getDato(), vInicial.getDato(), a.getDato(), t.getDato());
                return String.valueOf(resultado)+" "+this.unidad;
    }

    private String calcularSinVelocidadInicial(VelocidadFinal vFinal, Aceleracion a, Tiempo t, DistanciaInicial dInicial) {
        double resultado = Fisica.mruvPosicionFinalSinV0(vFinal.getDato(), a.getDato(), t.getDato(), dInicial.getDato());
                return String.valueOf(resultado)+" "+this.unidad;
    }

    private String calcularSinAceleracion(VelocidadInicial vInicial, VelocidadFinal vFinal, Tiempo t, DistanciaInicial dInicial) {
        double resultado = Fisica.mruvPosicionFinalSinA(vFinal.getDato(), vInicial.getDato(), t.getDato(), dInicial.getDato());
                return String.valueOf(resultado)+" "+this.unidad;
    }

    private String calcularSinTiempo(VelocidadInicial vInicial, VelocidadFinal vFinal, Aceleracion a, DistanciaInicial dInicial) {
        double resultado = Fisica.mruvPosicionFinalSinT(vFinal.getDato(), vInicial.getDato(), a.getDato(), dInicial.getDato());
                return String.valueOf(resultado)+" "+this.unidad;
    }

    private String verificarCuentas(VelocidadFinal vFinal, VelocidadInicial vInicial, Aceleracion a, Tiempo t, DistanciaInicial dInicial) {
        double r0 = Fisica.mruvPosicionFinal(dInicial.getDato(), vInicial.getDato(), a.getDato(), t.getDato());
        double r1 = Fisica.mruvPosicionFinalSinV0(vFinal.getDato(), a.getDato(), t.getDato(), dInicial.getDato());
        double r2 = Fisica.mruvPosicionFinalSinA(vFinal.getDato(), vInicial.getDato(), t.getDato(), dInicial.getDato());
        r0 = Fisica.truncarDecimal(r0, 2);
        r1 = Fisica.truncarDecimal(r1, 2);
        r2 = Fisica.truncarDecimal(r2, 2);
        
        String cadena = "";
        if(r0 == r1 & r1==r2 & r2==r0)
            cadena = String.valueOf(r0)+" "+ this.unidad;
        else{
        JOptionPane.showMessageDialog(null, "Datos mal ingresados", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return cadena;
    }
}