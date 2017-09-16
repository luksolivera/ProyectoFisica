/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

import generales.Fisica;

/**
 *
 * @author USER
 */
public class CaidaLibre extends MRUV{

    public CaidaLibre(Guardador guardador) {
        super(guardador);
    }

    @Override
    public double velocidadInicialY() {
        //if (var.isPosicion()){
            double ter1=(var.getPosicionYFinal()-var.getPosicionYInicial())/var.getTiempo();
            double ter2= (var.getAceleracion()*var.getTiempo())/2.0;
            return ter1+ter2;
          //  }
       // return (var.getVelocidadFinal()-var.getTiempo()*Fisica.gravedad);
    }

    @Override
    public double velocidadFinalY() {
        return var.getVelocidadInicial()-var.getAceleracion()*var.getTiempo();
    }

    @Override
    public double posicionInicialY() {
        double ter1=-var.getVelocidadInicial()*var.getTiempo();
        double ter2=var.getTiempo()*var.getTiempo()*var.getAceleracion()/2.0;
        return ter1+ter2+var.getPosicionYFinal();
        }

    @Override
    public double posicionFinalY() {
        double ter1=var.getVelocidadInicial()*var.getTiempo();
        double ter2=-var.getTiempo()*var.getTiempo()*var.getAceleracion()/2.0;
        return ter1+ter2+var.getPosicionYInicial();
    }

    @Override
    public double tiempoY() {
        if (var.isPosicion()){
            double a=-var.getAceleracion()/2.0;
            double b=var.getVelocidadInicial();
            double c=var.getPosicionYInicial()-var.getPosicionYFinal();
            double [] resultado= Fisica.vascara(a, b, c);
            if (Fisica.truncarDecimal(resultado [0], 4) == Fisica.truncarDecimal(resultado [1], 4))
                return resultado [0];
            var.setResultado(true);
            var.setTiempo(resultado[1]);
            return resultado[0];
        }
        else{
            return -(var.getVelocidadFinal()-var.getVelocidadInicial())/var.getAceleracion();
        }
    }

    @Override
    public String toString() {
        return "Caída libre";
    }
    
}
