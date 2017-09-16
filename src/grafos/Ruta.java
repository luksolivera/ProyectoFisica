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
public class Ruta {
    	double Distancia;
	double VelocidadMaxima;
	double PesoMaximo;
	
	public Ruta() {}
	public Ruta(double distancia, double VelocidadMaxima, double PesoMaximo) {
		this.Distancia=distancia;
		this.VelocidadMaxima=VelocidadMaxima;
		this.PesoMaximo=PesoMaximo;

	}
	
	public double getRutaDistancia(){
		return this.Distancia;
	}
	public double getRutaVel_Max(){
		return this.VelocidadMaxima;
	}
	public double getRutaPeso_Max(){
		return this.PesoMaximo;
	}
	public void setRutaDistancia(double distancia){
		this.Distancia = distancia;
	}
	public void setRutaVel_Max(double vel_maxima){
		this.VelocidadMaxima = vel_maxima;
	}
	public void setRutaPeso_Max(double peso_maximo){
		this.PesoMaximo = peso_maximo;
	}
}
