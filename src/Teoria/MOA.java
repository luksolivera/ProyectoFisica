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
public class MOA extends Tema{
    String texto;
    String titulo= "Movimiento Oscilatorio Amortiguado";
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
        return new MOF();
    }

    @Override
    public Tema anterior() {
        return new MASAngular();
    }

    @Override
    public Image getImagen1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Image getImagen2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
