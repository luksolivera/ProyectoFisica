package grafos;
import generales.Fisica;
import java.util.ArrayList;
public class CalculoCombustible extends Calculo{
	public CalculoCombustible(Autos vehiculo){
		super(vehiculo);
	}
	@Override
	public double calcular(ArrayList<Vertice> recorrido) {
		double resultado = 0;
		for(int i=0;i != recorrido.size()-1;i++){
			Ciudad origen = (Ciudad)recorrido.get(i).getDato();
			Ciudad destino = (Ciudad)recorrido.get(i+1).getDato();
			Ruta ruta = this.matrizAdyacencia[recorrido.get(i).getPosicion()][recorrido.get(i+1).getPosicion()].getDatos();
                        double sen0 = (destino.getCiudadAltura()-origen.getCiudadAltura())/ruta.getRutaDistancia();
                        double w1 = Fisica.jouleMRU(0,origen.getCiudadArea(),this.vehiculo.getDinamica(),origen.getCiudadVelocidadMedia(),0,0,0);     //Trabajo en la ciudad
                        double t2 = Fisica.mruvTiempoVelocidad(ruta.getRutaVel_Max(), 0,this.vehiculo.getAceleracion());        //Tiempo en acelerar
                        double d2 = Fisica.mruvPosicionFinal(0,0, this.vehiculo.getAceleracion(), t2);     //Distancia que recorre en acelerar
                        double w2 = Fisica.jouleMRUV(0,d2,this.vehiculo.getMasa(),this.vehiculo.getAceleracion(),sen0,this.vehiculo.getDinamica());     //Trabajo en acelerar
                        double w3 = Fisica.jouleMRU(0,ruta.getRutaDistancia()-2*d2,this.vehiculo.getDinamica(), ruta.getRutaVel_Max(), this.vehiculo.getMasa(),Fisica.gravedad, sen0);   //Trabajo en ruta constante
                        resultado += w1+2*w2+w3; 
		}
                
                Ciudad destino=(Ciudad)(recorrido.get(recorrido.size()-1)).getDato();
                resultado= resultado+Fisica.jouleMRU(0,destino.getCiudadArea(),this.vehiculo.getDinamica(),destino.getCiudadVelocidadMedia(),0,0,0);
                resultado=(resultado)/(500000);
		return resultado;
	}
}
