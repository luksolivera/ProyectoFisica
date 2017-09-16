/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

import generales.Fisica;

/**
 *
 * @author usuario
 */
public class Fuerza {
    private double fuerza;
    private double angulo;
    public Fuerza(){
        this.fuerza=0;
        this.angulo=0;
    }
    public Fuerza(double fuerza, double angulo){
        this.fuerza=fuerza;
        this.angulo=angulo;
    }
    public double getFuerza(){
        return fuerza;
    }
    
    public double getAngulo(){
        return angulo;
    }
    public void setFuerza(double fuerza){
        this.fuerza=fuerza;
    }
    
    public void setAngulo(double angulo){
        this.angulo=angulo;
    }
    public double getFuerzaX(){
        return Fisica.fuerzaEjex(fuerza, angulo);
    }
    public double getFuerzaY(){
        return Fisica.fuerzaEjey(fuerza, angulo);
    }
}
