/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MRUV;

import MRUV.Calculo;
import MRUV.DistanciaFinal;
import MRUV.DistanciaInicial;
import MRUV.OrdenadorDeVariable;
import MRUV.Tiempo;
import MRUV.VelocidadFinal;
import MRUV.VelocidadInicial;
import generales.Fisica;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class CalculoAceleracion extends Calculo{
    private String unidad;
  @Override
    public String calcular(OrdenadorDeVariable ordenador,boolean[] disponible) {
        VelocidadInicial vInicial = ordenador.getVelocidadInicial();
        VelocidadFinal vFinal = ordenador.getVelocidadFinal();
        Tiempo t= ordenador.getTiempo();
        DistanciaInicial dInicial = ordenador.getDistanciaInicial();
        DistanciaFinal dFinal = ordenador.getDistanciaFinal(); 
        this.unidad = ordenador.getAceleracion().getUnidad();
        
        System.out.println(vInicial.getDato()+"\n"+vFinal.getDato()+"\n"+t.getDato()+"\n"+dInicial.getDato()+"\n"+dFinal.getDato()+"\n\n");
        System.out.println(String.valueOf(!disponible[2] & !disponible[3]));
//        if(dFinal.getDato() == Double.NaN & dInicial.getDato() == Double.NaN)
//        if(dFinal == null & dInicial == null)
          if(disponible[0] & disponible[1] & !disponible[2] & !disponible[3] & disponible[4])    
            return calcularSinDistanciaFinalYDistanciaInicial(vInicial,vFinal,t);
//        if(vInicial.getDato() == Double.NaN)
//        if(vInicial == null)
          if(disponible[0] & !disponible[1] & disponible[2] & disponible[3] & disponible[4])    
            return calcularSinVelocidadInicial(vFinal,t,dInicial,dFinal);
//        if(vFinal.getDato() == Double.NaN)
//        if(vFinal == null)
          if(!disponible[0] & disponible[1] & disponible[2] & disponible[3] & disponible[4])    
            return calcularSinVelocidadFinal(vInicial,t,dInicial,dFinal);
//        if(t.getDato() == Double.NaN)
//        if(t == null)
          if(disponible[0] & disponible[1] & disponible[2] & disponible[3] & !disponible[4])    
            return calcularSinTiempo(vInicial,vFinal,dInicial,dFinal);
        
          if(!disponible[0] | !disponible[1] | !disponible[2] | !disponible[3] | !disponible[4]){
            JOptionPane.showMessageDialog(null, "Faltan datos para resolver", "Error", JOptionPane.ERROR_MESSAGE);
            return "";
        }else
            return verificarCuentas(vFinal,vInicial,dFinal,dInicial,t);
    }

    private String calcularSinDistanciaFinalYDistanciaInicial(VelocidadInicial vInicial, VelocidadFinal vFinal, Tiempo t) {
        double respuesta = Fisica.mruvAceleracionVelocidad(vFinal.getDato(), vInicial.getDato(), t.getDato());
        return String.valueOf(respuesta)+" "+this.unidad;
    }

    private String calcularSinVelocidadInicial(VelocidadFinal vFinal, Tiempo t, DistanciaInicial dInicial, DistanciaFinal dFinal) {
        double respuesta = Fisica.mruvAceleracionSinV0(vFinal.getDato(), t.getDato(), dInicial.getDato(), dFinal.getDato());
        return String.valueOf(respuesta)+" "+this.unidad;
    }

    private String calcularSinVelocidadFinal(VelocidadInicial vInicial, Tiempo t, DistanciaInicial dInicial, DistanciaFinal dFinal) {
        double respuesta = Fisica.mruvAceleracionPosicion(dFinal.getDato(), dInicial.getDato(), vInicial.getDato(), t.getDato());
        return String.valueOf(respuesta)+" "+this.unidad;
    }

    private String calcularSinTiempo(VelocidadInicial vInicial, VelocidadFinal vFinal, DistanciaInicial dInicial, DistanciaFinal dFinal) {
        double respuesta = Fisica.mruvAceleracionSinT(vFinal.getDato(), vInicial.getDato(), dInicial.getDato(), dFinal.getDato());
        return String.valueOf(respuesta)+" "+this.unidad;        
    }

    private String verificarCuentas(VelocidadFinal vFinal, VelocidadInicial vInicial, DistanciaFinal dFinal, DistanciaInicial dInicial, Tiempo t) {
        double r0 = Fisica.mruvAceleracionVelocidad(vFinal.getDato(), vInicial.getDato(), t.getDato());
        double r1 = Fisica.mruvAceleracionPosicion(dFinal.getDato(), dInicial.getDato(), vInicial.getDato(), t.getDato());
        double r2 = Fisica.mruvAceleracionSinT(vFinal.getDato(), vInicial.getDato(), dInicial.getDato(), dFinal.getDato());
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
