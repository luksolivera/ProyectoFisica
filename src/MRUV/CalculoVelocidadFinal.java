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
import MRUV.VelocidadInicial;
import generales.Fisica;
import javax.swing.JOptionPane;

/**
 *
 * @author MCristopher
 */
public class CalculoVelocidadFinal extends Calculo{
    private String unidad;
    private String calcularSinDistanciaInicialYDistanciaFinal(VelocidadInicial vInicial,Aceleracion a, Tiempo t){
        double resultado = Fisica.mruvVelocidadFinal(vInicial.getDato(),a.getDato(),t.getDato());
        return String.valueOf(resultado)+" "+this.unidad;
    }
    private String calcularSinVelocidadInicial(DistanciaInicial dInicial,DistanciaFinal dFinal,Aceleracion a, Tiempo t){
       double resultado = Fisica.mruvVelocidadFinalSinV0(a.getDato(), t.getDato(), dInicial.getDato(), dFinal.getDato());
       return String.valueOf(resultado)+ " "+this.unidad;
    }
    private String calcularSinAceleracion(DistanciaInicial dInicial,DistanciaFinal dFinal,VelocidadInicial vInicial, Tiempo t){        
        double resultado =  Fisica.mruvVelocidadFinalSinA(vInicial.getDato(), t.getDato(), dInicial.getDato(), dFinal.getDato());
        return String.valueOf(resultado)+" "+this.unidad;
    }
    private String calcularSinTiempo(DistanciaInicial dInicial,DistanciaFinal dFinal,VelocidadInicial vInicial, Aceleracion a){        
        double[] resultado = Fisica.mruvVelocidadFinalSinT(vInicial.getDato(), a.getDato(), dInicial.getDato(), dFinal.getDato());
        return String.valueOf(resultado[0])+" "+this.unidad+" y/0 "+String.valueOf(resultado[1])+" "+this.unidad;
    }
      @Override
    public String calcular(OrdenadorDeVariable ordenador, boolean[] disponible) {
        VelocidadInicial vInicial = ordenador.getVelocidadInicial();
        Aceleracion a = ordenador.getAceleracion();
        Tiempo t = ordenador.getTiempo();
        DistanciaInicial dInicial = ordenador.getDistanciaInicial();
        DistanciaFinal dFinal = ordenador.getDistanciaFinal();
        this.unidad = ordenador.getVelocidadFinal().getUnidad();
//       if(dFinal.getDato() == Double.NaN & dInicial.getDato() == Double.NaN)
//       if(dFinal == null & dInicial == null)
         if(disponible[0] & disponible[1] & !disponible[2] & !disponible[3] & disponible[4])    
           return calcularSinDistanciaInicialYDistanciaFinal(vInicial, a, t);
//       if(vInicial.getDato() == Double.NaN)
//       if(vInicial == null)
        if(disponible[0] & !disponible[1] & disponible[2] & disponible[3] & disponible[4])    
           return calcularSinVelocidadInicial(dInicial, dFinal, a, t);
//       if(a.getDato() == Double.NaN)
//       if(a == null)
        if(!disponible[0] & disponible[1]& disponible[2] & disponible[3] & disponible[4])    
           return calcularSinAceleracion(dInicial, dFinal, vInicial, t);
//       if(t.getDato() == Double.NaN)
//       if(t == null)
        if(disponible[0] & disponible[1] & disponible[2] & disponible[3] & !disponible[4])    
           return calcularSinTiempo(dInicial, dFinal, vInicial, a);
        
        if(!disponible[0] | !disponible[1] | !disponible[2] | !disponible[3] | !disponible[4]){
            JOptionPane.showMessageDialog(null, "Faltan datos para resolver", "Error", JOptionPane.ERROR_MESSAGE);
            return "";
        }else
            return verificarCuentas(vInicial,a,t,dInicial,dFinal); 
    }

    private String verificarCuentas(VelocidadInicial vInicial, Aceleracion a, Tiempo t, DistanciaInicial dInicial, DistanciaFinal dFinal) {
        double r0 = Fisica.mruvVelocidadFinal(vInicial.getDato(),a.getDato(),t.getDato());
        double r1 = Fisica.mruvVelocidadFinalSinV0(a.getDato(), t.getDato(), dInicial.getDato(), dFinal.getDato());
        double r2 = Fisica.mruvVelocidadFinalSinA(vInicial.getDato(), t.getDato(), dInicial.getDato(), dFinal.getDato());
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

