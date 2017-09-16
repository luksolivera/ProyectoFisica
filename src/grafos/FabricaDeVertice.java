/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import generales.Cola;
import java.util.ArrayList;
import javafx.scene.shape.Circle;

/**
 *
 * @author Usuario
 */
public class FabricaDeVertice {
    Cola nodosGraficos;

    public FabricaDeVertice() {
        nodosGraficos=new Cola();
    }
    
    public void crearVertice(String nombre, double VelocidadMedia, double distancia, double altura){
        Grafo grafo=Grafo.getInstance();
        Ciudad ciudad=new Ciudad(nombre, VelocidadMedia, distancia, altura);
        Vertice vertice= new Vertice(ciudad);
        grafo.agregarVertice(vertice);
        Circle circulo=(Circle) nodosGraficos.pop();
        VerticeGrafico verticeGrafico= new VerticeGrafico(vertice, circulo);
        grafo.agregarVerticeGrafico(verticeGrafico);
    }

    public void setNodosGraficos(ArrayList<Circle> circulos) {
        nodosGraficos.setCola(circulos);
    }
}
