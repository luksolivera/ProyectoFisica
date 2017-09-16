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
public abstract class Tema {
    public abstract Image getImagen2();
    public abstract Image getImagen1();
    public abstract String getTexto();
    public abstract void setTexto(String texto);
    public abstract Tema siguiente();
    public abstract Tema anterior();
    public abstract String getTitulo();
    public abstract void setTitulo(String titulo);
    
}
