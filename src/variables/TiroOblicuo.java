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
public class TiroOblicuo extends MRUV{

    public TiroOblicuo(Guardador guardador) {
        super(guardador);
    }
    @Override
    public double velocidadInicialY() {
        //Rvisar si se puede calcular dependiendo de la velocidad final
        double ter1=(var.getPosicionYFinal()-var.getPosicionYInicial())/var.getTiempo();
        double ter2= (var.getAceleracion()*var.getTiempo())/2.0;
        double resultado=(ter1+ter2)/Fisica.sen(var.getAngulo());
        return resultado;
    }

    @Override
    public double velocidadFinalY() {
        return var.getVelocidadInicial()*Fisica.sen(var.getAngulo())-var.getAceleracion()*var.getTiempo();
    }

    @Override
    public double posicionInicialY() {
        double ter1=-var.getVelocidadInicial()*Fisica.sen(var.getAngulo())*var.getTiempo();
        double ter2=var.getTiempo()*var.getTiempo()*var.getAceleracion()/2.0;
        return ter1+ter2+var.getPosicionYFinal();
        }

    @Override
    public double posicionFinalY() {
        double ter1=var.getVelocidadInicial()*Fisica.sen(var.getAngulo())*var.getTiempo();
        double ter2=-var.getTiempo()*var.getTiempo()*var.getAceleracion()/2.0;
        return ter1+ter2+var.getPosicionYInicial();
    }

    @Override
    public double tiempoY() {
        if (var.isPosicion()){
            double a=-var.getAceleracion()/2.0;
            double b=var.getVelocidadInicial()*Fisica.sen(var.getAngulo());
            double c=var.getPosicionYInicial()-var.getPosicionYFinal();
            double [] resultado= Fisica.vascara(a, b, c);
            var.setTiempo(resultado[1]);
            var.setResultado(true);
            return resultado[0];
        }
        else{
            return (var.getVelocidadInicial()-var.getVelocidadFinal())/var.getAceleracion();
        }
    }
    
    
    
    @Override
    public double posicionInicialX(){
        return (var.getPosicionXFinal()-var.getVelocidadInicial()*Fisica.cos(var.getAngulo())*var.getTiempo());
        
    }
    @Override
    public double posicionFinalX(){
        return (var.getPosicionXInicial()+var.getVelocidadInicial()*Fisica.cos(var.getAngulo())*var.getTiempo());
    }
    @Override
    public double velocidadInicialX(){
        return (var.getPosicionXFinal()-var.getVelocidadInicial())/(var.getTiempo()*Fisica.cos(var.getAngulo()));
    }
    @Override
    public double angulo(){
        double ter1=(var.getPosicionYFinal()-var.getPosicionYInicial())/var.getTiempo();
        double ter2= (var.getAceleracion()*var.getTiempo())/2.0;
        double v0y= (ter1+ter2);
        double anguloRad= Math.asin(v0y/var.getVelocidadInicial());
        return anguloRad*180.0/Math.PI;
    }
    @Override
    public double tiempoX(){
        double resultado=(var.getPosicionXFinal()-var.getPosicionXInicial())/(var.getVelocidadInicial()*Fisica.cos(var.getAngulo()));
        return resultado;
    }
}
