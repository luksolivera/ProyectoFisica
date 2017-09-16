/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author USER
 */
public class Arista {
    Vertice VerticeDestino;
    Ruta Datos;
	
    public Arista(Vertice VerticeDestino, Ruta datos) {
	this.VerticeDestino= VerticeDestino;
	this.Datos=datos;
    }
    public Vertice getVerticeDestino(){
	return this.VerticeDestino;
    }
    public Ruta getDatos() {
    	return this.Datos;
    }
}
