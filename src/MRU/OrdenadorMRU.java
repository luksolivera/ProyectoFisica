/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MRU;

/**
 *
 * @author MCristopher
 */
public class OrdenadorMRU {
    PosicionFinal pFinal;
    PosicionInicial pInicial;
    Velocidad velocidad;
    Tiempo tiempo;
    
    public OrdenadorMRU(){
        this.pFinal = null;
        this.pInicial = null;
        this.velocidad = null;
        this.tiempo = null;
    }

    public double getpFinal() {
        return pFinal.getDato();
    }

    public void setpFinal(PosicionFinal pFinal) {
        this.pFinal = pFinal;
    }

    public double getpInicial() {
        return pInicial.getDato();
    }

    public void setpInicial(PosicionInicial pInicial) {
        this.pInicial = pInicial;
    }

    public double getVelocidad() {
        return velocidad.getDato();
    }

    public void setVelocidad(Velocidad velocidad) {
        this.velocidad = velocidad;
    }

    public double getTiempo() {
        return tiempo.getDato();
    }

    public void setTiempo(Tiempo tiempo) {
        this.tiempo = tiempo;
    }
    
    
}
