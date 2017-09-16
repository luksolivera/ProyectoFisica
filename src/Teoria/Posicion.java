/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teoria;

import java.io.InputStream;
import javafx.scene.image.Image;

/**
 *
 * @author usuario
 */
public class Posicion extends Tema{
    String texto= "Reposo relativo:\n Un cuerpo se encuentra en reposo relativo si la posición permanece constante al cabo de un tiempo.\n"+
            "\nVector posición de una particula:\n Para describir el movimiento de una partícula en la recta, el plano o el espacio," +
            "primero debemos conocer su posición.\n"
            + "\nEl vector que une el origen O y el punto P "  +
            "es el vector posición r(t).\n Ejemplo: r (t) = 50.t i + 15.t^2 j";

    String titulo= "Posición";
    Image imagen2=new Image(getClass().getResourceAsStream("Posicion1.png"));
    Image imagen1=new Image(getClass().getResourceAsStream("Posicion2.png"));
    @Override
    public Image getImagen1() {
        return imagen1;
    }

    public void setImagen1(Image imagen1) {
        this.imagen1 = imagen1;
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
    public String getTexto() {
        return texto;
    }
    @Override
    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public Tema siguiente() {
        return new Desplazamiento();
    }

    @Override
    public Tema anterior() {
        return new Hidrodinamica();
    }

    @Override
    public Image getImagen2() {
       return imagen2;
    }
    
    
}
