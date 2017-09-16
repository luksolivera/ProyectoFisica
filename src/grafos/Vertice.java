/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
/**
 *
 * @author NIKYYYY
 */
public class Vertice {
    Object Dato;
    int posicion;
    ArrayList <Arista> ListaDeAdyacentes= new ArrayList<Arista>();
	
	/*Constructores*/
	
    public Vertice() {
//	this.ListaDeAdyacentes=new ArrayList <Arista>();
    }
    public Vertice(int posicion) {
//	this.ListaDeAdyacentes=new ArrayList <Arista>();
	this.posicion=posicion;
    }
    public Vertice(int posicion, Object datos){
//	this.ListaDeAdyacentes=new ArrayList <Arista>();
	this.posicion=posicion;
	this.Dato=datos;
    }
    public Vertice(Object datos){
//        this.ListaDeAdyacentes=new ArrayList <Arista>();
        this.Dato=datos;
    }
	
	/*Metodos*/
	
    public void agregarArista(Arista conexion) {
	ListaDeAdyacentes.add(conexion);
    }
	
    /*Get y sets*/
    public Object getDato() {
    	return this.Dato;
    }
    public void setDato(Object Datos) {
    	this.Dato=Datos;
    }
	
    public int getPosicion() {
    	return this.posicion;
    }
	
    public void setPosicion(int posicion){
	this.posicion=posicion;
    }
	
    public ArrayList<Arista> getListaDeAdyacentes() {
	return this.ListaDeAdyacentes;
    }
}
