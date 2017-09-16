/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

public class Autos {
    private String tipo;		//Tipo vehiculo
    private String modelo;		//Modelo vehiculo
    private double masa;			//Masa vehiculo
    private double aceleracion ;	        //Aceleración máxima de 0 a 100 km/h
    private double dinamica;			//Coeficiente Aerodinámico
    public Autos(){}
    public Autos(String tipo, String modelo,double masa, double aceleracion, double dinamica){ // contructor con todos los datos
          this.tipo=tipo;
          this.modelo= modelo;
          this.masa=masa;
          this.dinamica=dinamica;
          this.aceleracion=27.8/aceleracion;
    } 
    public double getAceleracion(){
	return this.aceleracion;
    }
    public double getDinamica(){
	return this.dinamica;
    }
    public double getMasa(){
        return this.masa;
    }
    public String getModelo(){
	return this.modelo;
    }
    public String getTipo(){
        return this.tipo;
    }
    public void setAceleracionSinCalcular(double aceleracion){
        this.aceleracion=27.8/aceleracion;
    }
    public void setAceleracion(double aceleracion){
        this.aceleracion=aceleracion;
    }
    public void setDinamica(double dinamica){
        this.dinamica=dinamica;
    }
    public void setMasa(double masa){
        this.masa=masa;
    }
    public void setModelo(String modelo){
        this.modelo= modelo;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    
}