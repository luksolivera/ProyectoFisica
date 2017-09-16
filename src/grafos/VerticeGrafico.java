/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import javafx.scene.shape.Circle;

/**
 *
 * @author USER
 */
public class VerticeGrafico {
    Vertice vertice;
    Circle circulo;

    public VerticeGrafico(Vertice vertice, Circle circulo) {
        this.vertice = vertice;
        this.circulo = circulo;
    }

    public Circle getCirculo() {
        return circulo;
    }

    public Vertice getVertice() {
        return vertice;
    }
    
    
}
