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
abstract public class MRUV {
    protected Guardador var;
    
    public MRUV(Guardador guardador) {
        this.var=guardador;
    }
    public Guardador crearGuardador(){
        var=new Guardador();
        return var;
    }
    public Guardador getVariables(){
        return var;
    }
    
    public double posicionInicialX(){
        return Fisica.mruvPosicionInicial(var.getPosicionXFinal(), var.getVelocidadInicial(), var.getAceleracion(),var.getTiempo());
    }
    public double posicionFinalX(){
        return Fisica.mruvPosicionFinal(var.getPosicionXInicial(), var.getVelocidadInicial(), var.getAceleracion(), var.getTiempo());
    }
    public double velocidadInicialX(){
        return Fisica.mruvVelocidadInicial(var.getVelocidadFinal(), var.getAceleracion(), var.getTiempo());
    }
    abstract public double velocidadInicialY();
    public double velocidadFinalX(){
        return Fisica.mruvEjeyVelocidadFinal(var.getVelocidadInicial(), var.getTiempo());
    }
    abstract public double velocidadFinalY();
    public double angulo(){
        return 0;
    }
    abstract public double posicionInicialY();
    abstract public double posicionFinalY();
    abstract public double tiempoY();
    public double tiempoX(){
        if (var.isPosicion()==true){
                double[] resultados=Fisica.mruvTiempoPosicion(var.getPosicionXFinal(), var.getPosicionXInicial(), var.getVelocidadInicial(), var.getAceleracion());
                var.setTiempo(resultados[0]);
                var.setResultado(true);
                return resultados[1];
            }
            else{
                double resultados=Fisica.mruvTiempoVelocidad(var.getVelocidadFinal(), var.getVelocidadInicial(), var.getAceleracion());
                return resultados;
            }
    }
    public double aceleracion(){
        return Fisica.mruvAceleracionPosicion(var.getPosicionXFinal(), var.getPosicionXInicial(), var.getVelocidadInicial(), var.getTiempo());
    }
}
