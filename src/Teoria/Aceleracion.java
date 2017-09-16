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
public class Aceleracion extends Tema {
    String texto="\n\n Vector de aceleración media: \n\n\n Vector Aceleración Instantanea: "
            +"\n\n\nCuando la aceleración es mayor a 0 se dice que la velocidad del objeto  aumenta, cuando es menor a cero la velocidad disminuye (el objeto frena) y cuando es igual a 0 se dice que la velocidad del objeto es constante. ";
    String titulo= "Aceleración";
    Image imagen2=new Image(getClass().getResourceAsStream("aceleracion2.jpg"));
    Image imagen1=new Image(getClass().getResourceAsStream("aceleracion1.jpg"));
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
        this.texto=texto;
    }

    @Override
    public Tema siguiente() {
        return new MRU();
    }

    @Override
    public Tema anterior() {
        return new Velocidad();
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
