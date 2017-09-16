/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MRUV;

import MRUV.Aceleracion;
import MRUV.Calculo;
import MRUV.DistanciaFinal;
import MRUV.DistanciaInicial;
import MRUV.OrdenadorDeVariable;
import MRUV.Tiempo;
import MRUV.VelocidadFinal;
import generales.Fisica;
import javax.swing.JOptionPane;

/**
 *
 * @author MCristopher
 */
public class CalculoVelocidadInicial extends Calculo{
    private String unidad;
    private String calcularSinDistanciaFinalYDistanciaInicial(VelocidadFinal vFinal,Aceleracion a,Tiempo t){
        double resultado = Fisica.mruvVelocidadInicial(vFinal.getDato(),a.getDato(),t.getDato());
        return String.valueOf(resultado)+" "+ this.unidad;
    }
    private String calcularSinVelocidadFinal(DistanciaInicial dInicial,DistanciaFinal dFinal,Aceleracion a,Tiempo t){
       double resultado = Fisica.mruvVelocidadInicialPosicion(dInicial.getDato(), dFinal.getDato(), a.getDato(), t.getDato());
       return String.valueOf(resultado)+" "+this.unidad;
    }
    private String calcularSinAceleracion(DistanciaInicial dInicial,DistanciaFinal dFinal,VelocidadFinal vFinal,Tiempo t){
        double resultado = Fisica.mruvVelocidadInicialSinA(vFinal.getDato(), t.getDato(), dInicial.getDato(), dFinal.getDato());
        return String.valueOf(resultado)+" "+this.unidad;
    }
    private String calcularSinTiempo(DistanciaInicial dInicial,DistanciaFinal dFinal,VelocidadFinal vFinal,Aceleracion a){
        double[] resultado = Fisica.mruvVelocidadInicialSinT(vFinal.getDato(), a.getDato(), dInicial.getDato(), dFinal.getDato());
        return String.valueOf(resultado[0])+" "+this.unidad+" y/0 "+String.valueOf(resultado[1])+" "+this.unidad;
    }

    @Override
    public String calcular(OrdenadorDeVariable ordenador,boolean[] disponible) {
        
        VelocidadFinal vFinal = ordenador.getVelocidadFinal();
        Aceleracion a = ordenador.getAceleracion();
        Tiempo t = ordenador.getTiempo();
        DistanciaInicial dInicial = ordenador.getDistanciaInicial();
        DistanciaFinal dFinal = ordenador.getDistanciaFinal();
        this.unidad = ordenador.getVelocidadInicial().getUnidad();
        
//       if(dInicial.getDato() == Double.NaN & dFinal.getDato() == Double.NaN)
//       if(dInicial == null & dFinal == null)
        if(disponible[0] & disponible[1] & !disponible[2] & !disponible[3] & disponible[4])        
           return calcularSinDistanciaFinalYDistanciaInicial(vFinal, a, t);
//       if(vFinal.getDato() == Double.NaN)
//       if(vFinal == null)
        if(!disponible[0] & disponible[1] & disponible[2] & disponible[3] & disponible[4])    
           return calcularSinVelocidadFinal(dInicial, dFinal, a, t);
//       if(a.getDato() == Double.NaN)
//       if(a == null)
        if(disponible[0] & !disponible[1] & disponible[2] & disponible[3] & disponible[4])
           return calcularSinAceleracion(dInicial, dFinal, vFinal, t);
//       if(t.getDato() == Double.NaN)
//       if(t == null)
        if(disponible[0]& disponible[1] & disponible[2] & disponible[3] & !disponible[4])        
           return calcularSinTiempo(dInicial, dFinal, vFinal, a);
        
        if(!disponible[0] | !disponible[1] | !disponible[2] | !disponible[3] | !disponible[4]){
            JOptionPane.showMessageDialog(null, "Faltan datos para resolver", "Error", JOptionPane.ERROR_MESSAGE);
            return "";
        }else
            return verificarCuentas(vFinal,a,t,dInicial,dFinal);    
    }

    private String verificarCuentas(VelocidadFinal vFinal, Aceleracion a, Tiempo t, DistanciaInicial dInicial, DistanciaFinal dFinal) {
        double r0 = Fisica.mruvVelocidadInicial(vFinal.getDato(), a.getDato(), t.getDato());
        double r1 = Fisica.mruvVelocidadInicialPosicion(dInicial.getDato(), dFinal.getDato(), a.getDato(), t.getDato());
        double r2 = Fisica.mruvVelocidadInicialSinA(vFinal.getDato(), t.getDato(), dInicial.getDato(), dFinal.getDato());
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