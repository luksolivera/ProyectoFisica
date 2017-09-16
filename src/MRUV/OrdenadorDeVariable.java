/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MRUV;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 *
 * @author User
 */
public class OrdenadorDeVariable {
        private Aceleracion  aceleracion;
        private DistanciaInicial distanciaInicial;
        private DistanciaFinal distanciaFinal;
        private VelocidadInicial velocidadInicial;
        private VelocidadFinal velocidadFinal;
        private Tiempo tiempo;
//dudoso
    public OrdenadorDeVariable(){
        this.aceleracion = null;
        this.distanciaFinal = null;
        this.distanciaInicial = null;
        this.tiempo = null;
        this.velocidadFinal = null;
        this.velocidadInicial = null;   
    }    
        

    public Aceleracion getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(Aceleracion aceleracion) {
//        if(aceleracion.getDato() != Double.NaN)
            this.aceleracion = aceleracion;
    }

    public DistanciaInicial getDistanciaInicial() {
        return distanciaInicial;
    }

    public void setDistanciaInicial(DistanciaInicial distanciaInicial) {
//        if(distanciaInicial.getDato() != Double.NaN)
            this.distanciaInicial = distanciaInicial;
    }

    public DistanciaFinal getDistanciaFinal() {
        return distanciaFinal;
    }

    public void setDistanciaFinal(DistanciaFinal distanciaFinal) {
//        if(distanciaFinal.getDato() != Double.NaN)
            this.distanciaFinal = distanciaFinal;
    }

    public VelocidadInicial getVelocidadInicial() {
        return velocidadInicial;
    }

    public void setVelocidadInicial(VelocidadInicial velocidadInicial) {
//        if(velocidadInicial.getDato() != Double.NaN)
            this.velocidadInicial = velocidadInicial;
    }

    public VelocidadFinal getVelocidadFinal() {
        return velocidadFinal;
    }

    public void setVelocidadFinal(VelocidadFinal velocidadFinal) {
//        if(velocidadFinal.getDato() != Double.NaN)
            this.velocidadFinal = velocidadFinal;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }

    public void setTiempo(Tiempo tiempo) {
//        if(tiempo.getDato() != Double.NaN)
            this.tiempo = tiempo;
    }
}
