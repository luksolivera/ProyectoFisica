package grafos;
import generales.Fisica;
import java.util.ArrayList;
public class CalculoTiempo extends Calculo{
	public CalculoTiempo(Autos auto){
            super(auto);
        }
	@Override
	public double calcular(ArrayList<Vertice> recorrido) {
		double resultado = 0;
		for(int i=0;i != recorrido.size()-1;i++){
			Ciudad origen = (Ciudad)recorrido.get(i).getDato();
			Ciudad destino = (Ciudad)recorrido.get(i+1).getDato();
			Ruta ruta = this.matrizAdyacencia[recorrido.get(i).getPosicion()][recorrido.get(i+1).getPosicion()].getDatos();
                        double t1 = Fisica.mruTiempo(origen.getCiudadVelocidadMedia(),origen.getCiudadArea());      //Tiempo en atravezar ciudad
                        double t2 = Fisica.mruvTiempoVelocidad(ruta.getRutaVel_Max(), 0,this.vehiculo.getAceleracion());  //Tiempo en llegar a velocidad maxima
                        double d2 = Fisica.mruvPosicionFinal(0,0, this.vehiculo.getAceleracion(), t2);  //Distancia en que acelera
                        double t3 = Fisica.mruTiempo(ruta.getRutaVel_Max(), ruta.getRutaDistancia()- (2*d2)); //Tiempo en pasar ruta constante
                       resultado += t1+2*t2+t3;
		}
                Ciudad destino=(Ciudad)(recorrido.get(recorrido.size()-1)).getDato();
                resultado=resultado+Fisica.mruTiempo(destino.getCiudadVelocidadMedia(),destino.getCiudadArea());
		return resultado/3600.0;
	}
	
}


