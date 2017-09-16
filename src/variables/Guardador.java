/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

/**
 *
 * @author USER
 */
public class Guardador {
    /*Guarda variables valga la redundancia*/
    private double aceleracion=0;
    private double posicionXFinal=0;
    private double posicionXInicial=0;
    private double posicionYFinal=0;
    private double posicionYInicial=0;
    private double tiempo=0;
    private double velocidadFinal=0;
    private double velocidadInicial=0;
    private boolean Posicion=false;
    private double angulo=0;
    private boolean resultado=false;

    public double getAceleracion() {
        return aceleracion;
    }

    public double getPosicionXFinal() {
        return posicionXFinal;
    }

    public double getPosicionXInicial() {
        return posicionXInicial;
    }

    public double getPosicionYFinal() {
        return posicionYFinal;
    }

    public double getPosicionYInicial() {
        return posicionYInicial;
    }

    public double getTiempo() {
        return tiempo;
    }

    public double getVelocidadFinal() {
        return velocidadFinal;
    }

    public double getVelocidadInicial() {
        return velocidadInicial;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public void setPosicionXFinal(double posicionXFinal) {
        this.posicionXFinal = posicionXFinal;
    }

    public void setPosicionXInicial(double posicionXInicial) {
        this.posicionXInicial = posicionXInicial;
    }

    public void setPosicionYFinal(double posicionYFinal) {
        this.posicionYFinal = posicionYFinal;
    }

    public void setPosicionYInicial(double posicionYInicial) {
        this.posicionYInicial = posicionYInicial;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public void setVelocidadFinal(double velocidadFinal) {
        this.velocidadFinal = velocidadFinal;
    }

    public void setVelocidadInicial(double velocidadInicial) {
        this.velocidadInicial = velocidadInicial;
    }

    public void setPosicion(boolean Posicion) {
        this.Posicion = Posicion;
    }

    public boolean isPosicion() {
        return Posicion;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public boolean getResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }
    
    
}
