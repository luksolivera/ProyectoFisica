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
import MRUV.VelocidadFinal;
import MRUV.VelocidadInicial;
import generales.Fisica;
import javax.swing.JOptionPane;

/**
 *
 * @author MCristopher
 */
public class CalculoTiempo extends Calculo{
    private String unidad;
      @Override
    public String calcular(OrdenadorDeVariable ordenador,boolean[] disponible) {
        VelocidadInicial vInicial = ordenador.getVelocidadInicial();
        VelocidadFinal vFinal = ordenador.getVelocidadFinal();
        Aceleracion a = ordenador.getAceleracion();
        DistanciaInicial dInicial = ordenador.getDistanciaInicial();
        DistanciaFinal dFinal = ordenador.getDistanciaFinal();
        this.unidad = ordenador.getTiempo().getUnidad();
//       if(dInicial.getDato() == Double.NaN & dFinal.getDato() == Double.NaN)
//       if(dInicial == null & dFinal == null)
        if(disponible[0] & disponible[1] & !disponible[2] & !disponible[3] & disponible[4])    
           return calcularSinDistanciaFinalYDistanciaInicial(vInicial,vFinal,a);
//       if(vFinal.getDato() == Double.NaN)
//       if(vFinal == null)
        if(!disponible[0] & disponible[1] & disponible[2] & disponible[3] & disponible[4])    
           return calcularSinVelocidadFinal(vInicial,a,dInicial,dFinal);
//       if(vInicial.getDato() == Double.NaN)
//       if(vInicial == null)
        if(disponible[0] & !disponible[1] & disponible[2] & disponible[3] & disponible[4])    
           return calcularSinVelocidadInicial(vFinal,a,dInicial,dFinal);
//       if(a.getDato() == Double.NaN)
//       if(a == null)
        if(disponible[0] & disponible[1] & disponible[2] & disponible[3] & !disponible[4])
           return calcularSinAceleracion(vInicial,vFinal,dInicial,dFinal);
        
        if(!disponible[0] | !disponible[1] | !disponible[2] | !disponible[3] | !disponible[4]){
            JOptionPane.showMessageDialog(null, "Faltan datos para resolver", "Error", JOptionPane.ERROR_MESSAGE);
            return "";
        }else
            return verificarCuentas(vFinal,vInicial,a,dInicial,dFinal);
    }

    private String calcularSinDistanciaFinalYDistanciaInicial(VelocidadInicial vInicial, VelocidadFinal vFinal, Aceleracion a) {
        double resultado = Fisica.mruvTiempoVelocidad(vFinal.getDato(), vInicial.getDato(), a.getDato());
                return String.valueOf(resultado)+" "+this.unidad;
    }

    private String calcularSinVelocidadFinal(VelocidadInicial vInicial, Aceleracion a, DistanciaInicial dInicial, DistanciaFinal dFinal) {
        double[] resultado = Fisica.mruvTiempoPosicion(dFinal.getDato(), dInicial.getDato(), vInicial.getDato(), a.getDato());
                return String.valueOf(resultado[0])+" "+this.unidad+" y/0 "+String.valueOf(resultado[1])+" "+this.unidad ;
    }

    private String calcularSinVelocidadInicial(VelocidadFinal vFinal, Aceleracion a, DistanciaInicial dInicial, DistanciaFinal dFinal) {
        double[] resultado = Fisica.mruvTiempoSinV0(vFinal.getDato(), a.getDato(), dInicial.getDato(), dFinal.getDato());
                return String.valueOf(resultado[0])+" "+this.unidad+" y/0 "+String.valueOf(resultado[1])+" "+this.unidad;
    }

    private String calcularSinAceleracion(VelocidadInicial vInicial, VelocidadFinal vFinal, DistanciaInicial dInicial, DistanciaFinal dFinal) {
        double resultado = Fisica.mruvTiempoSinA(vFinal.getDato(), vInicial.getDato(), dInicial.getDato(), dFinal.getDato());
                return String.valueOf(resultado)+" "+this.unidad;
    }

    private String verificarCuentas(VelocidadFinal vFinal, VelocidadInicial vInicial, Aceleracion a, DistanciaInicial dInicial, DistanciaFinal dFinal) {
        double r0 = Fisica.mruvTiempoVelocidad(vFinal.getDato(), vInicial.getDato(), a.getDato());
        double r1 = Fisica.mruvTiempoSinA(vFinal.getDato(), vInicial.getDato(), dInicial.getDato(), dFinal.getDato());
        r0 = Fisica.truncarDecimal(r0, 2);
        r1 = Fisica.truncarDecimal(r1, 2);
        
        String cadena = "";
        if(r0 == r1)
            cadena = String.valueOf(r0)+" "+ this.unidad;
        else{
            JOptionPane.showMessageDialog(null, "Datos mal ingresados", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return cadena;
    }
}