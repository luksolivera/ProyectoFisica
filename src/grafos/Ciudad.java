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
public class Ciudad {
        public String Nombre;
	double VelocidadPromedio;
	double Area;
	double AlturaMar;
	
	Ciudad(){}
	
	Ciudad(String Nombre,double Velocidad_Media, double Area, double AlturaMar ){
		this.Nombre=Nombre;
		this.VelocidadPromedio=Velocidad_Media;
		this.Area=Area;
		this.AlturaMar=AlturaMar;

	}
	
	public String getCiudadNombre(){
		return this.Nombre;
	}
	public double getCiudadAltura(){
		return this.AlturaMar;			
	}
	public double getCiudadArea(){
		return this.Area;			
	}
	public double getCiudadVelocidadMedia(){
		return this.VelocidadPromedio;			
	}
	public void setCiudadNombre(String nombre){
		this.Nombre = nombre;
	}
	public void setCiudadAltura(double altura){
		this.AlturaMar = altura;			
	}
	public void setCiudadArea(double distancia){
		this.Area = distancia;			
	}
	public void setCiudadVelocidadMedia(double vel_media){
		this.VelocidadPromedio = vel_media;			
	}
}
