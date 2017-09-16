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
public class Velocidad extends Tema{
    Image imagen2=new Image(getClass().getResourceAsStream("velocidad2.jpg"));
    Image imagen1=new Image(getClass().getResourceAsStream("velocidad1.jpg"));
    String texto= "\n\n        Image imagen2=new Image(getClass().getResourceAsStream(\"velocidad2.jpg\"));\n" +
"    Image imagen1=new Image(getClass().getResourceAsStream(\"velocidad1.jpg\"));  Vector de Velocidad:\n" +
            " \n\n                Rapidez:\n\n\nVector de Velocidad Instatntánea:";
    String titulo= "Velocidad";
    @Override
    public String getTitulo() {
        return titulo;
    }
    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Velocidad(){
        
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
        return new Aceleracion();
    }

    @Override
    public Tema anterior() {
        return new Desplazamiento();
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
