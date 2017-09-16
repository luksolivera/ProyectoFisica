/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import javafx.fxml.FXML;
import javafx.scene.shape.Line;

/**
 *
 * @author Usuario
 */
public class AristaGrafico {
   
    Vertice [] vertices= new Vertice[2];
    @FXML
    Line linea;

    public AristaGrafico(Vertice destino, Vertice origen, Line linea) {
        vertices[0]=origen;
        vertices [1]=destino;
        this.linea = linea;
    }

    public Line getLinea() {
        return linea;
    }

    public Vertice[] getVertices(){
        return vertices;
    }
}
