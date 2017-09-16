/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teoria;

import javafx.scene.image.Image;

/**
 *
 * @author usuario
 */
public class Desplazamiento extends Tema {
    String titulo= "Desplazamiento";
    String texto;
    Image imagen2=new Image(getClass().getResourceAsStream("Desplazamiento2.png"));
    Image imagen1=new Image(getClass().getResourceAsStream("Desplazamiento1.png"));
    public Desplazamiento(){
        texto="Vector Desplazamiento de una particula:\n\nEs el vector que une la posición inicial de la partícula hasta su posición final.\n\n\n\n"+
        "Una partícula está inicialmente en el punto P1 en cierto instante t1.\n" +
        "En el instante t2 la partícula se encuentra en el punto P2.";
    }
    @Override
    public String getTexto() {
        return texto;
    }

    @Override
    public void setTexto(String texto) {
        this.texto=texto;
    }

    @Override
    public Tema siguiente() {
        return new Velocidad();
    }

    @Override
    public Tema anterior() {
        return new Posicion();
    }
    @Override
    public String getTitulo() {
        return titulo;
    }
    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public Image getImagen1() {
        return imagen1;
    }

    @Override
    public Image getImagen2() {
        return imagen2;
    }

    
}
