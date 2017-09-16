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
public class Rotacional extends MRUV{

    public Rotacional(Guardador guardador) {
        super(guardador);
    }

    @Override
    public double velocidadInicialY() {
        return 0;
    }

    @Override
    public double velocidadFinalY() {
        return 0;
    }

    @Override
    public double posicionInicialY() {
    return 0;
    }

    @Override
    public double posicionFinalY() {
        return 0;
    }

    @Override
    public double tiempoY() {
        return 0;
    }
    
}
